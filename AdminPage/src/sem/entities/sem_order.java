package sem.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sem_order")
public class sem_order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Basic(optional = false)
	@Column(name = "timeorder", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeorder;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "phonenumbers")
	private String phonenumbers;

	@JoinColumn(name = "customer", referencedColumnName = "id")
	@ManyToOne
	private sem_customer customer;

	@Column(name = "totalprice")
	private float totalprice;

	@Column(name = "status")
	private Boolean status;

	@OneToMany(mappedBy = "orderid", fetch = FetchType.LAZY)
	private List<sem_cart_book> sem_cart_books;

	public sem_order() {
		super();
	}

	public sem_order(int id, Date timeorder, String name, String address, String phonenumbers, sem_customer customer,
			float totalprice, Boolean status, List<sem_cart_book> sem_cart_books) {
		super();
		this.id = id;
		this.timeorder = timeorder;
		this.name = name;
		this.address = address;
		this.phonenumbers = phonenumbers;
		this.customer = customer;
		this.totalprice = totalprice;
		this.status = status;
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
	 * @return the timeorder
	 */
	public Date getTimeorder() {
		return timeorder;
	}

	/**
	 * @param timeorder the timeorder to set
	 */
	public void setTimeorder(Date timeorder) {
		this.timeorder = timeorder;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phonenumbers
	 */
	public String getPhonenumbers() {
		return phonenumbers;
	}

	/**
	 * @param phonenumbers the phonenumbers to set
	 */
	public void setPhonenumbers(String phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	/**
	 * @return the customer
	 */
	public sem_customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(sem_customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the totalprice
	 */
	public float getTotalprice() {
		return totalprice;
	}

	/**
	 * @param totalprice the totalprice to set
	 */
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
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
