package com.ntl.movieapp.search.dao;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntl.movieapp.search.model.SearchHistory;



@Repository
public interface SearchDao extends JpaRepository<SearchHistory, Integer>{

	public List<SearchHistory> findAllByUserId(String userId);
	public List<SearchHistory> findAllByMovieId(int movieId);
	
	 @Transactional
	 @Modifying
	 @Query(value = "select * from search_history  where search_time like ?%", 
	   nativeQuery = true)

	public List<SearchHistory> findAllBySearchDay(String date);

	 @Transactional
	 @Modifying
	 @Query(value = "select * from search_history  where search_time like ?% and user_id = ?", 
	   nativeQuery = true)
	 
	public List<SearchHistory> findAllBySearchDateAndUserId(String date, String userId);
	 

	 @Transactional
	 @Modifying
	 @Query(value = "select * from search_history  where search_time like ?% and movie_id = ?", 
	   nativeQuery = true)
	 
	public List<SearchHistory> findAllBySearchDateAndMovieId(String date, int movieId);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "select * from search_history  where user_id = ? and movie_id = ?", 
	   nativeQuery = true)
	 
	public List<SearchHistory> findAllByUserIdAndMovieId(String userId, int movieId);
	 
}
