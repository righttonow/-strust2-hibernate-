package bean;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private Integer cartId;
	private Student student;
	private Book book;
	private Integer pay;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** minimal constructor */
	public Cart(Integer cartId) {
		this.cartId = cartId;
	}

	/** full constructor */
	public Cart(Integer cartId,Student student,Book book) {
		this.cartId = cartId;
		this.student = student;
		this.student = student;
	}
	public Cart(Integer cartId,Student student,Book book,Integer pay) {
		this.cartId = cartId;
		this.student = student;
		this.student = student;
		this.pay = pay;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	// Property accessors

	public Integer getPay() {
		return pay;
	}

	public void setPay(Integer pay) {
		this.pay = pay;
	}

	

}