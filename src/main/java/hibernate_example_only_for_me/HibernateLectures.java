package hibernate_example_only_for_me;

import models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class HibernateLectures {
    public static void main(String[] args) {
//        ---------------ПОЛУЧЕНИЕ ДАННЫХ SQL HIBERNATE---------------       //

//        Session session = HibernateSession.getSession();
//
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getName() + " " + course.getPrice());

//        System.out.println(course.getName() + " " + course.getTeacher().getName());

//        List<Student> studentList = course.getStudents();
//        studentList.forEach(System.out::println);

//        Teacher teacher = session.get(Teacher.class, 10);
//        System.out.println(teacher.getName() + " " + teacher.getSalary() +
//                " " + teacher.getCourses().size());
//
//        Student student = session.get(Student.class, 57);
//        System.out.println(student.getName() + " ");

//        session.close();

//        ---------------ИЗМЕНЕНИЕ ДАННЫХ SQL (INSERT UPDATE DELETE)---------------        //

//        Transaction transaction = session.beginTransaction();

//        Course course = new Course();
//        course.setName("Новый курс");
//        course.setType(CourseType.BUSINESS);
//        session.save(course);

//        Course course1 = session.get(Course.class, 53);
//        session.delete(course1);
//
//        transaction.commit();
//        session.close();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        //______WHERE , ORDER BY , LIMIT(5)______//

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query =builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

//        query.select(root).where(builder.)
//        query.select(root).where(builder.greaterThan(root.<Integer>get("price"), 100000)).orderBy(builder.desc(root.get("price")));

//        List<Course> courseList = session.createQuery(query).setMaxResults(5).getResultList();
//
//        courseList.forEach(course -> System.out.println(course.getName() + " - " + course.getPrice()));

        //______HQL______//

//        String hql = " From " + Course.class.getSimpleName() + " Where price > 120000";
//        List<Course> courses = session.createQuery(hql).getResultList();
//        System.out.println(courses.size());

//        sessionFactory.close();

//        ---------------DAO---------------        //

//        CourseService courseService = new CourseService();

//            Course course = new Course();
//            course.setName("NewCourse");
//            course.setType(CourseType.DESIGN);
//            courseService.saveCourse(course);

//        Course course = courseService.findCourse(47);
//        courseService.deleteCourse(course1);

//        System.out.println(course.getName() + " " + course.getTeacher() + " " + course.getTeacher().getSalary());

//        courseService.findAllCourses().stream().map(Course::getName).filter(String::isEmpty).forEach(System.out::println);

//        StudentService studentService = new StudentService();
//        List<Student> studentList = studentService.findAllStudents();
//        studentList.forEach(System.out::println);

//        SubscriptionService subscriptionService = new SubscriptionService();
//        List<Subscription> subscriptionList = subscriptionService.findAllSubscriptions();
//        subscriptionList.forEach(System.out::println);

    }
}
