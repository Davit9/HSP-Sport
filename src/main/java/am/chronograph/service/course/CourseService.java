package am.chronograph.service.course;

import java.util.List;

import javax.faces.model.SelectItem;

import am.chronograph.web.bean.course.CourseBean;

/**
 * Provides services for getting, managing Courses.
 * 
 * @author davit
 *
 */
public interface CourseService {

	/**
	 * Creates given course...
	 * 
	 * @param courseBean
	 */
	void create(CourseBean courseBean);

	/**
	 * Updates course by given one...
	 * 
	 * @param courseBean
	 */
	void update(CourseBean courseBean);

	/**
	 * Delets course by given id...
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * Get all courses...
	 * 
	 * @return
	 */
	List<CourseBean> getAll();
	
	/**
	 * Get the select items list of all courses... 
	 * @return
	 */
	List<SelectItem> getAllItems();
}
