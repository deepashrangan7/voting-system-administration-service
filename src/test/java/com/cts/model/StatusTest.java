package com.cts.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StatusTest {

	@Test
	void statusCodeTest() {
		Status status = new Status(200, "OK");
		assertEquals(200, status.getStatusCode());
	}

	@Test
	void toStringTest() {
		Status status = new Status(200, "OK");
		assertEquals(status.toString(), status.toString());
	}

	@Test
	void statusCodeTest2() {
		Status status = new Status();
		status.setStatusCode(200);
		status.setMessage("OK");
		assertEquals("OK", status.getMessage());
	}

	@Test
	void errorsTest() {
		Status status = new Status(200, "ok", null);
		status.setFieldErrors(null);
		assertNull(status.getFieldErrors());
	}
}
