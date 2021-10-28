package sem.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sem_customer")
public class sem_customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", length = 100)
	private String name;

	@Column(name = "address", length = 200)
	private String address;

	@Column(name = "phonenumbers", length = 10)
	private String phonenumbers;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "username", length = 15)
	private String username;

	@Column(name = "password", length = 16)
	private String password;

	@OneToMany(mappedBy = "customer")
	private List<sem_cart> sem_carts;

	@OneToMany(mappedBy = "customer")
	private List<sem_order> sem_orders;

	public sem_customer() {
		super();
	}

	public sem_customer(int id, String name, String address, String phonenumbers, Date birthday, String username,
			String password, List<sem_cart> sem_carts, List<sem_order> sem_orders) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phonenumbers = phonenumbers;
		this.birthday = birthday;
		this.username = username;
		this.password = password;
		this.sem_carts = sem_carts;
		this.sem_orders = sem_orders;
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
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the sem_carts
	 */
	public List<sem_cart> getSem_carts() {
		return sem_carts;
	}

	/**
	 * @param sem_carts the sem_carts to set
	 */
	public void setSem_carts(List<sem_cart> sem_carts) {
		this.sem_carts = sem_carts;
	}

	/**
	 * @return the sem_orders
	 */
	public List<sem_order> getSem_orders() {
		return sem_orders;
	}

	/**
	 * @param sem_orders the sem_orders to set
	 */
	public void setSem_orders(List<sem_order> sem_orders) {
		this.sem_orders = sem_orders;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
