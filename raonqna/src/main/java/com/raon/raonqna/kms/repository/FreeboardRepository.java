package com.raon.raonqna.kms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raon.raonqna.kms.Model.Freeboard;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard, Long>{

}
