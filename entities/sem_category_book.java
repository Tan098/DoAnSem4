package sem.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_category_book")
public class sem_category_book {
	@Id
	@JoinColumn(name = "book", referencedColumnName = "id")
	@ManyToOne
	private sem_book book;
	
	@Id
	@JoinColumn(name = "category", referencedColumnName = "id")
	@ManyToOne
	private sem_category category;

	public sem_category_book() {
		super();
	}

	public sem_category_book(sem_book book, sem_category category) {
		super();
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
}
