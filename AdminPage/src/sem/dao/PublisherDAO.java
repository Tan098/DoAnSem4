package sem.dao;

import java.util.List;

import sem.entities.sem_book;
import sem.entities.sem_publisher;

public interface PublisherDAO {
	public List<sem_publisher> getPublishers();
	public boolean insertPublisher(sem_publisher p);
	public boolean updatePublisher(sem_publisher p);
	public sem_publisher getPublisherById(Integer id);
}
