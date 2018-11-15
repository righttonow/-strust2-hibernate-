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
public class IAdminDAO {
	public boolean login(Admin admin) {
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
		Query q = sess.createQuery("from Admin where name='"+admin.getName()+"' and password= '"+admin.getPassword()+"'");
		List<Admin> admintList = (List<Admin>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
			
		
		if(admintList.size() != 0){
			return true;
		}
		
		
		return false;
		
	}
	public boolean AddBook(Book book) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Book where ISBN='"+book.getIsbn()+"'");
		List<Book> bookList = (List<Book>)q.list();
		if(bookList.size() != 0){
			sess.save(book);
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return true;
		}
		return false;
	
	}
	
	public boolean UpdateBook(Book book) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Book where ISBN='"+book.getIsbn()+"'");
		List<Book> bookList = (List<Book>)q.list();
		if(bookList.size() != 0){
			sess.update(book);
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return true;
		}
		return false;
	
	}
	public boolean deletBook(Book book) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("Delete Book where ISBN='"+book.getIsbn()+"'");
		if(q.executeUpdate() != 0){
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return true;
		}
		
		return false;
	
	}
	public List<Book> getAllBook(){
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
		Query q = sess.createQuery("from Book ");
		List<Book> bookList = (List<Book>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		if(bookList.size() != 0){
			return (List<Book>) bookList;
		}
		return null;
}


	public Integer getnumber(Book book){
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
		Query q = sess.createQuery("from Cart where ISBN='"+book.getIsbn()+"'");
		List<Book> bookList = (List<Book>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		if(bookList.size() != 0){
			return  bookList.size();
		}
		return null;
}
	public List<Student> getAllStudent(){
	Configuration conf = new Configuration().configure();
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
	.build();
	// 以Configuration实例创建SessionFactory实例
	SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
	// 创建Session
	Session sess = sf.openSession();
	// 开始事务
	Transaction tx = sess.beginTransaction();
	Query q = sess.createQuery("from Student ");
	List<Student> StudentList = (List<Student>)q.list();
	tx.commit();
	// 关闭Session
	sess.close();
	sf.close();
	if(StudentList.size() != 0){
		return (List<Student>)StudentList;
	}
	return null;
}

}
