package sem.dao;

import java.util.List;

import sem.entities.sem_category_book;

public interface CategoryAndBookDAO {
	public List<sem_category_book> getList();
	public boolean insertCategoryBook(sem_category_book cb);
	public boolean deleteCategoryBook(Integer book);
	public sem_category_book getCategoryBookById(Integer book);
}
