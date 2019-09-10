package am.chronograph.web.bean.student;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import am.chronograph.web.bean.BaseBean;

/**
 * Bean class corresponds to Students. Will contain presentation layer related
 * data...
 * 
 * @author davit
 *
 */
public class StudentBean extends BaseBean {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = -9219312217212620388L;

	private String firstName;	
	private String lastName;
	private String middleName;
	private String email;
	private Date dateOfBirth;
	private String groupName;
	
	private Long selectedGroupId;
	private List<SelectItem> groups;
	
	
	/**
	 * default constructor
	 */
	public StudentBean() {
	}
	
	/**
	 * Copy constructor...
	 * 
	 * @param contractBean
	 */
	public StudentBean(StudentBean studentBean) {
		id = studentBean.getId();
		firstName = studentBean.getFirstName();
		lastName = studentBean.getLastName();
		middleName = studentBean.getMiddleName();
		email = studentBean.getEmail();
		dateOfBirth = studentBean.getDateOfBirth();
	}
	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the selectedGroupId
	 */
	public Long getSelectedGroupId() {
		return selectedGroupId;
	}

	/**
	 * @param selectedGroupId the selectedGroupId to set
	 */
	public void setSelectedGroupId(Long selectedGroupId) {
		this.selectedGroupId = selectedGroupId;
	}

	/**
	 * @return the groups
	 */
	public List<SelectItem> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<SelectItem> groups) {
		this.groups = groups;
	}
	
	
}