package core;

import entities.concretes.User;

public interface SendValidationMessageService {

	void sendEmail(User user);
}
