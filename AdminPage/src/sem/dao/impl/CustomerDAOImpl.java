package sem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sem.dao.CustomerDAO;
import sem.entities.sem_book;
import sem.entities.sem_customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	/** Nhớ copy cái đoạn ở dưới này rồi pase vô tất cả cái DAOImpl nào có sessionFactory **/
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<sem_customer> getCustomers(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from sem_customer")
					.setFirstResult(pageIndex)
					.setMaxResults(pageSize)
					.list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertCustomer(sem_customer c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(sem_customer c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from sem_customer where id = :id")
			.setParameter("id",id)
			.executeUpdate();
			session.getTransaction().commit();
			session.close();
			if (i>0) 
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return false;
	}

	@Override
	public sem_customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			sem_customer c = (sem_customer) session.createQuery("from sem_customer where id = :id")
			.setParameter("id", id)
			.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

}
