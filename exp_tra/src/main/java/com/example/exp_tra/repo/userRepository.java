package com.example.exp_tra.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exp_tra.user_entity.userEntity;

@Repository
public interface userRepository extends JpaRepository<userEntity,Long>{

}
