package com.church.service;

import java.util.List;

import com.church.model.Notem;

public interface NotemService {

List<Notem> getAllNotems(String keyword);

List<Notem> getAll();
	
Notem saveNotem(Notem note);
	
Notem getNotemById(Long id);
	
Notem updateNotem(Notem note);
	
	void deleteNotemById(Long id);
}

