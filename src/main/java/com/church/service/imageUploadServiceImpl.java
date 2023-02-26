package com.church.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.church.model.Images;
import com.church.repository.uploadRepository;


@Service
public class imageUploadServiceImpl implements imageUploadService{

	
private uploadRepository uploadRepository;
	
	public imageUploadServiceImpl(uploadRepository uploadRepository) {
		super();
		this.uploadRepository = uploadRepository;	
	}

	@Override
	public List<Images> findAll() {
		return uploadRepository.findAll();
	}

	@Override
	public Images save(Images im) {

		return uploadRepository.save(im);
	}
	
	
	
}
