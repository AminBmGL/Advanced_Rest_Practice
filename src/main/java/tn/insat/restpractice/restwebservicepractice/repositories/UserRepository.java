package tn.insat.restpractice.restwebservicepractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.insat.restpractice.restwebservicepractice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
