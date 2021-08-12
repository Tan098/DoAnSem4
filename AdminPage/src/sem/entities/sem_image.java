package sem.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sem_image")
public class sem_image implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int id;
	
	@JoinColumn(name = "book", referencedColumnName = "id")
	@ManyToOne
	private sem_book book;
	
	@Column(name = "caption")
	private String caption;
	
	@Column(name = "isdefault")
	private Boolean isdefault;
	
	@Column(name = "datecreated")
	private Date datecreated;
	
	@Column(name = "path")
	private String path;

	public sem_image() {
		super();
	}

	public sem_image(int id, sem_book book, String caption, Boolean isdefault, Date datecreated, String path) {
		super();
		this.id = id;
		this.book = book;
		this.caption = caption;
		this.isdefault = isdefault;
		this.datecreated = datecreated;
		this.path = path;
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
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * @return the isdefault
	 */
	public Boolean getIsdefault() {
		return isdefault;
	}

	/**
	 * @param isdefault the isdefault to set
	 */
	public void setIsdefault(Boolean isdefault) {
		this.isdefault = isdefault;
	}

	/**
	 * @return the datecreated
	 */
	public Date getDatecreated() {
		return datecreated;
	}

	/**
	 * @param datecreated the datecreated to set
	 */
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
