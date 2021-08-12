package sem.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_author_book")
public class sem_author_book  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private sem_author_book_pk author_book_pk;
	
	@ManyToOne
	@JoinColumn(name = "book", referencedColumnName = "id", insertable = false, updatable = false)
	private sem_book book;
	
	@ManyToOne
	@JoinColumn(name = "author", referencedColumnName = "id", insertable = false, updatable = false)
	private sem_author author;
	

	public sem_author_book() {
		super();
	}

	public sem_author_book(sem_book book, sem_author author) {
		super();
		this.book = book;
		this.author = author;
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
	 * @return the author
	 */
	public sem_author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(sem_author author) {
		this.author = author;
	}

	/**
	 * @return the author_book_pk
	 */
	public sem_author_book_pk getAuthor_book_pk() {
		return author_book_pk;
	}

	/**
	 * @param author_book_pk the author_book_pk to set
	 */
	public void setAuthor_book_pk(sem_author_book_pk author_book_pk) {
		this.author_book_pk = author_book_pk;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
