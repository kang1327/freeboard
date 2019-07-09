package com.raon.raonqna.kms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raon.raonqna.kms.Model.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
