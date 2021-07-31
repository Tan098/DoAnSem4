package sem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_author_book")
public class sem_author_book {
	@Id
	@JoinColumn(name = "book", referencedColumnName = "id")
	@ManyToOne
	private sem_book book;
	
	@Id
	@JoinColumn(name = "author", referencedColumnName = "id")
	@ManyToOne
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
}
