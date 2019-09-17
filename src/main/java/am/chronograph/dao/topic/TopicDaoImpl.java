package am.chronograph.dao.topic;

import org.springframework.stereotype.Repository;

import am.chronograph.dao.GenericDaoImpl;
import am.chronograph.domain.topic.Topic;

/**
 * The Dao class which contains implementation {@link TopicDao} and {@link GenericDaoImpl}
 * 
 * @author gevorg
 *
 */
@Repository
public class TopicDaoImpl extends GenericDaoImpl<Topic> implements TopicDao {

}
