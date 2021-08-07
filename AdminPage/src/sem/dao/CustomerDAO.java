package sem.dao;

import java.util.List;

import sem.entities.sem_customer;

public interface CustomerDAO {
	public List<sem_customer> getCustomers(Integer pageIndex, Integer pageSize);
	public boolean insertCustomer(sem_customer c);
	public boolean updateCustomer(sem_customer c);
	public boolean deleteCustomer(Integer id);
	public sem_customer getCustomerById(Integer id);
}
