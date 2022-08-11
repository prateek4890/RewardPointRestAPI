package rewards.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rewards.customers.dto.RewardsPointDto;
import rewards.customers.response.RewardsResponse;
import rewards.customers.service.RewardsService;

@RestController
@RequestMapping("/customer")
public class RewardsController {
	@Autowired
	RewardsService rewardsService;
	@PostMapping("/reward")
	public ResponseEntity<RewardsResponse> getRewardsPoint(@RequestBody RewardsPointDto reqPaylaod){
		return ResponseEntity.status(HttpStatus.OK).body(rewardsService.getRewardsPoint(reqPaylaod));
	}
}
