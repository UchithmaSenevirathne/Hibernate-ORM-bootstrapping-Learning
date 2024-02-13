import config.SessionFactoryConfig;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer(2,"Kamal","Matara",50000);
        session.save(customer);
        transaction.commit();

        session.close();
    }
}