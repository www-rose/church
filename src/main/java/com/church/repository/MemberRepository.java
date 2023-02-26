package com.church.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.church.model.Member;

	public interface MemberRepository extends JpaRepository <Member, Long>{
	
		@Query("SELECT p from Member p WHERE CONCAT(p.firstName, ' ', p.LastName, ' ', p.Email, ' ', p.Fellowship, ' ', p.Cell, ' ', p.Position, ' ', p.Department, ' ', p.Rhapsody, ' ', p.Tithe, ' ', p.Others) LIKE %?1%")
		public List<Member> findAll(String keyword);
		public Member findByfirstName(String rollNo);
		
	}

