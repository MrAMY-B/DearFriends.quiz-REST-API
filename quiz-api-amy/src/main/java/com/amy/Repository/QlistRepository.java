package com.amy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amy.Entity.Qlist;
@Repository
public interface QlistRepository extends JpaRepository<Qlist, Integer> {

}
