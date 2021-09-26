package sem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import sem.dao.CategoryAndBookDAO;
import sem.entities.sem_category_book;
import sem.entities.sem_image;

public class CategoryAndBookDAOImpl implements CategoryAndBookDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Nhớ copy cái đoạn ở dưới này rồi pase vô tất cả cái DAOImpl nào có
	 * sessionFactory
	 **/
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<sem_category_book> getList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = (List) session.createQuery("from sem_category_book").list();
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
	public boolean insertCategoryBook(sem_category_book cb) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(cb);
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
	public boolean deleteCategoryBook(String alias) {
		// TODO Auto-generated method stub hàm nào em đặt bug vào
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from sem_category_book where alias = :alias").setParameter("alias", alias)
					.executeUpdate();
			session.getTransaction().commit();
			session.close();
			if (i > 0)
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
	public sem_category_book getCategoryBookByAlias(String alias) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			sem_category_book cb = (sem_category_book) session.createQuery("from sem_category_book where alias = :alias")
					.setParameter("alias", alias).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return cb;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}
		return null;
	}

}
