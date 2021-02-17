import org.hibernate.Session;
import servises.DatabaseService;
import util.HibernateSessionFactoryUtil;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        DatabaseService skillBoxServices = new DatabaseService();
        skillBoxServices.setLinkedPurchaseList(session);

        session.close();

    }

}

