package sem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_cart_book")
public class sem_cart_book  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JoinColumn(name = "cart", referencedColumnName = "id")
	@ManyToOne
	private sem_cart cart;

	@JoinColumn(name = "book", referencedColumnName = "id")
	@ManyToOne
	private sem_book book;

	@JoinColumn(name = "orderid", referencedColumnName = "id")
	@ManyToOne
	private sem_order orderid;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private float price;

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public sem_cart_book() {
		super();
	}

	public sem_cart_book(sem_cart cart, sem_book book, sem_order orderid, int quantity, float price, int id) {
		super();
		this.cart = cart;
		this.book = book;
		this.orderid = orderid;
		this.quantity = quantity;
		this.price = price;
		this.id = id;
	}
	
	public sem_cart_book(sem_book book, sem_order orderid, int quantity, float price, int id) {
		super();
		this.book = book;
		this.orderid = orderid;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cart
	 */
	public sem_cart getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(sem_cart cart) {
		this.cart = cart;
	}

	/**
	 * @return the book
	 */
	public sem_book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(sem_book book) {
		this.book = book;
	}

	/**
	 * @return the orderid
	 */
	public sem_order getOrder() {
		return orderid;
	}

	/**
	 * @param orderid the order to set
	 */
	public void setOrder(sem_order orderid) {
		this.orderid = orderid;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
}
