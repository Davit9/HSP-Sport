package am.chronograph.dao.group;

import am.chronograph.dao.GenericDao;
import am.chronograph.domain.group.Group;

public interface GroupDao extends GenericDao<Group> {
	
	String getCourseName();

}
