package cn.l1.hiber.test.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import cn.l1.hiber.model.User;
import cn.l1.hiber.utils.HibernateUtils;


public class test1 {
	
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		
		try {
			String hql="select u from User u where u.gender=?";
			//hql预编译索引是从0开始
			Query query = session.createQuery(hql);
			query.setParameter(0, 1);
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
			String hql="select u from User u where u.gender = :gender and u.uname= :uname";
			//hql预编译索引是从0开始
			Query query = session.createQuery(hql);
			query.setParameter("gender", 1);
			query.setParameter("uname", "李四6");
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
	public void testQuery2(){
		Session session = HibernateUtils.getSession();
		
		try {
			//统计记录数
			String hql="select count(u.userId) from User u ";
			//hql预编译索引是从0开始
			Query query = session.createQuery(hql);
			Object obj = query.uniqueResult();
				System.out.println(obj);
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
			//统计记录数
			String hql="select avg(u.salary),u.gender from User u group by u.gender having avg(u.salary) >1400 ";
			//hql预编译索引是从0开始
			Query query = session.createQuery(hql);
				List <Object[]> Arrlist = query.list();
				for(Object[] objArr:Arrlist){
					System.out.println("平均工资："+objArr[0]+"     性别："+objArr[1]);
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtils.closeResource(session);
		}
		
	}
}
