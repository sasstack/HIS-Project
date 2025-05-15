 package com.issuance.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.issuance.binding.CaseResponse;




//@FeignClient(name = "data-collection",url = "http://localhost:8085")
@FeignClient(name = "data-collection")
public interface DataCollectionFeign {

	@GetMapping("/case/{caseNum}")
	public CaseResponse getCaseEntity(@PathVariable Long caseNum);
}
