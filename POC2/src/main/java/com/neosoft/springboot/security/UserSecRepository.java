package com.neosoft.springboot.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecRepository extends JpaRepository<UserSec, Integer> {

	Optional<UserSec> findByUserName(String userName);
}
