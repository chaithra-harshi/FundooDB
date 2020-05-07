package com.bridgelabz.fundoonotes.service;

import java.util.List;

import com.bridgelabz.fundoonotes.model.NoteModel;
/**
 * creating  elastic search interface
 * @author chaithra B N
 *
 */
public interface ElasticsearchService {
public String createNote(String note);
public String searchNote(String note);
public void updateNote(long noteId);

public String deleteNote(long noteId);
public List<NoteModel> searchTitle(Long title);
List<NoteModel> searchNote(String title, long noteId);

}
