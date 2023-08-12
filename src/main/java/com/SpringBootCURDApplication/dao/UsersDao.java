package com.SpringBootCURDApplication.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringBootCURDApplication.entity.Users;

@Repository
public class UsersDao {

	@Autowired
	private SessionFactory sf;

	public List<Users> getAllUsers() {
		Session session  =sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt =session.createCriteria(Users.class);
		List<Users> user =crt.list();
		tr.commit();
		return user;
	}

	public Users SaveUser(Users user) {
		Session session  =sf.openSession();
		Transaction tr =session.beginTransaction();
		session.save(user);
		tr.commit();
		return user;
	}

	public String UpdateUser(Users user) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		try{
			session.save(user);
			tr.commit();
			return "User Updated";
		}
		catch (Exception e) {
			return "User of this id is not present, please enter again";
		}
	}

	public String DeleteUser(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Users user =session.get(Users.class, id);
		try {
			session.delete(user);
			tr.commit();
			return "User deleted";
		} catch (Exception e) {
			return "User of this id is not present, please enter again";
		}
	}

	public Users UserWithEncryptedPassword(Users user) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(user);
		tr.commit();
		session.close();
		return user;
	}

	public Users findByUserNamebyDecryptionofpassword(String userName) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt =session.createCriteria(Users.class);
		crt.add(Restrictions.eqOrIsNull("username", userName));
		Users user =(Users) crt.uniqueResult();
		return user;
	}
}
