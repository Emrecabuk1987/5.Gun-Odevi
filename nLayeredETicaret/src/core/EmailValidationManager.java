package core;

import entities.concretes.User;

public class EmailValidationManager implements UserValidationService{

	@Override
	public void userToValidate(User user) {
		System.out.println(user.getFirstName()+ "Doğrulamanız gerçekleşmiştir. ");
		
	}
	
	

}
