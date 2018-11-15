package bean;


/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer isbn;
	private String bname;
	private Double price;
	private Integer grade;
//	private Integer number;
//	private HashSet<Student> students = new HashSet<Student>();

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** minimal constructor */
	public Book(Integer isbn, String bname, Integer grade) {
		this.isbn = isbn;
		this.bname = bname;
		this.grade = grade;
	}
	public Book(Integer isbn, String bname, Integer grade, Double price) {
		this.isbn = isbn;
		this.bname = bname;
		this.grade = grade;
		this.price = price;
	}
//	public Book(Integer isbn, String bname, Integer grade,Double price,Integer number) {
//		this.isbn = isbn;
//		this.bname = bname;
//		this.grade = grade;
//		this.price = price;
//		this.number = number;
//	}

	/** full constructor */
//	public Book(String isbn, String bname, Double price, Integer grade, HashSet<Student> students) {
//		this.isbn = isbn;
//		this.bname = bname;
//		this.price = price;
//		this.grade = grade;
//		this.students = students;
//	}

	// Property accessors

	public Integer getIsbn() {
		return this.isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

//	public HashSet<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(HashSet<Student> students) {
//		this.students = students;
//	}

	
	

}