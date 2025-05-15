package com.datacollection.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="app-registration",url = "http://localhost:8084")
@FeignClient(name="app-registration")
public interface AppRegistrationInterface {

	@GetMapping("/app/{appId}")
	public Boolean findById(@PathVariable Integer appId);
	
}
