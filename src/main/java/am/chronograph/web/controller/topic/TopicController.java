package am.chronograph.web.controller.topic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import am.chronograph.service.course.CourseService;
import am.chronograph.service.topic.TopicService;
import am.chronograph.web.bean.topic.TopicBean;
import am.chronograph.web.controller.base.BaseController;
import am.chronograph.web.integration.Spring;

/**
 * Controller class will handle actions from topic.xhtml page...
 * 
 * @author gevorg
 *
 */
@Named("topicController")
@ViewScoped
public class TopicController extends BaseController implements Serializable {

	private static final long serialVersionUID = 3240781877524219416L;

	@Inject
	@Spring
	private transient TopicService topicService;
	
	@Inject
	@Spring
	private transient CourseService courseService;

	private TopicBean topicBean;
	private List<TopicBean> topics;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see am.chronograph.web.controller.base.BaseController#init()
	 */
	@PostConstruct
	public void init() {
		super.init();

		topicBean = new TopicBean();
		topicBean.setCourses(courseService.getAllItems());
		
		topics = topicService.getAll();

	}
	
	/**
     * ActionListener method called when 'Create' clicked
     */
    public void onCreateTopic() {
        if(isValidTopic()) {
            return;
        }
        
        topicService.create(topicBean); 
        
        topics = topicService.getAll();
        
        topicBean = new TopicBean();
        
        addInfoMessage("dataSuccessSave");
    }
    
    /**
	 * ActionListener method called when 'Update' clicked 
	 * 
	 */
	public void onUpdateTopic() {
		if (isValidTopic()) {
			return;
		}

		topicService.update(topicBean); 
        
		topics = topicService.getAll();
        
		topicBean = new TopicBean();

		addInfoMessage("dataSuccessUpdate");
	}
	
	/**
	 * Method called when 'Cancel' button clicked.
	 */
	public void onCancel() {
		topicBean = new TopicBean();

		scrollTo("topicForm:topicListPanel");
	}
	
	/**
	 * Method called when user clicks on any row in contracts table, to edit
	 * selected exam...
	 */
	public void onEditTopic(TopicBean selectedTopicBean) {
		
		topicBean = new TopicBean(selectedTopicBean);
		
		topicBean.setCourses(courseService.getAllItems());

		scrollTo("topicForm:topicCreatePanel");
	}
	
	/**
	 * ActionListener method called when Delete icon is clicked to delete selected
	 * TopicBean...
	 * 
	 * @param selectedContractBean
	 */
	public void onRemoveTopic(TopicBean selectedTopicBean) {
		topicService.delete(selectedTopicBean.getId());
		topics = topicService.getAll();

		if (selectedTopicBean.getId().equals(topicBean.getId())) {
			topicBean = new TopicBean();
		}
	}

	/**
     * Method for Topic validation -- for inserting/updating corresponding data
	 * into database...
	 * 
     * @return
     */
	private boolean isValidTopic() {
		boolean noError = false;

		if (StringUtils.isBlank(topicBean.getTopicName())) {
			addErrorMessage("topicForm:name", "contractValidationMandatory");

			noError = true;
		}

		if (topicBean.getDuration() == 0) {
			addErrorMessage("topicForm:duration", "contractValidationMandatory");

			noError = true;
		}

		return noError;
	}

	/**
	 * @return the topicService
	 */
	public TopicService getTopicService() {
		return topicService;
	}

	/**
	 * @param topicService the topicService to set
	 */
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	/**
	 * @return the topicBean
	 */
	public TopicBean getTopicBean() {
		return topicBean;
	}

	/**
	 * @param topicBean the topicBean to set
	 */
	public void setTopicBean(TopicBean topicBean) {
		this.topicBean = topicBean;
	}

	/**
	 * @return the topics
	 */
	public List<TopicBean> getTopics() {
		return topics;
	}

	/**
	 * @param topics the topics to set
	 */
	public void setTopics(List<TopicBean> topics) {
		this.topics = topics;
	}
}
