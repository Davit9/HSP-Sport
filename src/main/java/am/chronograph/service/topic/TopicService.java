package am.chronograph.service.topic;

import java.util.List;

import javax.faces.model.SelectItem;

import am.chronograph.web.bean.topic.TopicBean;

/**
 * Provides services for getting, managing Topic.
 * 
 * @author gevorg
 *
 */
public interface TopicService {

	/**
	 * Creates given topic...
	 * 
	 * @param topicBean
	 */
	void create(TopicBean topicBean);

	/**
	 * Updates topic by given one...
	 * 
	 * @param topicBean
	 */
	void update(TopicBean topicBean);

	/**
	 * Delets topic by given id...
	 * 
	 * @param id
	 */
	void delete(Long id);

	/**
	 * Get all topics...
	 * 
	 * @return
	 */
	List<TopicBean> getAll();
	
	/**
	 * Get the select items list of all topics... 
	 * @return
	 */
	List<SelectItem> getAllItems();
}
