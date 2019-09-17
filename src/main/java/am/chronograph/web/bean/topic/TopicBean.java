package am.chronograph.web.bean.topic;

import java.util.List;

import javax.faces.model.SelectItem;

import am.chronograph.domain.course.Course;
import am.chronograph.web.bean.BaseBean;

/**
 * Bean class corresponds to Topics. Will contain presentation layer related
 * data...
 * 
 * @author gevorg
 *
 */
public class TopicBean extends BaseBean {

	private static final long serialVersionUID = 4588480982676704501L;

	private String topicName;
	private String courseName;
	private Course course;
	private int duration;
	
	private List<SelectItem> courses;
	private Long selectedCourseId;

	/**
	 * Default constructor
	 */
	public TopicBean() {
	}

	/**
	 * Constructor for initialization
	 * 
	 * @param topicBean
	 */
	public TopicBean(TopicBean topicBean) {
		id = topicBean.getId();
		topicName = topicBean.getTopicName();
		course = topicBean.getCourse();
		duration = topicBean.getDuration();
	}

	/**
	 * @return the topicName
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * @param topicName the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
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
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
