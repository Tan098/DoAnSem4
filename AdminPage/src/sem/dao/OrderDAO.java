package sem.dao;

import java.util.List;

import sem.entities.sem_order;

public interface OrderDAO {
	public List<sem_order> getOrders(Integer pageIndex, Integer pageSize);
	public boolean insertOrder(sem_order c);
	public boolean updateOrder(sem_order c);
	public sem_order getOrderById(Integer id);
}
