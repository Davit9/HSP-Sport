package am.chronograph.dao.group;

import org.springframework.stereotype.Repository;

import am.chronograph.dao.GenericDaoImpl;
import am.chronograph.domain.group.Group;

@Repository
public class GroupDaoImpl extends GenericDaoImpl<Group> implements GroupDao {

	@Override
	public String getCourseName() {
		return  "SELECT course.name FROM `groups` INNER JOIN course ON groups.course_id = course.id;";
	}

	

}
