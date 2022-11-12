package rewards.customers.modal;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModal {

	private Integer customerId;
	private Integer totalDollarSpent;
	private Integer transactionNo;
	private LocalDate   purchaseDate;
		
	
}
 