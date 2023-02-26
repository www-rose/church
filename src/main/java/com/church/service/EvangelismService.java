package com.church.service;

import java.util.List;

import com.church.model.Evangelism;

public interface EvangelismService {

List<Evangelism> getAllEvangelisms(String keyword);

List<Evangelism> getAll();
	
Evangelism saveEvangelism(Evangelism evangelism);
	
Evangelism getEvangelismById(Long id);
	
Evangelism updateEvangelism(Evangelism evangelism);
	
	void deleteEvangelismById(Long id);
}