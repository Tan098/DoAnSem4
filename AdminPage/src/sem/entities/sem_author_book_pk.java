package sem.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class sem_author_book_pk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "book")
	private int book;
	@Column(name = "author")
	private int author;
	
	public sem_author_book_pk() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public sem_author_book_pk(int book, int author) {
		super();
		this.book = book;
		this.author = author;
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
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}
}
