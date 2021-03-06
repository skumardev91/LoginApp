package com.techfabric.apputils;

import javax.servlet.http.HttpServletRequest;

import com.techfabric.appdao.UserDao;
import com.techfabric.appdaoImpl.UserDaoImpl;
import com.techfabric.model.User;

public class UserUtil {
	
	
	public static User extractUserFromRequest(HttpServletRequest request){
		User user = null;
		
		
		String firstname = request.getParameter("firstName");
		String lastName =  request.getParameter("lastName");
		String age = request.getParameter("age");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		
		user = new User(firstname, lastName, age, userName, password, role);
		
		return user;
		
	}
	
	public static User extractUserFromUpdateRequest(HttpServletRequest request){
		
		User user = new User();
		
		String  idUser = request.getParameter("id");
		int id = Integer.parseInt(idUser);
		
		String firstName = request.getParameter("firstName");
		String lastName =  request.getParameter("lastName");
		String age = request.getParameter("age");
		
		
		user.setAge(age);
		user.setIdUser(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		
		
		return user;
		
	}
	
	public static boolean checkCurrentPassword(HttpServletRequest request){
		boolean isThere = false;
		UserDao dao = new UserDaoImpl();
		String currentPass = request.getParameter("currentpass");
		String idUser = request.getParameter("id");
		int id = Integer.parseInt(idUser);
		
		User usr= dao.getUserById(id);
		
		if(currentPass.contains(usr.getPassword()))
			isThere = true;
		else
			isThere = false;
	
	return isThere;
		
	}
}
