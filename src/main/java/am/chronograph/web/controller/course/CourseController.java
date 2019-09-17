package am.chronograph.web.controller.course;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import am.chronograph.service.course.CourseService;
import am.chronograph.web.bean.course.CourseBean;
import am.chronograph.web.controller.base.BaseController;
import am.chronograph.web.integration.Spring;

/**
 * Controller class will handle actions from course.xhtml page...
 * 
 * @author davit
 *
 */
@Named("courseController")
@ViewScoped
public class CourseController extends BaseController implements Serializable {

	/** use serialVersionUID from JDK 1.0.2 for interoperability */
	private static final long serialVersionUID = 4792054921868178839L;

	@Inject
	@Spring
	private transient CourseService courseService;

	private CourseBean courseBean;
	
	private List<CourseBean> courses;

	/*
	 * (non-Javadoc)
	 * 
	 * @see am.chronograph.web.controller.base.BaseController#init()
	 */
	@PostConstruct
	public void init() {
		super.init();

		courseBean = new CourseBean();

		courses = courseService.getAll();

	}
	
	/**
     * ActionListener method called when 'Create' clicked
     */
    public void onCreateCourse() {
        if(!isValidCourse()) {
            return;
        }
        
        courseService.create(courseBean); 
        
        courses = courseService.getAll();
        
        courseBean = new CourseBean();
        
        addInfoMessage("dataSuccessSave");
    }
    
    /**
	 * ActionListener method called when 'Update' clicked 
	 * 
	 */
	public void onUpdateCourse() {
		if (!isValidCourse()) {
			return;
		}

		courseService.update(courseBean); 
        
        courses = courseService.getAll();
        
        courseBean = new CourseBean();

		addInfoMessage("dataSuccessUpdate");
	}
	
	/**
	 * Method called when user clicks on any row in contracts table, to edit
	 * selected exam...
	 */
	public void onEditCourse(CourseBean selectedCourseBean) {
		courseBean = new CourseBean(selectedCourseBean);

		scrollTo("courseForm:courseCreatePanel");
	}
	
	/**
	 * Method called when 'Cancel' button clicked.
	 */
	public void onCancel() {
		courseBean = new CourseBean();

		scrollTo("courseForm:courseListPanel");
	}
    
    /**
	 * ActionListener method called when Delete icon is clicked to delete selected
	 * StudentBean...
	 * 
	 * @param selectedCourseBean
	 */
	public void onRemoveCourse(CourseBean selectedCourseBean) {
		courseService.delete(selectedCourseBean.getId());
		courses = courseService.getAll();

		if (selectedCourseBean.getId().equals(courseBean.getId())) {
			courseBean = new CourseBean();
		}
	}

    /**
     * Method for Person validation -- for inserting/updating corresponding data
	 * into database...
	 * 
     * @return
     */
	private boolean isValidCourse() {
		boolean noError = true;

		if (StringUtils.isBlank(courseBean.getName())) {
			addErrorMessage("courseForm:name", "contractValidationMandatory");

			noError = false;
		}

		return noError;
	}

	/**
	 * @return the courseService
	 */
	public CourseService getCourseService() {
		return courseService;
	}

	/**
	 * @param courseService the courseService to set
	 */
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * @return the courseBean
	 */
	public CourseBean getCourseBean() {
		return courseBean;
	}

	/**
	 * @param courseBean the courseBean to set
	 */
	public void setCourseBean(CourseBean courseBean) {
		this.courseBean = courseBean;
	}

	/**
	 * @return the courses
	 */
	public List<CourseBean> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<CourseBean> courses) {
		this.courses = courses;
	}
}