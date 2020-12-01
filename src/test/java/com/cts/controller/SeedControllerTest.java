package com.cts.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.service.SeedService;

@SpringBootTest
class SeedControllerTest {

	@Mock
	SeedService seedService;

	@Test
	void test() {
		SeedController sc = new SeedController();
		when(seedService.seedData()).thenReturn("done");
		sc.setSeedService(seedService);
		assertEquals("done", sc.updateData());
	}

}
