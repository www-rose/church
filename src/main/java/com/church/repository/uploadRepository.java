package com.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.church.model.Images;

public interface uploadRepository extends JpaRepository<Images, Integer> {

}
