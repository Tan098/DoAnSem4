package sem.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sem_book")
public class sem_book  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "alias")
	private String alias;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "descriptions")
	private String descriptions;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "yearofpublic")
	private Date yearofpublic;
	
	@Column(name = "status")
	private Boolean status;
	
	@JoinColumn(name = "publicsher", referencedColumnName = "id")
	@ManyToOne
	private sem_publisher publicsher;

	@OneToMany(mappedBy = "book",fetch = FetchType.EAGER)	
	private Set<sem_image> sem_images;
	
	@OneToMany(mappedBy = "book")
	private Set<sem_cart_book> sem_cart_books;
	
	@OneToMany(mappedBy = "book",fetch = FetchType.EAGER)
	private Set<sem_author_book> sem_author_books;
	
	@OneToMany(mappedBy = "book")
	private Set<sem_category_book> sem_category_books;

	public sem_book() {
		super();
	}
	
	public sem_book(Integer id) {
		super();
		this.id = id;
	}

	public sem_book(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public sem_book(Integer id, String alias, String name, String descriptions, int quantity, float price,
			Date yearofpublic, Boolean status, sem_publisher publicsher, Set<sem_image> sem_images,
			Set<sem_cart_book> sem_cart_books, Set<sem_author_book> sem_author_books,
			Set<sem_category_book> sem_category_books) {
		super();
		this.id = id;
		this.alias = alias;
		this.name = name;
		this.descriptions = descriptions;
		this.quantity = quantity;
		this.price = price;
		this.yearofpublic = yearofpublic;
		this.status = status;
		this.publicsher = publicsher;
		this.sem_images = sem_images;
		this.sem_cart_books = sem_cart_books;
		this.sem_author_books = sem_author_books;
		this.sem_category_books = sem_category_books;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the yearofpublic
	 */
	public Date getYearofpublic() {
		return yearofpublic;
	}

	/**
	 * @param yearofpublic the yearofpublic to set
	 */
	public void setYearofpublic(Date yearofpublic) {
		this.yearofpublic = yearofpublic;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	/**
	 * @param publicsher the publicsher to set
	 */
	public void setPublicsher(sem_publisher publicsher) {
		this.publicsher = publicsher;
	}

	/**
	 * @return the publicsher
	 */
	public sem_publisher getPublicsher() {
		return publicsher;
	}

	/**
	 * @return the sem_images
	 */
	public Set<sem_image> getSem_images() {
		return sem_images;
	}

	/**
	 * @param sem_images the sem_images to set
	 */
	public void setSem_images(Set<sem_image> sem_images) {
		this.sem_images = sem_images;
	}

	/**
	 * @return the sem_cart_books
	 */
	public Set<sem_cart_book> getSem_cart_books() {
		return sem_cart_books;
	}

	/**
	 * @param sem_cart_books the sem_cart_books to set
	 */
	public void setSem_cart_books(Set<sem_cart_book> sem_cart_books) {
		this.sem_cart_books = sem_cart_books;
	}

	/**
	 * @return the sem_author_books
	 */
	public Set<sem_author_book> getSem_author_books() {
		return sem_author_books;
	}

	/**
	 * @param sem_author_books the sem_author_books to set
	 */
	public void setSem_author_books(Set<sem_author_book> sem_author_books) {
		this.sem_author_books = sem_author_books;
	}

	/**
	 * @return the sem_category_books
	 */
	public Set<sem_category_book> getSem_category_books() {
		return sem_category_books;
	}

	/**
	 * @param sem_category_books the sem_category_books to set
	 */
	public void setSem_category_books(Set<sem_category_book> sem_category_books) {
		this.sem_category_books = sem_category_books;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
