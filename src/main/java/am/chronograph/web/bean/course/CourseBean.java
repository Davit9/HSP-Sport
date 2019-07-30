package am.chronograph.web.bean.course;

import am.chronograph.web.bean.BaseBean;

/**
 * Bean class corresponds to Courses. Will contain presentation layer related
 * data...
 * 
 * @author davit
 *
 */
public class CourseBean extends BaseBean {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = -1198241280161150702L;

	private Long id;
	private String name;	

	/**
	 * default constructor
	 */
	public CourseBean() {
	}
	
	/**
	 * Copy constructor...
	 * 
	 * @param courseBean
	 */
	public CourseBean(CourseBean courseBean) {
		id = courseBean.getId();
		name = courseBean.getName();
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}