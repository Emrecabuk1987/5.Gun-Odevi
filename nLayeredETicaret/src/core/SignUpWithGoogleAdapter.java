package core;

import entities.concretes.User;
import signUpWithGoogle.SignUpWithGoogleManager;

public class SignUpWithGoogleAdapter implements  SocialMediaSignUpService {

	@Override
	public void signUpWithGoogle(User user) {
		SignUpWithGoogleManager signUpWithGoogleManager = new SignUpWithGoogleManager();
		signUpWithGoogleManager.signUpWithGoogle(user);
		
	}

	
}
