package am.chronograph.domain.topic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import am.chronograph.domain.AuditAwareEntity;
import am.chronograph.domain.course.Course;

/**
 * class which contains information about topics
 * 
 * @author gevorg
 *
 */
@Entity
@Table(name = "topic")
public class Topic extends AuditAwareEntity {

	private static final long serialVersionUID = -6944813397567827958L;

	@Column(name = "topic_name")
	private String topicName;
	
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	
	@Column(name = "duration")
	private int duration;

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
}