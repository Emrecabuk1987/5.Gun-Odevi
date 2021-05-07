package signUpWithGoogle;

import entities.concretes.User;

public class SignUpWithGoogleManager {

	public void signUpWithGoogle(User user) {
		System.out.println(user.getFirstName()+" Google hesabiniz ile uye oldunuz.");
	}
}
