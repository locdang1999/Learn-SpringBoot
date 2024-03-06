package com.danggialoc.learn.spring.security.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danggialoc.learn.spring.security.entity.VerificationToken;

@Repository
public interface VerificationTokenReponsitory extends JpaRepository<VerificationToken, Long>{
	VerificationToken findByToken(String token);

}
