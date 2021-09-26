package sem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sem.dao.HomeDAO;
import sem.entities.sem_book;

@Repository
public class HomeDAOImpl implements HomeDAO {
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
	public List<sem_book> getBookHome() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from sem_book inner join sem_image on sem_book.id = sem_image.book").list();
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
	public sem_book getBookByIdHome(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			sem_book b = (sem_book) session.createQuery("from sem_book where id = :id").setParameter("id", id)
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
