package com.church.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.church.model.Notem;
import com.church.repository.NotemRepository;

@Service
public class NotemServiceImpl implements NotemService{

	
	private NotemRepository notemRepository;
	
	public NotemServiceImpl(NotemRepository notemRepository) {
		super();
		this.notemRepository = notemRepository;
	}

	@Override
	public List<Notem> getAllNotems(String keyword) {
		if(keyword != null) {
		return notemRepository.findAll(keyword);
	}else
		return (List<Notem>) notemRepository.findAll();
	}

	@Override
	public Notem saveNotem(Notem notem) {
		return notemRepository.save(notem);
	}

	@Override
	public Notem getNotemById(Long id) {
		return notemRepository.findById(id).get();
	}

	@Override
	public Notem updateNotem(Notem notem) {
		return notemRepository.save(notem);
	}

	@Override
	public void deleteNotemById(Long id) {
		notemRepository.deleteById(id);
		
	}

	@Override
	public List<Notem> getAll() {
		return notemRepository.findAll();
	
	}
}
