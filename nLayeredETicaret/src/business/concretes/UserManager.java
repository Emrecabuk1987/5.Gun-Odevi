package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import core.EmailValidatorService;
import core.SendValidationMessageService;
import core.SocialMediaSignUpService;
import core.UserValidationService;
import dataAccess.absctracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private EmailValidatorService emailValidatorService;
	private SendValidationMessageService sendValidationMessageService;
	private UserValidationService userValidationService;
	private SocialMediaSignUpService socialMediaSignUpService;

	public UserManager( UserDao userDao,
						EmailValidatorService emailValidatorService,
						SendValidationMessageService sendValidationMessageService,
						UserValidationService userValidationService,
						SocialMediaSignUpService socialMediaSignUpService
						) {
		super();
		this.userDao = userDao;
		this.emailValidatorService=emailValidatorService;
		this.sendValidationMessageService = sendValidationMessageService;
		this.userValidationService=userValidationService;
		this.socialMediaSignUpService = socialMediaSignUpService;
	}

	@Override
	public void add(User user) {
		
		if(user.getFirstName().length()>2 && user.getLastName().length()>2 && user.getPassword().length()>=6 && user.getEmail().length()>1) {
			
			if(!emailValidatorService.checkEmail(user)) {
				
				System.out.println("Email adresiniz dogru formatta degil");
				return;
				
			}
			
			//if(!userDao.getAll().isEmpty() && userDao.checkEmailExists(user)) {
				///System.out.println("Email adresi ile kullanici var.");
			//	return;
			//}
			
				userDao.add(user);
				sendValidationMessageService.sendEmail(user);
				
			
		}else {
			System.out.println("Gerekli alanlari doldurmadiniz. Kontrol ediniz.");
		}
		
	}

	@Override
	public List<User> getAll() {

		return userDao.getAll();

	}

	@Override
	public void delete(User user) {
		userDao.delete(user);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public User get(int id) {
		userDao.get(id);
		return null;
	}

	@Override
	public void userValidateByEmail(User user) {
		userValidationService.userToValidate(user);
		
	}

	@Override
	public void addWithSocialMedia(User user) {
		socialMediaSignUpService.signUpWithGoogle(user);
		
		
	}
		
		
	
}
