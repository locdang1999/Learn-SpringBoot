package com.danggialoc.learn.spring.security.services;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danggialoc.learn.spring.security.entity.PasswordResetToken;
import com.danggialoc.learn.spring.security.entity.User;
import com.danggialoc.learn.spring.security.entity.VerificationToken;
import com.danggialoc.learn.spring.security.model.UserModel;
import com.danggialoc.learn.spring.security.repositorys.PasswordResetTokenRepository;
import com.danggialoc.learn.spring.security.repositorys.UserRepository;
import com.danggialoc.learn.spring.security.repositorys.VerificationTokenReponsitory;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private VerificationTokenReponsitory verificationTokenReponsitory;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public User registerUser(UserModel data) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(data.getEmail());
		user.setFirstName(data.getFirstName());
		user.setLastName(data.getLastName());
		user.setPassword(passwordEncoder.encode(data.getPassword()));
		user.setRole("User");
		repository.save(user);
		return user;
	}

	@Override
	public void saveVerificationTokenUser(String token, User user) {
		// TODO Auto-generated method stub
		VerificationToken vericationToken = new VerificationToken(user, token);
		verificationTokenReponsitory.save(vericationToken);
	}

	@Override
	public String validateVerificationToken(String token) {
		// TODO Auto-generated method stub
		VerificationToken verificationToken = verificationTokenReponsitory.findByToken(token);
		if (verificationToken == null) {
			return "invalid";
		}
		
		User user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();

		if((verificationToken.getExpirationTime().getTime() - cal.getTime().getTime()) <=0) {
			verificationTokenReponsitory.delete(verificationToken);
			return "expired";
		}
		
		user.setEnabled(true);
		repository.save(user);
		
		return "valid";
	}

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {
		// TODO Auto-generated method stub
		VerificationToken verificationToken = verificationTokenReponsitory.findByToken(oldToken);
		verificationToken.setToken(UUID.randomUUID().toString());
		verificationTokenReponsitory.save(verificationToken);
		return verificationToken;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

	@Override
	public void createPasswordReserTokenForUser(User user, String token) {
		// TODO Auto-generated method stub
		PasswordResetToken passwordResetToken = new PasswordResetToken(user,token);
		passwordResetTokenRepository.save(passwordResetToken);
	}

	@Override
	public String validatePasswordResetToken(String token) {
		// TODO Auto-generated method stub
		PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
		if (passwordResetToken == null) {
			return "invalid";
		}
		
		User user = passwordResetToken.getUser();
		Calendar cal = Calendar.getInstance();

		if((passwordResetToken.getExpirationTime().getTime() - cal.getTime().getTime()) <=0) {
			passwordResetTokenRepository.delete(passwordResetToken);
			return "expired";
		}
		
		return "valid";
	}

	@Override
	public Optional<User> getUserByPasswordResetToken(String token) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
	}

	@Override
	public void changePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(newPassword));
		repository.save(user);
	}

	@Override
	public boolean checkIfvalidOldPassword(User user, String oldPassword) {
		// TODO Auto-generated method stub
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

}
