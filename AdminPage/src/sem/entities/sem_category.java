package sem.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sem_category")
public class sem_category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "descriptions")
	private String descriptions;
	
	@OneToMany(mappedBy = "category")
	private List<sem_category_book> sem_category_books;

	public sem_category() {
		super();
	}

	public sem_category(int id, String alias, String name, String descriptions,
			List<sem_category_book> sem_category_books) {
		super();
		this.id = id;
		this.alias = alias;
		this.name = name;
		this.descriptions = descriptions;
		this.sem_category_books = sem_category_books;
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
	 * @return the descriptions
	 */
	public String getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the sem_category_books
	 */
	public List<sem_category_book> getSem_category_books() {
		return sem_category_books;
	}

	/**
	 * @param sem_category_books the sem_category_books to set
	 */
	public void setSem_category_books(List<sem_category_book> sem_category_books) {
		this.sem_category_books = sem_category_books;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
