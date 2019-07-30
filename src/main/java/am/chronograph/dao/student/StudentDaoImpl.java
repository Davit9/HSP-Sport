package am.chronograph.dao.student;

import org.springframework.stereotype.Repository;

import am.chronograph.dao.GenericDaoImpl;
import am.chronograph.domain.student.Student;

@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student> implements StudentDao {

}
