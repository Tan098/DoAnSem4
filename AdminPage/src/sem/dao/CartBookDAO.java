package sem.dao;

import sem.entities.sem_category_book;

public interface CartBookDAO {
	public boolean insertCartBook(sem_category_book a);
	public sem_category_book getCartBookById(Integer id);
}
