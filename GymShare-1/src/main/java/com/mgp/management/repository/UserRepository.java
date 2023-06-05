package com.mgp.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgp.management.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
