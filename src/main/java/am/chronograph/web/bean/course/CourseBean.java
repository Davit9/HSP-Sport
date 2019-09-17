package am.chronograph.web.bean.course;

import java.util.Set;

import am.chronograph.domain.group.Group;
import am.chronograph.domain.topic.Topic;
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

	private String name;	
	private Set<Group> groups;
	private Set<Topic> topics;

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
		groups = courseBean.getGroup();
		topics = courseBean.getTopics();
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
	 * @return the group
	 */
	public Set<Group> getGroup() {
		return groups;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Set<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @return the topics
	 */
	public Set<Topic> getTopics() {
		return topics;
	}

	/**
	 * @param topics the topics to set
	 */
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
}