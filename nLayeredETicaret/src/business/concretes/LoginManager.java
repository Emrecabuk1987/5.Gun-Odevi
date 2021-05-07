package business.concretes;

import java.util.List;

import business.abstracts.LoginService;
import business.abstracts.UserService;
import entities.concretes.User;

public class LoginManager implements LoginService {


private UserService userService;
	
	public LoginManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void login(String email, String password) {

		List<User> usersInMemory = userService.getAll();
		
		for (User userCheck : usersInMemory) {
			if(userCheck.getEmail()==email && userCheck.getPassword()==password) {
				System.out.println(userCheck.getFirstName()+" : Giris basarili.");
			}else if(userCheck.getEmail()!=email && userCheck.getPassword()!=password){
				System.out.println(userCheck.getFirstName()+" : Bilgilerinizi kontrol ediniz.");
			}
		}
		
	}

	
}

