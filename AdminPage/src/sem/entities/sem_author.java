package sem.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sem_author")
public class sem_author {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "author")
	private List<sem_author_book> sem_author_books;

	public sem_author() {
		super();
	}

	public sem_author(int id, String name, List<sem_author_book> sem_author_books) {
		super();
		this.id = id;
		this.name = name;
		this.sem_author_books = sem_author_books;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sem_author_books
	 */
	public List<sem_author_book> getSem_author_books() {
		return sem_author_books;
	}

	/**
	 * @param sem_author_books the sem_author_books to set
	 */
	public void setSem_author_books(List<sem_author_book> sem_author_books) {
		this.sem_author_books = sem_author_books;
	}
}
