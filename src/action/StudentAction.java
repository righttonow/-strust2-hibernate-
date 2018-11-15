package action;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.*;
import dao.*;




public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student student = new Student();
	protected List<Book> bookList;
	protected Book book;
	private double p;
	


	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	} 

	//登录
	public  String loginAction(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		IStudentDAO dao = new IStudentDAO();
		IBookDAO d = new IBookDAO();
		Student s= dao.login(student.getSid(), student.getSpassword());
		if(s==null){
			this.addActionMessage("登陆失败！用户名或密码错误！");
            return ERROR;
        }
		bookList = d.getBookByGrade(s.getGrade());
		session.setAttribute("bookList", bookList);
		session.setAttribute("loginstudent", s);
		
            return SUCCESS; 
    }

	
	
	//注册
	public String saveRegister(){
		 if((new IStudentDAO().register(student))!=null){
	            this.addActionMessage("注册成功！请登录！");
	            return SUCCESS;
	        }else{
	        	  this.addActionMessage("此ID已经注册！");
	            return ERROR;
	        }
	}
	
	//学生可选书籍
	public String getBooksByStudent(){
		//List<Book> bookList =new 
		if(null == bookList || bookList.size() ==0 ){
				return ERROR;
	}	else{
		ActionContext.getContext().getValueStack().setValue("booklist", bookList);
				return SUCCESS;
	}
	}
	

	//充值
	public String recharge(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Student student = (Student)session.getAttribute("loginstudent");
		IStudentDAO dao= new IStudentDAO();
		boolean a= dao.recharge(student,p);
		if(a){
			return SUCCESS;
		}
		return ERROR;
		
	}

	//退出
	public String loginoff(){
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("loginstudent");
		return SUCCESS;
	}
	
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return this.student;
	}
	
}
