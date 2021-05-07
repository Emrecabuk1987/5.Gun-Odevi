package core;

import entities.concretes.User;
import regexEmailValidator.RegexEmailValidatorManager;

public class RegexEmailValidatorAdapter implements EmailValidatorService{

	
	@Override
	public boolean checkEmail(User user) {
		RegexEmailValidatorManager manager = new RegexEmailValidatorManager();
		if(manager.checkEmail(user)) {
			return true;
		}else {
			return false;
		}
	}
}

	
