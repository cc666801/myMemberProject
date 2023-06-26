package com.example.MyMemberProject.model.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.MyMemberProject.model.beans.Member;

public interface MemberRepository extends MongoRepository<Member, String> {

	@Query("{'email': ?0}")
	Optional<Member> findMemberByEmail(String email);

}
