package sem.dao;

import java.util.List;

import sem.entities.sem_order;

public interface OrderDAO {
	public List<sem_order> getOrders(Integer pageIndex, Integer pageSize);
	public boolean insertOrder(sem_order order);
	public boolean updateOrder(sem_order order);
	public sem_order getOrderById(Integer id);
}
