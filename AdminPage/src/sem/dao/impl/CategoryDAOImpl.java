package sem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sem.dao.CategoryDAO;
import sem.entities.sem_account;
import sem.entities.sem_category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	/** Nhớ copy cái đoạn ở dưới này rồi pase vô tất cả cái DAOImpl nào có sessionFactory **/
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<sem_category> getCategories(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from sem_category")
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
	public boolean insertCategory(sem_category c) {
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
	public boolean updateCategory(sem_category c) {
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
	public sem_category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			sem_category b = (sem_category) session.createQuery("from sem_category where id = :id")
			.setParameter("id", id)
			.uniqueResult();
			session.getTransaction().commit();
			session.close();
			return b;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

}
