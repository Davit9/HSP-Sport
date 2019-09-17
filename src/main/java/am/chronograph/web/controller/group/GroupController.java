package am.chronograph.web.controller.group;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import am.chronograph.service.course.CourseService;
import am.chronograph.service.group.GroupService;
import am.chronograph.web.bean.group.GroupBean;
import am.chronograph.web.controller.base.BaseController;
import am.chronograph.web.integration.Spring;

/**
 * Controller class will handle actions from group.xhtml page...
 * 
 * @author davit
 *
 */
@Named("groupController")
@ViewScoped
public class GroupController extends BaseController implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 7458663210927229183L;

	@Inject
	@Spring
	private transient GroupService groupService;
	
	@Inject
	@Spring
	private transient CourseService courseService;

	private GroupBean groupBean;
	
	private List<GroupBean> groups;

	/*
	 * (non-Javadoc)
	 * 
	 * @see am.chronograph.web.controller.base.BaseController#init()
	 */
	@PostConstruct
	public void init() {
		super.init();

		groupBean = new GroupBean();
		groupBean.setCourses(courseService.getAllItems());
		
		groups = groupService.getAll();

	}
	
	/**
     * ActionListener method called when 'Create' clicked
     */
    public void onCreateGroup() {
        if(!isValidGroup()) {
            return;
        }
        
        groupService.create(groupBean); 
        
        groups = groupService.getAll();
        
        groupBean = new GroupBean();
        
        addInfoMessage("dataSuccessSave");
    }
    
    /**
	 * ActionListener method called when 'Update' clicked 
	 * 
	 */
	public void onUpdateGroup() {
		if (!isValidGroup()) {
			return;
		}

		groupService.update(groupBean); 
        
        groups = groupService.getAll();
        
        groupBean = new GroupBean();

		addInfoMessage("dataSuccessUpdate");
	}
	
	/**
	 * Method called when user clicks on any row in contracts table, to edit
	 * selected exam...
	 */
	public void onEditGroup(GroupBean selectedGroupBean) {
		
		groupBean = new GroupBean(selectedGroupBean);
		
		groupBean.setCourses(courseService.getAllItems());

		scrollTo("groupForm:groupCreatePanel");
	}
	
	/**
	 * Method called when 'Cancel' button clicked.
	 */
	public void onCancel() {
		groupBean = new GroupBean();

		scrollTo("groupForm:groupListPanel");
	}
    
    /**
	 * ActionListener method called when Delete icon is clicked to delete selected
	 * StudentBean...
	 * 
	 * @param selectedGroupBean
	 */
	public void onRemoveGroup(GroupBean selectedGroupBean) {
		groupService.delete(selectedGroupBean.getId());
		groups = groupService.getAll();

		if (selectedGroupBean.getId().equals(groupBean.getId())) {
			groupBean = new GroupBean();
		}
	}

    /**
     * Method for Group validation -- for inserting/updating corresponding data
	 * into database...
	 * 
     * @return
     */
	private boolean isValidGroup() {
		boolean noError = true;

		if (StringUtils.isBlank(groupBean.getName())) {
			addErrorMessage("groupForm:name", "contractValidationMandatory");

			noError = false;
		}

		if (groupBean.getStartDate() == null) {
			addErrorMessage("groupForm:startDate", "contractValidationMandatory");

			noError = false;
		}

		if (groupBean.getStudentCount() == null) {
			addErrorMessage("groupForm:studentCount", "contractValidationMandatory");

			noError = false;
		}
		
		if (groupBean.getSelectedCourseId() == null) {
			addErrorMessage("groupForm:course", "contractValidationMandatory");

			noError = false;
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
	 * @return the groupBean
	 */
	public GroupBean getGroupBean() {
		return groupBean;
	}

	/**
	 * @param groupBean the groupBean to set
	 */
	public void setGroupBean(GroupBean groupBean) {
		this.groupBean = groupBean;
	}

	/**
	 * @return the groups
	 */
	public List<GroupBean> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<GroupBean> groups) {
		this.groups = groups;
	}
}