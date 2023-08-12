package com.SpringBootCURDApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SpringBootCURDApplication.dao.UsersDao;
import com.SpringBootCURDApplication.entity.Users;

@Service
public class UsersService {

	@Autowired
	private UsersDao ud;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public List<Users> getAllUsers() {
		return ud.getAllUsers();
	}

	public Users SaveUser(Users user) {
		return ud.SaveUser(user);
	}

	public String UpdateUser(Users user) {
		return ud.UpdateUser(user);
	}

	public String DeleteUser(int id) {
		return ud.DeleteUser(id);
	}

	public Users UserWithEncryptedPassword(String userName,String password) {
		String encryptedPassword =passwordEncoder.encode(password);
		Users user = new Users();
		user.setPassword(encryptedPassword);
		ud.UserWithEncryptedPassword(user);
		return user;
	}

	public boolean findByUserNamebyDecryptionofpassword(String userName, String password) {
		Users user =ud.findByUserNamebyDecryptionofpassword(userName);
		if(user==null)
		{
			return false;
	}
	return passwordEncoder.matches(password, user.getPassword());
	}
}
