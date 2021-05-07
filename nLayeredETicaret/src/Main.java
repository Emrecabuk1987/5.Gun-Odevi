import business.abstracts.LoginService;
import business.abstracts.UserService;
import business.concretes.LoginManager;
import business.concretes.UserManager;
import core.EmailValidationManager;
import core.RegexEmailValidatorAdapter;
import core.SendEmailValidationManager;
import core.SignUpWithGoogleAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		

		UserService userService= new UserManager(new HibernateUserDao(),
				new RegexEmailValidatorAdapter(), 
				new SendEmailValidationManager(), 
				new EmailValidationManager(),
				new SignUpWithGoogleAdapter());

		User user1 = new User(8,"Emre", "Çabuk", "123@123.com","123456");
		User user2 = new User(5,"Java", "Java", "Java@oracle.com","123456");

		
		userService.add(user1);
		userService.add(user2);

		userService.userValidateByEmail(user1);

		userService.addWithSocialMedia(user2);
		
		LoginService loginService = new LoginManager(userService);
		
		loginService.login(user1.getEmail(),user1.getPassword()); // Giris basarili.
		loginService.login(user2.getEmail(),user2.getPassword()); // Bilgileriniz kontrol ediniz.

	}



}
