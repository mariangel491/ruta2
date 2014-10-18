package Modelos.Hibernate.Config;

import Modelos.Hibernate.Config.HibernateUtil;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateOperations<T> {
	
	private static int SAVE = 1;
	private static int UPDATE = 2;
	private static int DELETE = 3;
	private Session session;
	private Transaction transaction;
	private final Class<T> clazz;

	public static <U> HibernateOperations<U> create(Class<U> clazz) {
		return new HibernateOperations<U>(clazz);
	}

	protected HibernateOperations(Class<T> clazz) {
		this.clazz = clazz;
	}

	private Session openSession() {
		return HibernateUtil.openSession();
	}

	private Transaction beginTransaction() {
		return session.beginTransaction();
	}

	private void commit() {
		transaction.commit();
	}

	private void rollback() {
		transaction.rollback();
	}

	private void closeSession() {
		session.close();
	}

	public List<T> findAll() {
		List<T> list;
		try {
			T instance = clazz.newInstance();
			session = openSession();
			transaction = beginTransaction();
			Criteria criteria = session.createCriteria(instance.getClass());
			list = (List<T>) criteria.list();
		} catch (Exception exception) {
			rollback();
			throw new HibernateException(exception);
		} finally {
			closeSession();
		}
		return list;
	}

	private void operation(Object object, int type) {
		try {
			session = openSession();
			transaction = beginTransaction();
			if (type == SAVE)
				session.save(object);
			else if (type == UPDATE)
				session.update(object);
			else
				session.delete(object);
			commit();
		} catch (HibernateException exception) {
			rollback();
			throw new HibernateException(exception);
		} finally {
			closeSession();
		}
	}

	public void save(Object object) {
		operation(object, SAVE);
	}

	public void update(Object object) {
		operation(object, UPDATE);
	}

	public void delete(Object object) {
		operation(object, DELETE);
	}

}
