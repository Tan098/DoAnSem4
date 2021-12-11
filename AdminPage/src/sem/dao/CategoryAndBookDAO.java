package sem.dao;

import java.util.List;

import sem.entities.sem_category_book;

public interface CategoryAndBookDAO {
	public List<sem_category_book> getList();
	public boolean insertCategoryBook(sem_category_book cb);
	public boolean deleteCategoryBook(String alias);
	public sem_category_book getCategoryBookByAlias(String alias);
	public List<sem_category_book> getListBycategory(Integer id,Integer offset, Integer maxResults);
	public Long getTotal(Integer id);
	
}
