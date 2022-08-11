package rewards.customers.service.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rewards.customers.dto.RewardsPointDto;
import rewards.customers.modal.AggrigateRewardsModal;
import rewards.customers.modal.CustomerModal;
import rewards.customers.modal.RewardsPointsModal;
import rewards.customers.response.RewardsResponse;
import rewards.customers.service.CalculateRewardPoint;
import rewards.customers.service.RewardsService;

@Slf4j
@Service
public class RewardsServiceImpl implements RewardsService {

	@Override
	public RewardsResponse getRewardsPoint(RewardsPointDto reqPaylaod) {
		// TODO Auto-generated method stub

		try {
		 
			List<RewardsPointsModal> listWithRewardPoint = getCustomerData().stream().filter(
					(purchaseDate -> purchaseDate.getPurchaseDate().isAfter(LocalDate.parse(reqPaylaod.getStartDate()))
							&& (purchaseDate.getPurchaseDate().isBefore(LocalDate.parse(reqPaylaod.getEndDate()))
									|| purchaseDate.getPurchaseDate()
											.isEqual(LocalDate.parse(reqPaylaod.getEndDate())))))
					.filter(purchaseDate -> purchaseDate.getCustomerId().equals(reqPaylaod.getCustomerId()))
					.collect(Collectors.toList()).stream().map(data -> {
						RewardsPointsModal rpm = new RewardsPointsModal();
						rpm.setCustomerId(data.getCustomerId());
						rpm.setTransactionNo(data.getTransactionNo());
						rpm.setPurchaseDate(data.getPurchaseDate());
						rpm.setTotalDollarSpent(data.getTotalDollarSpent());
						rpm.setTotalRewardsPoint(CalculateRewardPoint.calRewardPoint(data.getTotalDollarSpent()));
						return rpm;
					}).collect(Collectors.toList());

			Map<YearMonth, Integer> monthWiseReward = listWithRewardPoint.stream()
					.collect(Collectors.groupingBy(m -> YearMonth.from(m.getPurchaseDate()), TreeMap::new,
							Collectors.summingInt(m -> m.getTotalRewardsPoint())));
//
//			monthWiseReward.entrySet().stream()
//					.forEach(e -> log.info("RewardByMonth : " + e.getKey() + "RewardByMonth value : " + e.getValue()));

			List<AggrigateRewardsModal> data = monthWiseReward.entrySet().stream().map(e -> {
				AggrigateRewardsModal arm = new AggrigateRewardsModal();
				arm.setPurchaseMonth(e.getKey().format(DateTimeFormatter.ofPattern("MMMM, yyyy", Locale.ENGLISH)));
				arm.setTotalRewardsPoint(e.getValue());
				return arm;

			}).collect(Collectors.toList());

			if (data.size() <1) {
				return new RewardsResponse(false, "Details are Not Found", null);
			} else {

				return new RewardsResponse(true, "Reward Details", data);
			}

		} catch (ParseException e) {
 			log.error("ParseException >>>> ", e);
			return new RewardsResponse(false, "ParseException- " + e, null);

		} catch (Exception e) {
 			log.error("Exception >>>> ", e);
			return new RewardsResponse(false, "Exception- " + e.getMessage(), null);

		}
	}

	

	public List<CustomerModal> getCustomerData() throws ParseException {
		/*
		 * Data set containing customer id,spend amount ,transaction no,transaction data
		 */
                
		return List.of(new CustomerModal(1, 120, 1111, LocalDate.parse("2022-08-01")),
				new CustomerModal(1, 220, 1112, LocalDate.parse("2022-06-01")),
				new CustomerModal(1, 50, 1113, LocalDate.parse("2022-08-01")),
				new CustomerModal(1, 0, 1114, LocalDate.parse("2022-08-01")),
				new CustomerModal(1, 100, 1115, LocalDate.parse("2022-07-30")),
				new CustomerModal(1, 99, 1116, LocalDate.parse("2022-08-01")),
				new CustomerModal(1, 330, 1117, LocalDate.parse("2022-08-01")),
				new CustomerModal(1, 1220, 1118, LocalDate.parse("2022-08-01")),
				new CustomerModal(1, 200, 1119, LocalDate.parse("2022-08-01")),
				new CustomerModal(3, 500, 1120, LocalDate.parse("2022-08-01")),
				new CustomerModal(3, 500, 1121, LocalDate.parse("2022-08-01")),
				new CustomerModal(3, 500, 1122, LocalDate.parse("2022-08-02")),
				new CustomerModal(2, 145, 1123, LocalDate.parse("2022-08-01")));
	}

}
