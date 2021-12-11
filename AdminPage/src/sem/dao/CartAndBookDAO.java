package sem.dao;

import java.util.List;

import sem.entities.sem_cart_book;
import sem.entities.sem_order;

public interface CartAndBookDAO {
	public boolean insertItems(sem_cart_book cart_book);
	public List<sem_cart_book> getCartByOrder(int orderid);
}
