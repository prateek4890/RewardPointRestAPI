package rewards.customers.modal;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class RewardsPointsModal {
	private Integer customerId;
	private Integer totalDollarSpent;
 	private Integer transactionNo;
 	private LocalDate   purchaseDate;
 	private Integer totalRewardsPoint;
	
}
