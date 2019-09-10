package am.chronograph.service.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import am.chronograph.dao.group.GroupDao;
import am.chronograph.dao.student.StudentDao;
import am.chronograph.domain.student.Student;
import am.chronograph.web.bean.student.StudentBean;

/**
 * Implements StudentService interface...
 * @author davitpetrosyan
 *
 */
@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private GroupDao groupDao;

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.student.StudentService#create(am.chronograph.web.bean.student.StudentBean)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void create(StudentBean studentBean) {
		studentDao.save(initDomainByBean(studentBean));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.student.StudentService#update(am.chronograph.web.bean.student.StudentBean)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(StudentBean studentBean) {
		studentDao.save(initDomainByBean(studentBean));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.student.StudentService#delete(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		studentDao.delete(studentDao.getById(id));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.student.StudentService#getAll()
	 */
	@Override
	public List<StudentBean> getAll() {
		List<Student> students = studentDao.getAll();

		return initBeanListByDomainList(students);
	}
	
	/**
	 * Initialize Domain by given Bean...
	 * 
	 * @param studentBean
	 * @return
	 */
	private Student initDomainByBean(StudentBean studentBean) {
		Student student = (studentBean.getId() != null) ? studentDao.getById(studentBean.getId())
				: new Student();

		student.setId(studentBean.getId());
		student.setFirstName(studentBean.getFirstName());
		student.setLastName(studentBean.getLastName());
		student.setMiddleName(studentBean.getMiddleName());
		student.setEmail(studentBean.getEmail());
		student.setDateOfBirth(studentBean.getDateOfBirth());
		
		student.setGroups((groupDao.getById(studentBean.getSelectedGroupId())));

		return student;
	}

	/**
	 * Initialize Bean List by given Domain list...
	 * 
	 * @param countries
	 * @return
	 */
	private List<StudentBean> initBeanListByDomainList(List<Student> students) {
		List<StudentBean> studentBean = new ArrayList<>();
		for (Student student : students) {
			studentBean.add(initBeanByDomain(student));
		}

		return studentBean;
	}
	
	/**
	 * Initialize Bean by given Domain...
	 * 
	 * @param country
	 * @return
	 */
	private StudentBean initBeanByDomain(Student student) {
		StudentBean studentBean = new StudentBean();

		studentBean.setId(student.getId());
		studentBean.setFirstName(student.getFirstName());
		studentBean.setLastName(student.getLastName());
		studentBean.setMiddleName(student.getMiddleName());
		studentBean.setEmail(student.getEmail());
		studentBean.setDateOfBirth(student.getDateOfBirth());
		studentBean.setGroupName(student.getGroups().getName());
		studentBean.setSelectedGroupId((student.getGroups().getId()));
		
		return studentBean;
	}
}