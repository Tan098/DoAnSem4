package sem.dao;

import java.util.List;

import sem.entities.sem_author_book;

public interface AuthorAndBookDAO {
	public List<sem_author_book> getList();
	public boolean insertAuthorBook(sem_author_book ab);
	public boolean deleteAuthorBook(Integer book);
	public sem_author_book getAuthorBookById(Integer book);
}
