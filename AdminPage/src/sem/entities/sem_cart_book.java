package sem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_cart_book")
public class sem_cart_book {
	@Id
	@JoinColumn(name = "cart", referencedColumnName = "id")
	@ManyToOne
	private sem_cart cart;
	
	@Id
	@JoinColumn(name = "book", referencedColumnName = "id")
	@ManyToOne
	private sem_book book;
	
	@Id
	@Column(name = "order")
	private int order;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private float price;

	public sem_cart_book() {
		super();
	}

	public sem_cart_book(sem_cart cart, sem_book book, int order, int quantity, float price) {
		super();
		this.cart = cart;
		this.book = book;
		this.order = order;
		this.quantity = quantity;
		this.price = price;
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
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
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
