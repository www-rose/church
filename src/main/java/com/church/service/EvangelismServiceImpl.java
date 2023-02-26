package com.church.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.church.model.Evangelism;
import com.church.repository.EvangelismRepository;

@Service
public class EvangelismServiceImpl implements EvangelismService{

	
	private EvangelismRepository evangelismRepository;
	
	public EvangelismServiceImpl(EvangelismRepository evangelismRepository) {
		super();
		this.evangelismRepository = evangelismRepository;
	}

	@Override
	public List<Evangelism> getAllEvangelisms(String keyword) {
		if(keyword != null) {
		return evangelismRepository.findAll(keyword);
	}else
		return (List<Evangelism>) evangelismRepository.findAll();
	}

	@Override
	public Evangelism saveEvangelism(Evangelism evangelism) {
		return evangelismRepository.save(evangelism);
	}

	@Override
	public Evangelism getEvangelismById(Long id) {
		return evangelismRepository.findById(id).get();
	}

	@Override
	public Evangelism updateEvangelism(Evangelism evangelism) {
		return evangelismRepository.save(evangelism);
	}

	@Override
	public void deleteEvangelismById(Long id) {
		evangelismRepository.deleteById(id);
		
	}

	@Override
	public List<Evangelism> getAll() {
		return evangelismRepository.findAll();
	
	}
}
