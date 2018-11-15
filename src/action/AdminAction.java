package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.*;
import dao.*;



public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<Book> bookList;
	protected Cart cart;
	protected Book book;
	protected Admin admin = new Admin();
	

	//登录
	public String loginAction(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		IAdminDAO dao= new IAdminDAO();
		boolean b=dao.login(admin);
		if(b){
			session.setAttribute("admin", admin);
			return SUCCESS;
		}
		this.addActionMessage("登陆失败！用户名或密码错误！");	
		return ERROR;
	}
	//查看所有订单按书籍分类
	public String OrderList(){
		return null;
	}
	//添加
	public String AddBook(){
		IAdminDAO dao= new IAdminDAO();
		Book book =new Book();
		boolean b=dao.AddBook(book);
		if(b){
			return SUCCESS;
		}
		this.addActionMessage("添加失败！");	
			return ERROR;
	}
	//修改书籍
	public String UpdateBook(){
		IAdminDAO dao= new IAdminDAO();
		Book book =new Book();
		boolean b=dao.UpdateBook(book);
		if(b){
			return SUCCESS;
		}
		this.addActionMessage("修改失败！");	
			return ERROR;
	}
	//删除书籍
	public String DeletBook(){
		IAdminDAO dao = new IAdminDAO();
		Book book = new Book();
		boolean b=dao.deletBook(book);
		if(b){
			return SUCCESS;
		}
		this.addActionMessage("删除失败！");	
			return ERROR;
	}
	//查看所有书籍
	public String FindAllBook(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		IAdminDAO dao = new IAdminDAO();
		List<Book> bookList=dao.getAllBook();
		if(bookList!=null){
			session.setAttribute("allbook", bookList);
			return SUCCESS;
		}
		this.addActionMessage("未查询到教材！");	
		return ERROR;
	}
	public String getAllStudent(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		IAdminDAO dao = new IAdminDAO();
		List<Student> studentList=dao.getAllStudent();
		if(studentList!=null){
			session.setAttribute("allstudent", studentList);
			return SUCCESS;
		}
		this.addActionMessage("未查询到学生！");	
		return ERROR;
	}
	
	//得到书籍的购买数
	public String getnumber(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		IAdminDAO dao = new IAdminDAO();
		book=new Book();
		Integer a=dao.getnumber(book);
		if(a!=null){
			session.setAttribute("number", a);
			return SUCCESS;
		}
		return ERROR;
	}
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return this.admin;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
