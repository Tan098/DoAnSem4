package sem.dao;

import java.util.List;

import sem.entities.sem_category_book;

public interface CategoryBookDAO {
	public List<sem_category_book> getCategoryBooks();
	public boolean insertCategory(sem_category_book c);
	public boolean updateCategory(sem_category_book c);
	public boolean deleteCategory(Integer id);
	public sem_category_book getCategoryById(Integer id);
}
