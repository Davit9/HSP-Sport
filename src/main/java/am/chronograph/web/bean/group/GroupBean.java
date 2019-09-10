package am.chronograph.web.bean.group;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import am.chronograph.web.bean.BaseBean;

/**
 * Bean class corresponds to Groups. Will contain presentation layer related
 * data...
 * 
 * @author davit
 *
 */
public class GroupBean extends BaseBean {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = -1198241280161150702L;

	private String name;	
	private Date startDate;
	private Integer studentCount;
	private String courseName;
	
	private List<SelectItem> courses;
	private Long selectedCourseId;
	
	
	/**
	 * default constructor
	 */
	public GroupBean() {
	}
	
	/**
	 * Copy constructor...
	 * 
	 * @param groupBean
	 */
	public GroupBean(GroupBean groupBean) {
		id = groupBean.getId();
		name = groupBean.getName();
		startDate = groupBean.getStartDate();
		studentCount = groupBean.getStudentCount();
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

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the studentCount
	 */
	public Integer getStudentCount() {
		return studentCount;
	}

	/**
	 * @param studentCount the studentCount to set
	 */
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}		

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courses
	 */
	public List<SelectItem> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<SelectItem> courses) {
		this.courses = courses;
	}

	/**
	 * @return the selectedCourseId
	 */
	public Long getSelectedCourseId() {
		return selectedCourseId;
	}

	/**
	 * @param selectedCourseId the selectedCourseId to set
	 */
	public void setSelectedCourseId(Long selectedCourseId) {
		this.selectedCourseId = selectedCourseId;
	}	
}