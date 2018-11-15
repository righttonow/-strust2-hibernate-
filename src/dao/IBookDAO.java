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
public class IBookDAO {
	public List<Book> getBookByGrade(Integer grade){
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
		Query q = sess.createQuery("from Book where grade='"+grade+"'");
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
	public Boolean Addcart(Integer isbn , Integer sid){
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Cart cart =new Cart();
		Query q = sess.createQuery("from Cart  where isbn='"+isbn+"' and sid='"+sid+"'");
		List<Cart> cartList = (List<Cart>)q.list();
		if(cartList.size() != 0){
			return false;
			}
		Book book =new Book();
		Student student =new Student();
		book.setIsbn(isbn);
		student.setSid(sid);
		cart.setBook(book);
		cart.setStudent(student);
		cart.setPay(0);
		sess.save(cart);
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		
		return true;
}
	public Boolean deletecart(Integer isbn, Integer sid){
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
		Query q = sess.createQuery("Delete Cart  where isbn='"+isbn+"' and sid='"+sid+"'");
		if(q.executeUpdate() != 0){
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return true;
		}
		
		return false;
		
	
}
	public Book getBookByISBN(Integer isbn){
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
		Query q = sess.createQuery("from Book where isbn='"+isbn+"'");
		List<Book> bookList = (List<Book>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		if(bookList.size() != 0){
			for(Book book:bookList){
				return (Book)book;
			}
		}
		
		return null;
		
		
	
}
	//订购单
	public List<Cart> getBookBySid(Student student){
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
		Query q = sess.createQuery("from Cart where sid='"+student.getSid()+"'");
		List<Cart> cartList = (List<Cart>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		if(cartList.size() != 0){
		
				return (List<Cart>)cartList;
			}
		
		
		return null;	
}
	public List<Cart> carts(Integer sid){
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Cart where sid='"+sid+"'and pay='"+0+"'");
		List<Cart> cartList = (List<Cart>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		if(cartList.size() != 0){
				return (List<Cart>)cartList;
			}
		
		
		return null;
	
}
	//确认订购单
	public boolean AddOrder(Student student){
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		
		Query q = sess.createQuery("update Cart set pay='"+1+"'where sid='"+student.getSid()+"'");
		if(q.executeUpdate() != 0){
//			Query w = sess.createQuery("form Cart where sid='"+student.getSid()+"' and pay="+1+"'");
//			List<Cart> cartList = (List<Cart>)w.list();
//			
			sess.update(student);
			tx.commit();
			// 关闭Session
			sess.close();
			sf.close();
			return true;
		}
		
		return false;
}
	//查看订单
	public List<Cart> OrderList(Integer sid){
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		Query q = sess.createQuery("from Cart where sid='"+sid+"' and pay='"+1+"'");
		List<Cart> cartList = (List<Cart>)q.list();
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
		if(cartList.size() != 0){
		
				return (List<Cart>)cartList;
			}
			
		return null;		
}
}