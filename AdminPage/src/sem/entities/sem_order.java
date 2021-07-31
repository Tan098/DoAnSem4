package sem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_order")
public class sem_order {
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "timeorder")
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

	public sem_order() {
		super();
	}

	public sem_order(int id, Date timeorder, String name, String address, String phonenumbers, sem_customer customer,
			float totalprice, Boolean status) {
		super();
		this.id = id;
		this.timeorder = timeorder;
		this.name = name;
		this.address = address;
		this.phonenumbers = phonenumbers;
		this.customer = customer;
		this.totalprice = totalprice;
		this.status = status;
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
}
