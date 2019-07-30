package am.chronograph.service.student;

import java.util.List;

import am.chronograph.web.bean.student.StudentBean;

/**
 * Provides services for getting, managing Students.
 * 
 * @author davit
 *
 */
public interface StudentService {

	/**
	 * Creates given student...
	 * 
	 * @param countryBean
	 */
	void create(StudentBean countryBean);

	/**
	 * Updates student by given one...
	 * 
	 * @param countryBean
	 */
	void update(StudentBean countryBean);

	/**
	 * Delets student by given id...
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * Get all students...
	 * 
	 * @return
	 */
	List<StudentBean> getAll();
}
