package com.church.service;

import java.util.List;

import com.church.model.Note;

public interface NoteService {

List<Note> getAllNotes(String keyword);

List<Note> getAll();
	
Note saveNote(Note note);
	
Note getNoteById(Long id);
	
Note updateNote(Note note);
	
	void deleteNoteById(Long id);
}
