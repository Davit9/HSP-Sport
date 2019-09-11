package am.chronograph.web.controller.student;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import am.chronograph.service.group.GroupService;
import am.chronograph.service.student.StudentService;
import am.chronograph.web.bean.student.StudentBean;
import am.chronograph.web.controller.base.BaseController;
import am.chronograph.web.integration.Spring;

/**
 * Controller class will handle actions from student.xhtml page...
 * 
 * @author davit
 *
 */
@Named("studentController")
@ViewScoped
public class StudentController extends BaseController implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 4792054921868178839L;

	@Inject
	@Spring
	private transient StudentService studentService;
	
	@Inject
	@Spring
	private transient GroupService groupService;

	private StudentBean studentBean;
	
	private List<StudentBean> students;

	/*
	 * (non-Javadoc)
	 * 
	 * @see am.chronograph.web.controller.base.BaseController#init()
	 */
	@PostConstruct
	public void init() {
		super.init();

		studentBean = new StudentBean();
		studentBean.setGroups(groupService.getAllItems());

		students = studentService.getAll();

	}
	
	/**
     * ActionListener method called when 'Create' clicked
     */
    public void onCreateStudent() {
        if(isValidStudent()) {
            return;
        }
        
        studentService.create(studentBean); 
        
        students = studentService.getAll();
        
        studentBean = new StudentBean();
        
        addInfoMessage("studentSuccessSave");
    }
    
    /**
	 * ActionListener method called when 'Update' clicked 
	 * 
	 */
	public void onUpdateStudent() {
		if (isValidStudent()) {
			return;
		}

		studentService.update(studentBean); 
        
        students = studentService.getAll();
        
        studentBean = new StudentBean();

		addInfoMessage("studentSuccessUpdate");
	}
	
	/**
	 * Method called when user clicks on any row in contracts table, to edit
	 * selected exam...
	 */
	public void onEditStudent(StudentBean selectedStudentBean) {
		studentBean = new StudentBean(selectedStudentBean);
		
		studentBean.setGroups(groupService.getAllItems());

		scrollTo("studentForm:studentCreatePanel");
	}
	
	/**
	 * Method called when 'Cancel' button clicked.
	 */
	public void onCancel() {
		studentBean = new StudentBean();

		scrollTo("studentForm:studentListPanel");
	}
    
    /**
	 * ActionListener method called when Delete icon is clicked to delete selected
	 * StudentBean...
	 * 
	 * @param selectedContractBean
	 */
	public void onRemoveStudent(StudentBean selectedStudentBean) {
		studentService.delete(selectedStudentBean.getId());
		students = studentService.getAll();

		if (selectedStudentBean.getId().equals(studentBean.getId())) {
			studentBean = new StudentBean();
		}
	}

    /**
     * Method for Person validation -- for inserting/updating corresponding data
	 * into database...
	 * 
     * @return
     */
	private boolean isValidStudent() {
		boolean noError = false;

		if (StringUtils.isBlank(studentBean.getFirstName())) {
			addErrorMessage("studentForm:firstName", "contractValidationMandatory");

			noError = true;
		}

		if (StringUtils.isBlank(studentBean.getLastName())) {
			addErrorMessage("studentForm:lastName", "contractValidationMandatory");

			noError = true;
		}

		if (StringUtils.isBlank(studentBean.getMiddleName())) {
			addErrorMessage("studentForm:middleName", "contractValidationMandatory");

			noError = true;
		}
		
		if (StringUtils.isBlank(studentBean.getEmail())) {
			addErrorMessage("studentForm:email", "contractValidationMandatory");

			noError = true;
		}
		
		if(studentBean.getDateOfBirth() == null) {
            addErrorMessage("studentForm:dateOfBirth", "contractValidationMandatory");
            
            noError = true;
        }
		
		if (studentBean.getSelectedGroupId() == null) {
			addErrorMessage("studentForm:group", "contractValidationMandatory");

			noError = true;
		}

		return noError;
	}
	

	/**
	 * @return the groupService
	 */
	public GroupService getGroupService() {
		return groupService;
	}

	/**
	 * @param groupService the groupService to set
	 */
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * @return the studentBean
	 */
	public StudentBean getStudentBean() {
		return studentBean;
	}

	/**
	 * @param studentBean the studentBean to set
	 */
	public void setStudentBean(StudentBean studentBean) {
		this.studentBean = studentBean;
	}

	/**
	 * @return the students
	 */
	public List<StudentBean> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<StudentBean> students) {
		this.students = students;
	}
	
}