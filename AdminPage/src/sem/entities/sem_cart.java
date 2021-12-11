package sem.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sem_cart")
public class sem_cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "customer")
	private int customer;

	@Column(name = "datecreate")
	private Date datecreate;

	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private List<sem_cart_book> sem_cart_books;

	public sem_cart() {
		super();
	}

	public sem_cart(int id, int customer, Date datecreate, List<sem_cart_book> sem_cart_books) {
		super();
		this.id = id;
		this.customer = customer;
		this.datecreate = datecreate;
		this.sem_cart_books = sem_cart_books;
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
	 * @return the customer
	 */
	public int getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(int customer) {
		this.customer = customer;
	}

	/**
	 * @return the datecreate
	 */
	public Date getDatecreate() {
		return datecreate;
	}

	/**
	 * @param datecreate the datecreate to set
	 */
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}

	/**
	 * @return the sem_cart_books
	 */
	public List<sem_cart_book> getSem_cart_books() {
		return sem_cart_books;
	}

	/**
	 * @param sem_cart_books the sem_cart_books to set
	 */
	public void setSem_cart_books(List<sem_cart_book> sem_cart_books) {
		this.sem_cart_books = sem_cart_books;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
