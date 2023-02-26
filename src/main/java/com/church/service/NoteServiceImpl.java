package com.church.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.church.model.Note;
import com.church.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{

	
	private NoteRepository noteRepository;
	
	public NoteServiceImpl(NoteRepository noteRepository) {
		super();
		this.noteRepository = noteRepository;
	}

	@Override
	public List<Note> getAllNotes(String keyword) {
		if(keyword != null) {
		return noteRepository.findAll(keyword);
	}else
		return (List<Note>) noteRepository.findAll();
	}

	@Override
	public Note saveNote(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public Note getNoteById(Long id) {
		return noteRepository.findById(id).get();
	}

	@Override
	public Note updateNote(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public void deleteNoteById(Long id) {
		noteRepository.deleteById(id);
		
	}

	@Override
	public List<Note> getAll() {
		return noteRepository.findAll();
	
	}
}
