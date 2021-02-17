package servises;

import dao.Dao;
import dao.SkillBoxDao;
import models.Teacher;

import java.util.List;

public class TeacherService {

    private final Dao<Teacher> teacherDao = new SkillBoxDao<>(Teacher.class);

    public Teacher findTeacher(int id) throws IllegalArgumentException{
        return teacherDao.findById(id).get();
    }

    public void saveTeacher(Teacher teacher) {
        teacherDao.save(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        teacherDao.update(teacher);
    }

    public List<Teacher> findAllTeacher() {
        return teacherDao.findAll();
    }


}
