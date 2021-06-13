package com.amy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amy.Entity.Friends;
@Repository
public interface FriendRepository extends JpaRepository<Friends, Integer> {

}
