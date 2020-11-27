package com.cts.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="voting-system-authentication-service")
public interface AuthenticationFeign {

	@PostMapping("/authenticate/validate")
	public boolean validateToken(@RequestBody String token);
	
	@PostMapping("/authenticate/username")
	public String userName(String token);
	
}
