package servises;


import dao.Dao;
import dao.SkillBoxDao;
import models.Course;

import java.io.Serializable;
import java.util.List;

public class CourseService {

    private final Dao<Course> courseDao = new SkillBoxDao<>(Course.class);

    public Course findCourse(Serializable id) throws IllegalArgumentException {
        return courseDao.findById(id).get();
    }

    public void saveCourse(Course course) {
        courseDao.save(course);
    }

    public void deleteCourse(Course course) {
        courseDao.delete(course);
    }

    public void updateCourse(Course course) {
        courseDao.update(course);
    }

    public List<Course> findAllCourses() {
        return courseDao.findAll();
    }

    public Course getCourseByName(String name) {    // Хотя это верно, только когда имена идентичны
        return courseDao.getEntityByName(name);
    }

}
