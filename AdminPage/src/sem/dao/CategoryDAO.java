package sem.dao;

import java.util.List;

import sem.entities.sem_category;

public interface CategoryDAO {
	public List<sem_category> getCategories();
	public boolean insertCategory(sem_category c);
	public boolean updateCategory(sem_category c);
	public sem_category getCategoryById(Integer id);
}
