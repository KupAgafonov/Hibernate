package servises;

import dao.Dao;
import dao.SkillBoxDao;
import models.Student;

import java.io.Serializable;
import java.util.List;

public class StudentService {

    private final Dao<Student> studentDao = new SkillBoxDao<>(Student.class);

    public Student findStudent(Serializable id) throws IllegalArgumentException {
        return studentDao.findById(id).get();
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public Student getStudentsByName(String name) {
        return studentDao.getEntityByName(name);
    }

}
