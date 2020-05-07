package com.bridgelabz.fundoonotes.serviceimplementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoonotes.configuration.ElasticSearchConfig;
import com.bridgelabz.fundoonotes.constant.Constant;
import com.bridgelabz.fundoonotes.model.NoteModel;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.ElasticsearchService;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * this class has the implements functionality of searchNote,createNote,
 * deleteNote,updateNote, * note after verifying with the identity.

 * @author chaithra B N
 *
 */

@Service
public class ElasticsearchServiceImplementation implements  ElasticsearchService{

	private Constant constant = new Constant();

	@Autowired
	private ElasticSearchConfig elasticSearchConfig;
	
	
	@Autowired
	private NoteRepository noteRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;

	
	@Autowired
	private UserRepository userRepository;
	
	public List<NoteModel> searchNote(long title, long noteId){
		try {
			NoteModel note=noteRepository.findById(noteId);
			if (note !=null) {
				List<NoteModel> isTitlePresent=noteRepository.searchAllNotesByNoteId(title, noteId);
			
			if(isTitlePresent !=null) {
				return noteRepository.getalltrashed(title);
			}
			}
			else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String createNote(NoteModel note) {
		try {
			Map<String, Object> noteMapper = objectMapper.convertValue(note, Map.class);
			IndexRequest indexRequest = new IndexRequest(constant.INDEX, constant.TYPE, String.valueOf(note.getId()))
					.source(noteMapper);
			IndexResponse indexResponse = elasticSearchConfig.client().index(indexRequest, RequestOptions.DEFAULT);
			System.out.println(indexRequest + " " + indexResponse);
			return indexResponse.getResult().name();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateNote(long noteId) {
		try {
			NoteModel note = noteRepository.findById(noteId);
			Map<String, Object> notemapper = objectMapper.convertValue(note, Map.class);
			UpdateRequest updateRequest = new UpdateRequest(constant.INDEX, constant.TYPE, String.valueOf(note.getId()))
					.doc(notemapper);
			UpdateResponse updateResponse = elasticSearchConfig.client().update(updateRequest, RequestOptions.DEFAULT);
			//log.info(updateResponse.getResult().name());
			System.out.println(updateResponse.getResult().name());
		} catch (IOException e) {
			//log.warn(e.getMessage());
			
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String deleteNote(long noteId) {
		try {
			NoteModel note = noteRepository.findById(noteId);
			DeleteRequest deleterequest = new DeleteRequest(constant.INDEX, constant.TYPE, String.valueOf(note.getId()));
			DeleteResponse deleteResponse = elasticSearchConfig.client().delete(deleterequest, RequestOptions.DEFAULT);
			return deleteResponse.getResult().name();
		} catch (IOException e) {
			//log.warn(e.getMessage());
			System.out.println(e.getMessage());

		}
		return null;
	}

	public List<NoteModel> searchTitle(String title) {
		try {
			SearchRequest searchrequest = new SearchRequest("Bridgelabz");
			SearchSourceBuilder searchsource = new SearchSourceBuilder();
			searchsource.query(QueryBuilders.matchQuery("Title", title));
			searchrequest.source(searchsource);
			SearchResponse searchresponse = elasticSearchConfig.client().search(searchrequest, RequestOptions.DEFAULT);
			return getResult(searchresponse);
		} catch (Exception e) {
			//log.error(e.getMessage());
			System.out.println(e.getMessage());

		}
		return null;

	}

	private List<NoteModel> getResult(SearchResponse searchresponse) {
		try {
			SearchHit[] search = searchresponse.getHits().getHits();
			List<NoteModel> note = new ArrayList<>();
			if (search.length > 0) {
				Arrays.stream(search)
						.forEach(s -> note.add(objectMapper.convertValue(s.getSourceAsMap(), NoteModel.class)));
			}
			return note;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String createNote(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchNote(String note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoteModel> searchTitle(Long title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoteModel> searchNote(String title, long noteId) {
		// TODO Auto-generated method stub
		return null;
	}
}