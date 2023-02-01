package com.gr8erkay.springfacebook.repository;

import com.gr8erkay.springfacebook.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

}