package cn.l1.hiber.test.qbc;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.junit.Test;

import cn.l1.hiber.model.User;
import cn.l1.hiber.utils.HibernateUtils;


public class test1 {
	
	
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		
		try {
			Criteria c = session.createCriteria(User.class);
			c.addOrder(Order.desc("salary"));
			List<User> list = c.list();
			for(User user:list){
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
	
	@Test
	public void testQuery1(){
		Session session = HibernateUtils.getSession();
		
		try {
			Criteria c = session.createCriteria(User.class);
			c.addOrder(Order.desc("salary"));
			c.setFirstResult(0);
			c.setMaxResults(5);
			List<User> list = c.list();
			for(User user:list){
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
}
