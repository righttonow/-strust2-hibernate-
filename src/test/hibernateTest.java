package test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import bean.Book;
import bean.Cart;
import bean.Student;
import dao.IBookDAO;


public class hibernateTest {
	


	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties())
		.build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
//		IBookDAO dao=new IBookDAO();
//		List<Cart> cartlist =dao.carts(20160707);
//		double count = 0;
//		for(Cart cart:cartlist){
//			Book book =cart.getBook();
//			count += book.getPrice();	
//		}
//		
//		Cart cart =new Cart();
//		cart.setCartId(3);
		//System.out.println("from student where sid='"+sid+"' and spassword= '"+spassword+"'");
	/*	Query q = sess.createQuery("from Cart  where cartId='"+cart.getCartId()+"'");
		List<Cart> cartList = (List<Cart>)q.list();
		if(cartList.size() != 0){
			return false;
		
		}*/
//		Book book =new Book();
//		Student student =new Student();
//		book.setIsbn(111);
//		student.setSid(2018616);
//		cart.setBook(book);
//		cart.setStudent(student);
//		System.out.println(cart.getCartId());
//		System.out.println(cart.toString());
//		sess.save(cart);
//		tx.commit();
//		// 关闭Session
//		sess.close();
//		sf.close();
		double p=2;
		Student student=new Student();
		double price=student.getPrice()+p;
		student.setPrice(price);
		sess.saveOrUpdate(student);
		
		
           

	}
}
