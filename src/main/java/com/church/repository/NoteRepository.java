package com.church.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.church.model.Note;

public interface NoteRepository extends JpaRepository <Note, Long>{
	
	
	@Query("SELECT p from Note p WHERE CONCAT(p.rollNo, ' ', p.S1, ' ', p.S2, ' ', p.S3, ' ', p.S4, ' ', p.S5, ' ', p.S6, ' ', p.S7, ' ', p.S8, ' ', p.S9, ' ', p.S10, ' ', p.S11, ' ', p.S12, ' ', p.S13, ' ', p.S14) LIKE %?1%")
	public List<Note> findAll(String keyword);
	public Note findByrollNo(String rollNo);
}

