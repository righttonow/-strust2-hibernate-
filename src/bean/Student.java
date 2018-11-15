package bean;



/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sid;
	private String sname;
	private String spassword;
	private Integer grade;
	private Double price=0.0;
//	private HashSet<Book> books=new HashSet<Book>();

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer sid, String sname, String spassword, Integer grade) {
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
		this.grade = grade;
	}

	/** full constructor */
	public Student(Integer sid, String sname, String spassword, Integer grade, Double price) {
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
		this.grade = grade;
		this.price = price;
	}
//	public Student(Integer sid, String sname, String spassword, Integer grade, Double price, HashSet<Book> books) {
//		this.sid = sid;
//		this.sname = sname;
//		this.spassword = spassword;
//		this.grade = grade;
//		this.price = price;
//		this.books=books;
//	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Student [id=" + sid + ", username=" + sname + ", userpass="
				+ spassword + ", grade=" + grade +
				 "]";
	}
	
//	public HashSet<Book> getBook() {
//		return books;
//	}
//
//	public void setBook(HashSet<Book> books) {
//		this.books = books;
//	}
	

	
	

}