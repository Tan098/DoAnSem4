package sem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class sem_category_book_pk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "book")
	private int book;
	@Column(name = "category")
	private int category;
	
	public sem_category_book_pk() {
		super();
	}

	public sem_category_book_pk(int book, int category) {
		super();
		this.book = book;
		this.category = category;
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
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
