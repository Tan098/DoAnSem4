package sem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_author_book")
public class sem_author_book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private sem_author_book_pk author_book_pk;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private sem_book book;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private sem_author author;

	@Column(name = "alias")
	private String alias;

	public sem_author_book() {
		super();
	}

	public sem_author_book(sem_author_book_pk author_book_pk, sem_book book, sem_author author, String alias) {
		super();
		this.author_book_pk = author_book_pk;
		this.book = book;
		this.author = author;
		this.alias = alias;
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

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
}
