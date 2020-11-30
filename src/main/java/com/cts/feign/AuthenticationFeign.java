package com.cts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="voting-system-zuul-service")
public interface AuthenticationFeign {

	@PostMapping("voting-system-authentication-service/authenticate/validate")
	public boolean validateToken(@RequestBody String token);
	
	@PostMapping("voting-system-authentication-service/authenticate/username")
	public String userName(String token);
	
}
