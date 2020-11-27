package com.cts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Party;
import com.cts.model.UserRoleMapping;
import com.cts.repository.PartyRepository;
import com.cts.repository.SeedRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SeedServiceImpl implements SeedService{

	@Autowired
	private SeedRepository seedRepo;

	@Autowired
	private PartyRepository partyRepo;

	private List<UserRoleMapping> userRole = new ArrayList<>();
	private List<Party> parties = new ArrayList<Party>();

	public String seedData() {
		userRole.add(new UserRoleMapping(0, "voter"));
		userRole.add(new UserRoleMapping(1, "candidate"));
		userRole.add(new UserRoleMapping(2, "admin"));
		// mapping the roles of user

		parties.add(new Party("A"));
		parties.add(new Party("B"));
		parties.add(new Party("C"));
		parties.add(new Party("D"));
		// adding some parties initially
		try {
			seedRepo.deleteAll();// clear the database
			seedRepo.saveAll(userRole);

			partyRepo.deleteAll();
			partyRepo.saveAll(parties);

			log.info("data seeded");
		} catch (Exception e) {

			log.info("exception occured while updating seed data");
			return "Unable to update seed";
		}
		return "data seeded successfully";
	}
}
