package sem.dao;

import java.util.List;

import sem.entities.sem_account;

public interface AccountDAO {
	public List<sem_account> getAccounts();
	public boolean registerAccount(sem_account a);
	public boolean updateAccount(sem_account a);
	public boolean deleteAccount(Integer id);
	public sem_account getAccountById(Integer id);
}
