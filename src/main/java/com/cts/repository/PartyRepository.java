package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
	
	public Party findByPartyName(String partyName);
	

}
