package am.chronograph.dao.student;

import org.springframework.stereotype.Repository;

import am.chronograph.dao.GenericDaoImpl;
import am.chronograph.domain.student.Student;

/**
 * The Dao class which contains implementation {@link StudentDao} and {@link GenericDaoImpl}
 * @author gevorg
 *
 */
@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao {

}
