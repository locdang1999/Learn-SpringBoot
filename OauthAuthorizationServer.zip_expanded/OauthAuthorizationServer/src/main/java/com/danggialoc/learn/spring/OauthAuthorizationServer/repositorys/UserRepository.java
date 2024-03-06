package com.danggialoc.learn.spring.OauthAuthorizationServer.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danggialoc.learn.spring.OauthAuthorizationServer.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByEmail(String email);
}
