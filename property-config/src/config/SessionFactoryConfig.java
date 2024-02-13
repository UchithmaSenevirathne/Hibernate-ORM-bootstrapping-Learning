package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    private static SessionFactoryConfig sessionFactoryConfig;

    private SessionFactoryConfig(){
    }

    public static SessionFactoryConfig getInstance(){
        return (sessionFactoryConfig==null)?sessionFactoryConfig=new SessionFactoryConfig():sessionFactoryConfig;
    }

    public Session getSession(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Customer.class).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        return sessionFactory.openSession();
    }
}
