package com.ntl.movieapp.search.controller;

import static org.junit.Assert.*;

import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.ntl.movieapp.search.model.Movie;
import com.ntl.movieapp.search.service.SearchService;


@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

	@Mock
	SearchService serve;
	
	String stdate="12/11/2015";
	String startd[]=stdate.split("/");
	LocalDate dt=LocalDate.of(Integer.parseInt(startd[2]),Integer.parseInt(startd[1]), Integer.parseInt(startd[0]));
	
	Movie move=new Movie(1,"ishanya","jkbjb",dt,"kjbhjub");
	
	@Test
	public void testSearchList() {
		
		List<Movie> listing=new ArrayList();
		listing.add(move);
		
		when(serve.allMoviesByTitle("kal")).thenReturn(listing);
		SearchController control=new SearchController(serve);
		listing=control.searchList("kal");
		assertEquals(1,listing.size());
	}

	@Test
	public void testSearchFavList() {
		List<Movie> listing=new ArrayList();
		listing.add(move);
		
		List<Integer> listOfId=new ArrayList();
		listOfId.add(1);
		
		when(serve.allMoviesById(listOfId)).thenReturn(listing);
		SearchController control=new SearchController(serve);
		
		listing=control.searchFavList("1");
		
		assertEquals(1,listing.size());
	}

}
