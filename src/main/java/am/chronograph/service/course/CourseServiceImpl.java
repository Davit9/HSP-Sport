package am.chronograph.service.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import am.chronograph.dao.course.CourseDao;
import am.chronograph.domain.course.Course;
import am.chronograph.web.bean.course.CourseBean;

/**
 * Implements CourseService interface...
 * @author davitpetrosyan
 *
 */
@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.course.CourseService#create(CourseBean)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void create(CourseBean courseBean) {
		courseDao.save(initDomainByBean(courseBean));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.course.CourseService#update(CourseBean)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(CourseBean courseBean) {
		courseDao.save(initDomainByBean(courseBean));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.course.CourseService#delete(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		courseDao.delete(courseDao.getById(id));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.course.CourseService#getAll()
	 */
	@Override
	public List<CourseBean> getAll() {
		List<Course> courses = courseDao.getAll();

		return initBeanListByDomainList(courses);
	}
	
	/**
	 * Initialize Domain by given Bean...
	 * 
	 * @param courseBean
	 * @return
	 */
	private Course initDomainByBean(CourseBean courseBean) {
		Course course = (courseBean.getId() != null) ? courseDao.getById(courseBean.getId())
				: new Course();

		course.setId(courseBean.getId());
		course.setName(courseBean.getName());

		return course;
	}

	/**
	 * Initialize Bean List by given Domain list...
	 * 
	 * @param courses
	 * @return
	 */
	private List<CourseBean> initBeanListByDomainList(List<Course> courses) {
		List<CourseBean> courseBean = new ArrayList<>();
		for (Course course : courses) {
			courseBean.add(initBeanByDomain(course));
		}

		return courseBean;
	}
	
	/**
	 * Initialize Bean by given Domain...
	 * 
	 * @param course
	 * @return
	 */
	private CourseBean initBeanByDomain(Course course) {
		CourseBean courseBean = new CourseBean();

		courseBean.setId(course.getId());
		courseBean.setName(course.getName());

		return courseBean;
	}
}