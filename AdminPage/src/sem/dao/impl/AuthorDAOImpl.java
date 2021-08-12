package sem.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sem.dao.AuthorDAO;
import sem.entities.sem_author;

@Repository
public class AuthorDAOImpl implements AuthorDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	/** Nhớ copy cái đoạn ở dưới này rồi pase vô tất cả cái DAOImpl nào có sessionFactory **/
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<sem_author> getAuthors(Integer offset, Integer maxResult) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from sem_author")
					.setFirstResult(offset)
					.setMaxResults(maxResult)
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
	public boolean insertAuthor(sem_author a) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(a);
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
	public sem_author getAuthorById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			sem_author b = (sem_author) session.createQuery("from sem_author where id = :id")
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
	@Override
	public boolean updateAuthor(sem_author a) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(a);
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
	public boolean deleteAuthor(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i = session.createQuery("delete from sem_author where id = :id")
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


}
