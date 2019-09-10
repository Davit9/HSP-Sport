package am.chronograph.domain.group;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import am.chronograph.domain.AuditAwareEntity;
import am.chronograph.domain.course.Course;
import am.chronograph.domain.student.Student;

/**
 * class which contains information about groups
 * 
 * @author davit
 *
 */
@Entity
@Table(name = "groups")
public class Group extends AuditAwareEntity {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 3921233039563189705L;

	@Column(name = "name")
	private String name;
	
	@Column(name = "student_count")
	private Integer studentCount;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
	
	@OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private Set<Student> student;

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
	 * @return the student
	 */
	public Set<Student> getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Set<Student> student) {
		this.student = student;
	}	
}