package sem.dao;

import java.util.List;

import sem.entities.sem_author;
import sem.entities.sem_cart;

public interface CartDAO {
	public List<sem_cart> getCarts(Integer offset, Integer maxResult);
	public boolean insertCart(sem_cart c);
	public boolean updateCart(sem_cart c);
	public boolean deleteCart(Integer id);
	public sem_cart getCartById(Integer id);
}
