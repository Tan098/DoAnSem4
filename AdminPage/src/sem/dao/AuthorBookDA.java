package sem.dao;

import java.util.List;

import sem.entities.sem_author;

public interface AuthorBookDA {
	public List<sem_author> getAuthorBooks(Integer offset, Integer maxResult);
	public boolean insertAuthor(sem_author a);
	public boolean updateAuthor(sem_author a);
	public boolean deleteAuthor(Integer id);
	public sem_author getAuthorById(Integer id);
}
