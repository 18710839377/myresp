package cn.l1.hiber.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static{
		Configuration cfg= new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sf=cfg.buildSessionFactory(sr);
		
	}
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	public static Session getSession(){
		return sf.openSession();
		
	}
	public static void closeSession(Session session){
		session.close();
	} 
	public static void closeResource(Session session){
		session.close();
		sf.close();
	}
}
