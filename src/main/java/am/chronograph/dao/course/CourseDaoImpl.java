package am.chronograph.dao.course;

import org.springframework.stereotype.Repository;

import am.chronograph.dao.GenericDaoImpl;
import am.chronograph.domain.course.Course;

/**
 * The Dao class which contains implementation {@link CourseDao} and {@link GenericDaoImpl}
 * 
 * @author gevorg
 *
 */
@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course> implements CourseDao {

}
