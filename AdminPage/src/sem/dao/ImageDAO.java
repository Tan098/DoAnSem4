package sem.dao;

import java.util.List;

import sem.entities.sem_category_book;
import sem.entities.sem_image;

public interface ImageDAO {
	public List<sem_image> getImages(Integer pageIndex, Integer pageSize);
	public boolean insertImage(sem_image i);
	public boolean updateImage(sem_image i);
	public boolean deleteImage(Integer id);
	public sem_image getImageById(Integer id);
}
