package com.danggialoc.learn.spring.security.services;

import java.util.Optional;

import com.danggialoc.learn.spring.security.entity.User;
import com.danggialoc.learn.spring.security.entity.VerificationToken;
import com.danggialoc.learn.spring.security.model.UserModel;

public interface UserService {

	User registerUser(UserModel data);

	void saveVerificationTokenUser(String token, User user);

	String validateVerificationToken(String token);

	VerificationToken generateNewVerificationToken(String oldToken);

	User findUserByEmail(String email);

	void createPasswordReserTokenForUser(User user, String token);

	String validatePasswordResetToken(String token);

	Optional<User> getUserByPasswordResetToken(String token);

	void changePassword(User user, String newPassword);

	boolean checkIfvalidOldPassword(User user, String oldPassword);

}
