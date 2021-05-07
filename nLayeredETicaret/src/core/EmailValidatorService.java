package core;

import entities.concretes.User;

public interface EmailValidatorService {

	boolean checkEmail(User user);
}
