package am.chronograph.domain.course;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import am.chronograph.domain.AuditAwareEntity;
import am.chronograph.domain.group.Group;

/**
 * class which contains information about courses
 * 
 * @author davit
 *
 */
@Entity
@Table(name = "course")
public class Course extends AuditAwareEntity {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 3921233039563189705L;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<Group> group;

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
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Set<Group> group) {
		this.group = group;
	}
}