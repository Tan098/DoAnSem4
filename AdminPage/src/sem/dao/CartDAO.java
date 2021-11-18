package sem.dao;

import java.util.List;

import sem.entities.sem_cart;

public interface CartDAO {
	public List<sem_cart> getCarts(Integer customer);
	public boolean insertCart(sem_cart cart);
	public boolean updateCart(sem_cart cart);
	public boolean deleteCart(Integer id);
	public sem_cart getCartById(Integer id);
}
