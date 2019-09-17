package am.chronograph.service.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import am.chronograph.dao.course.CourseDao;
import am.chronograph.dao.topic.TopicDao;
import am.chronograph.domain.topic.Topic;
import am.chronograph.web.bean.topic.TopicBean;

@Service
@Transactional(readOnly = true)
public class TopicSerivceImpl implements TopicService {
	
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private CourseDao courseDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void create(TopicBean topicBean) {
		topicDao.save(initDomainByBean(topicBean));

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(TopicBean topicBean) {
		topicDao.save(initDomainByBean(topicBean));

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		topicDao.delete(topicDao.getById(id));

	}

	@Override
	public List<TopicBean> getAll() {
		List<Topic> topics = topicDao.getAll();

		return initBeanListByDomainList(topics);
	}

	@Override
	public List<SelectItem> getAllItems() {
		List<Topic> topics = topicDao.getAll();
		
		return topics.stream().map(topic -> new SelectItem(topic.getId(), topic.getCourse().getName()))
							  .collect(Collectors.toList()); 
	}
	
	/**
	 * Initialize Domain by given Bean...
	 * 
	 * @param topicBean
	 * @return
	 */
	private Topic initDomainByBean(TopicBean topicBean) {
		Topic topic = (topicBean.getId() != null) ? topicDao.getById(topicBean.getId())
				: new Topic();

		topic.setId(topicBean.getId());
		topic.setTopicName(topicBean.getTopicName());
		topic.setDuration(topicBean.getDuration());
		
		topic.setCourse(courseDao.getById(topicBean.getSelectedCourseId()));
		
		return topic;
	}

	/**
	 * Initialize Bean List by given Domain list...
	 * 
	 * @param topics
	 * @return
	 */
	private List<TopicBean> initBeanListByDomainList(List<Topic> topics) {
		List<TopicBean> topicBean = new ArrayList<>();
		for (Topic topic : topics) {
			topicBean.add(initBeanByDomain(topic));
		}

		return topicBean;
	}
	
	/**
	 * Initialize Bean by given Domain...
	 * 
	 * @param topic
	 * @return
	 */
	private TopicBean initBeanByDomain(Topic topic) {
		TopicBean topicBean = new TopicBean();

		topicBean.setId(topic.getId());
		topicBean.setTopicName(topic.getTopicName());
		topicBean.setDuration(topic.getDuration());
		
		topicBean.setCourseName(topic.getCourse().getName());		
		topicBean.setSelectedCourseId(topic.getCourse().getId());

		return topicBean;
	}

}
