package sem.dao;

import java.util.List;

import sem.entities.sem_book;

public interface BookDAO {
	public List<sem_book> getBooks(Integer offset, Integer maxResults);
	public boolean insertBook(sem_book b);
	public boolean updateBook(sem_book b);
	public boolean deleteBook(Integer id);
	public sem_book getBookById(Integer id);
	public List<sem_book> searchBook(String name);
	public Long getTotal();
}
