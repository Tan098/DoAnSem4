package sem.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_category_book")
public class sem_category_book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private sem_category_book_pk category_book_pk;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book", nullable = false, insertable = false, updatable = false)	
	private sem_book book;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category", nullable = false, insertable = false, updatable = false)
	private sem_category category;
	
	public sem_category_book() {
		super();
	}

	public sem_category_book(sem_category_book_pk category_book_pk, sem_book book, sem_category category) {
		super();
		this.category_book_pk = category_book_pk;
		this.book = book;
		this.category = category;
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
	 * @return the category
	 */
	public sem_category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(sem_category category) {
		this.category = category;
	}

	/**
	 * @return the category_book_pk
	 */
	public sem_category_book_pk getCategory_book_pk() {
		return category_book_pk;
	}

	/**
	 * @param category_book_pk the category_book_pk to set
	 */
	public void setCategory_book_pk(sem_category_book_pk category_book_pk) {
		this.category_book_pk = category_book_pk;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
