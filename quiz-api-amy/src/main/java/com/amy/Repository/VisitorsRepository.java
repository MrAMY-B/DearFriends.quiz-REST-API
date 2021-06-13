package com.amy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amy.Entity.Visitors;
@Repository
public interface VisitorsRepository extends JpaRepository<Visitors, Integer> {

}
