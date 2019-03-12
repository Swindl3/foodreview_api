package com.example.foodreview.model.service;

import com.example.foodreview.model.table.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {

    UserProfile findByUserName(String username);

    UserProfile findByUserNameAndPassWord(String username ,String password);
}
