package am.chronograph.service.group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import am.chronograph.dao.course.CourseDao;
import am.chronograph.dao.group.GroupDao;
import am.chronograph.domain.group.Group;
import am.chronograph.web.bean.group.GroupBean;

/**
 * Implements GroupService interface...
 * @author davitpetrosyan
 *
 */
@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private CourseDao courseDao;

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.group.GroupService#create(am.chronograph.web.bean.group.GroupBean)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void create(GroupBean groupBean) {
		groupDao.save(initDomainByBean(groupBean));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.group.GroupService#update(am.chronograph.web.bean.group.GroupBean)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(GroupBean groupBean) {
		groupDao.save(initDomainByBean(groupBean));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.group.GroupService#delete(java.lang.Long)
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		groupDao.delete(groupDao.getById(id));
		
	}

	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.group.GroupService#getAll()
	 */
	@Override
	public List<GroupBean> getAll() {
		List<Group> groups = groupDao.getAll();

		return initBeanListByDomainList(groups);
	}
	
	/*
	 * (non-Javadoc)
	 * @see am.chronograph.service.group.GroupService#getAllItems()
	 */
	@Override
	public List<SelectItem> getAllItems() {
		List<Group> groups = groupDao.getAll();
		
		return groups.stream().map(group -> new SelectItem(group.getId(), group.getName()))
							   .collect(Collectors.toList()); 
	}
	
	/**
	 * Initialize Domain by given Bean...
	 * 
	 * @param groupBean
	 * @return
	 */
	private Group initDomainByBean(GroupBean groupBean) {
		Group group = (groupBean.getId() != null) ? groupDao.getById(groupBean.getId())
				: new Group();

		group.setId(groupBean.getId());
		group.setName(groupBean.getName());
		group.setStartDate(groupBean.getStartDate());
		group.setStudentCount(groupBean.getStudentCount());
		
		group.setCourse(courseDao.getById(groupBean.getSelectedCourseId()));
		
		return group;
	}

	/**
	 * Initialize Bean List by given Domain list...
	 * 
	 * @param groups
	 * @return
	 */
	private List<GroupBean> initBeanListByDomainList(List<Group> groups) {
		List<GroupBean> groupBean = new ArrayList<>();
		for (Group group : groups) {
			groupBean.add(initBeanByDomain(group));
		}

		return groupBean;
	}
	
	/**
	 * Initialize Bean by given Domain...
	 * 
	 * @param group
	 * @return
	 */
	private GroupBean initBeanByDomain(Group group) {
		GroupBean groupBean = new GroupBean();

		groupBean.setId(group.getId());
		groupBean.setName(group.getName());
		groupBean.setStartDate(group.getStartDate());
		groupBean.setStudentCount(group.getStudentCount());
		groupBean.setCourseName(group.getCourse().getName());
		
		groupBean.setSelectedCourseId(group.getCourse().getId());

		return groupBean;
	}
}