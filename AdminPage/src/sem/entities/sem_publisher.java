package sem.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sem_publisher")
public class sem_publisher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "publisher")
	private List<sem_book> sem_books;

	public sem_publisher() {
		super();
	}

	public sem_publisher(int id, String name, List<sem_book> sem_books) {
		super();
		this.id = id;
		this.name = name;
		this.sem_books = sem_books;
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
	 * @return the sem_books
	 */
	public List<sem_book> getSem_books() {
		return sem_books;
	}

	/**
	 * @param sem_books the sem_books to set
	 */
	public void setSem_books(List<sem_book> sem_books) {
		this.sem_books = sem_books;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
