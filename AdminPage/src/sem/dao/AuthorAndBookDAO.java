package sem.dao;

import java.util.List;

import sem.entities.sem_author_book;
import sem.entities.sem_author_book_pk;

public interface AuthorAndBookDAO {
	public List<sem_author_book> getList();
	public boolean insertAuthorBook(sem_author_book ab);
	public boolean deleteAuthorBook(String alias);
	public sem_author_book getAuthorBookByAlias(String alias);
}
