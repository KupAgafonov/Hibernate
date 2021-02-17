package servises;

import models.Course;
import models.LinkedPurchase;
import models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseService {

    protected static final Logger LOGGER = LogManager.getLogger(DatabaseService.class);
    protected static final Marker SAVE_MARKER = MarkerManager.getMarker("SAVE");

    public final CourseService courseService = new CourseService();

    public final StudentService studentService = new StudentService();

    public final TeacherService teacherService = new TeacherService();

    public final SubscriptionService subscriptionService = new SubscriptionService();

    public final PurchaseListService purchaseListService = new PurchaseListService();

    public final LinkedPurchaseListService linkedPurchaseService = new LinkedPurchaseListService();

    public void setLinkedPurchaseList(Session session) {

        Transaction transaction = session.beginTransaction();

        session.createQuery("DELETE FROM LinkedPurchase l").executeUpdate();  // сначала чистим таблицу
                                                                                // во избежании ошибок с транзакциейе
        purchaseListService.findAllPurchase().forEach(p -> {

            Student student = studentService.getStudentsByName(p.getStudentName());
            Course course = courseService.getCourseByName(p.getCourseName());
            Object o = new Object();
            if(!student.equals(o) && !course.equals(o)) {
                LinkedPurchase linkedPurchase = new LinkedPurchase(new LinkedPurchase.Id(student, course), student, course);
                if (!linkedPurchaseService.findAllLinkedPurchases().contains(linkedPurchase)) {
                    session.save(linkedPurchase);
                    LOGGER.info(SAVE_MARKER, " save "
                            + course.getName() + " "
                            + student.getName());
                }
            }
        });
        transaction.commit();
    }
}
