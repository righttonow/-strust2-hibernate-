package action;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.*;
import dao.*;
public class BookAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Integer isbn;
	protected List<Book> bookList;
	protected List<Cart> cartList;
	
	//添加书籍到订购单
	public String Addcart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student =  (Student)session.getAttribute("loginstudent");
		IBookDAO dao=new IBookDAO();
		boolean d=dao.Addcart(this.isbn, student.getSid());
		if(d){
			return SUCCESS;
		}	
		this.addActionMessage("请勿重复添加！");
			return ERROR;
		
	}
	//删除书籍
	public String deletecart(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student =  (Student)session.getAttribute("loginstudent");
		IBookDAO dao=new IBookDAO();
		boolean d=dao.deletecart(this.isbn, student.getSid());
		session.removeAttribute("carts");
		if(d){
			return this.carts();
		}	
		this.addActionMessage("删除失败！");
			return ERROR;
		
	}
	//订购单
	public String carts(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student =  (Student)session.getAttribute("loginstudent");
		IBookDAO dao=new IBookDAO();
		cartList=dao.carts(student.getSid());	
		if(cartList!=null){
			session.setAttribute("carts", cartList);
			double count = 0;
			for(Cart cart:cartList){
				Book book =cart.getBook();
				count += book.getPrice();
			}
			session.setAttribute("count",count);
			return SUCCESS;
		}
			return ERROR;
	}
	//确认订单
	public String Order(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student =  (Student)session.getAttribute("loginstudent");
		IBookDAO dao=new IBookDAO();
		double count = (double)session.getAttribute("count");
		student.setPrice(student.getPrice()-count);
		if(student.getPrice()>0){
			boolean b=dao.AddOrder(student);
			session.removeAttribute("carts");
			if(b){
				return this.carts();
			}
		}
		student.setPrice(student.getPrice()+count);
		this.addActionMessage("余额不足！");
		return ERROR;
	}
	//查看订单
	public String OrderList(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student =  (Student)session.getAttribute("loginstudent");
		IBookDAO dao=new IBookDAO();
		cartList=dao.OrderList(student.getSid());		
		if(cartList!=null){
			session.setAttribute("List", cartList);
			return SUCCESS;
		}
			return SUCCESS;
	}
	
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
}
