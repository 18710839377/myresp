package cn.l1.hiber.test.hql;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.l1.hiber.model.User;
import cn.l1.hiber.utils.HibernateUtils;


public class test {
	@Test
	public void addTest(){
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		try {
			for(int i=0;i<10;i++){
			User user = new User();
				user.setUname("李四"+i);
				if(i%2==0){
					user.setGender(1);
				}else{
					user.setGender(2);
				}
				user.setBirthday(new Date());
				user.setSalary(1000+ i*100);
				session.save(user);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
		
	}
	
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		
		try {
			String hql="from User";
			Query query = session.createQuery(hql);
				List<User> userList = query.list();
			for(User user : userList){
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
			String hql="select u.uname from User u";
			Query query = session.createQuery(hql);
				List<String> nameList = query.list();
			for(String name : nameList){
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
			String hql="select u.uname,u.gender from User u";
			Query query = session.createQuery(hql);
				List<Object[]> objArrList = query.list();
			for(Object[] obj : objArrList){
				System.out.println("姓名："+obj[0]+"   性别："+obj[1]);
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
			String hql="from User";
			Query query = session.createQuery(hql);
			//从前台传过来的页码   pageNo   startNum=(pageNo-1)*pageSize
			//设置开始行号
			query.setFirstResult(0);
			//设置每页记录数
			query.setMaxResults(5);
				List<User> userList = query.list();
			for(User user : userList){
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
	
	@Test
	public void testQuery4(){
		Session session = HibernateUtils.getSession();
		
		try {
			String hql="from User";
			Query query = session.createQuery(hql);
			//从前台传过来的页码   pageNo   startNum=(pageNo-1)*pageSize
				List<User> userList = query.setFirstResult(5).setMaxResults(5).list();
			for(User user : userList){
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
	
	@Test
	public void testQuery5(){
		Session session = HibernateUtils.getSession();
		
		try {
			Query query = session.getNamedQuery("queryAll");
			query.setParameter("salary", 1500);
				List<User> userList = query.list();
			for(User user : userList){
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
}
