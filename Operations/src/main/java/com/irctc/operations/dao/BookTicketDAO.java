package com.irctc.operations.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.irctc.operations.model.BookTicket;

@Repository
public interface BookTicketDAO extends CrudRepository<BookTicket, String> {

	@Query(value = "select * from book_ticket where user_id=?1", nativeQuery = true)
	public List<BookTicket> findByUserId(String userId);

}
