package com.church.service;

import java.util.List;

import com.church.model.Images;

public interface imageUploadService {

	
	List<Images> findAll(); 
	
	Images save(Images im);
}
