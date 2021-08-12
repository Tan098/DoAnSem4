package sem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class sem_cart_book_pk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cart")
	private int cart;
	@Column(name = "book")
	private int book;
	@Column(name = "order")
	private int order;
	
	public sem_cart_book_pk() {
		super();
		// TODO Auto-generated constructor stub
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

	public sem_cart_book_pk(int cart, int book, int order) {
		super();
		this.cart = cart;
		this.book = book;
		this.order = order;
	}

	/**
	 * @return the cart
	 */
	public int getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(int cart) {
		this.cart = cart;
	}
	/**
	 * @return the book
	 */
	public int getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(int book) {
		this.book = book;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
