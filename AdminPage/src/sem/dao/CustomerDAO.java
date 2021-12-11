package sem.dao;

import java.util.List;

import sem.entities.sem_customer;

public interface CustomerDAO {
	public List<sem_customer> getCustomers();
	public boolean insertCustomer(sem_customer c);
	public boolean updateCustomer(sem_customer c);
	public boolean deleteCustomer(Integer id);
	public sem_customer getCustomerById(Integer id);
	public sem_customer g_LoginClient(String username, String password);
	public sem_customer getCustomerByUsername(String username);
}
