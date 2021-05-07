package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.absctracts.UserDao;
import entities.concretes.User;


public class HibernateUserDao implements UserDao {

	List<User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi "+user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Hibernate ile güncellendi "+user.getFirstName());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Hibernate ile eklendi "+user.getFirstName());
		
	}

	@Override
	public User get(int id) {
		
		System.out.println("Hibernate ile getirildi ");
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

	@Override
	public boolean checkEmailExists(User user) {
		for(User userChecked : users) {
			if(userChecked.getEmail()==user.getEmail()) {
				return true;
			}
		}
		return false;
	}

	
}
