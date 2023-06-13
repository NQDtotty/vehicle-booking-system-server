package com.nqdtotty.vehiclebooking.repository;

import com.nqdtotty.vehiclebooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByPhoneNumber(String phoneNumber);
}
