package core;

import entities.concretes.User;

public class SendEmailValidationManager implements SendValidationMessageService {

	@Override
	public void sendEmail(User user) {
		System.out.println(user.getFirstName()+ " "+ user.getEmail()+ "Doğrulama maili yollanmıştır");
		
	}

}
