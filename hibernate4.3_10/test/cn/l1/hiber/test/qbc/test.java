package cn.l1.hiber.test.qbc;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.junit.Test;

import cn.l1.hiber.model.User;
import cn.l1.hiber.utils.HibernateUtils;


public class test {
	
	
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		
		try {
			Criteria c = session.createCriteria(User.class);
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
			//设置要查询的列
			  c.setProjection(Projections.property("uname"));
			List<String> unames = c.list();
			for(String name:unames){
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
	
	@Test
	public void testQuery2(){
		Session session = HibernateUtils.getSession();
		
		try {
			Criteria c = session.createCriteria(User.class);
			
				ProjectionList pp = Projections.projectionList();
			//设置要查询的列
				PropertyProjection p = Projections.property("uname");
				PropertyProjection p1 = Projections.property("gender");
				pp.add(p);
				pp.add(p1);
			  c.setProjection(pp);
			List<Object[]> objArr = c.list();
			for(Object[] obj:objArr){
				System.out.println("姓名："+obj[0]+"  性别："+obj[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
	
	@Test
	public void testQuery3(){
		Session session = HibernateUtils.getSession();
		
		try {
			Criteria c = session.createCriteria(User.class);
			
				ProjectionList pp = Projections.projectionList();
			//设置要查询的列
				PropertyProjection p = Projections.property("gender");
				AggregateProjection ap = Projections.max("salary");
					PropertyProjection gp = Projections.groupProperty("gender");
				pp.add(p);
				pp.add(ap);
				pp.add(gp);
			  c.setProjection(pp);
			List<Object[]> objArr = c.list();
			for(Object[] obj:objArr){
				System.out.println("  性别："+obj[0]+"   最大工资："+obj[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
}
