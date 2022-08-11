package rewards.customers.service;

import rewards.customers.dto.RewardsPointDto;
import rewards.customers.response.RewardsResponse;

public interface RewardsService {
	public RewardsResponse getRewardsPoint(RewardsPointDto reqPaylaod);
}
