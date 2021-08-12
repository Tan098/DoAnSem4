package sem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_cart_book")
public class sem_cart_book  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private sem_cart_book_pk sem_cart_book_pk;

	@ManyToOne
	@JoinColumn(name = "cart", referencedColumnName = "id", insertable = false, updatable = false)
	private sem_cart cart;

	@ManyToOne
	@JoinColumn(name = "book", referencedColumnName = "id", insertable = false, updatable = false)
	private sem_book book;
	
	@ManyToOne
	@JoinColumn(name = "order", referencedColumnName = "id", insertable = false, updatable = false)
	private sem_order order;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private float price;

	public sem_cart_book() {
		super();
	}

	public sem_cart_book(sem.entities.sem_cart_book_pk sem_cart_book_pk, sem_cart cart, sem_book book, sem_order order,
			int quantity, float price) {
		super();
		this.sem_cart_book_pk = sem_cart_book_pk;
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
	

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the order
	 */
	public sem_order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(sem_order order) {
		this.order = order;
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

	/**
	 * @return the sem_cart_book_pk
	 */
	public sem_cart_book_pk getSem_cart_book_pk() {
		return sem_cart_book_pk;
	}

	/**
	 * @param sem_cart_book_pk the sem_cart_book_pk to set
	 */
	public void setSem_cart_book_pk(sem_cart_book_pk sem_cart_book_pk) {
		this.sem_cart_book_pk = sem_cart_book_pk;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
