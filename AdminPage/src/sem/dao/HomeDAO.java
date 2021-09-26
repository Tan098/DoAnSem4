package sem.dao;

import java.util.List;

import sem.entities.sem_book;

public interface HomeDAO {
	public List<sem_book> getBookHome();
	public sem_book getBookByIdHome(Integer id);
}
