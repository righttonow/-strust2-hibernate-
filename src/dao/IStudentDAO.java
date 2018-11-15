package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bean.*;
public class IStudentDAO {
	public Student login(int sid,String spassword) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		//System.out.println("from student where sid='"+sid+"' and spassword= '"+spassword+"'");
		Query q = sess.createQuery("from Student where sid='"+sid+"' and spassword= '"+spassword+"'");
		List<Student> studentList = (List<Student>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
			
		
		if(studentList.size() != 0){
			for(Student m : studentList) {
		
				return m;
			}
		
		}
		
		
		return null;
		
	}
	public Student register(Student student) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Student where sid='"+student.getSid()+"'");
		List<Student> userList = (List<Student>)q.list();
		if(userList.size() != 0){
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return null;
		}
		sess.save(student);
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return student;
	}
	public Student findById(Student student) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Student where sid='"+student.getSid()+"'");
		List<Student> studentList = (List<Student>)q.list();
		if(studentList.size() == 0){
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return null;
		}
		for(Student m : studentList) {
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return m;
		}
		
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return null;
	}
	public boolean recharge(Student student,double p) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		double price=student.getPrice()+p;
		student.setPrice(price);
		sess.saveOrUpdate(student);
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		return true;
	}

}
