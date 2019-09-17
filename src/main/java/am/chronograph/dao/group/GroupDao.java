package am.chronograph.dao.group;

import am.chronograph.dao.GenericDao;
import am.chronograph.domain.group.Group;

/**
 * The Dao interface for accessing {@link Group} domain object.
 * 
 * @author gevorg
 *
 */
public interface GroupDao extends GenericDao<Group> {
	
	String getCourseName();

}
