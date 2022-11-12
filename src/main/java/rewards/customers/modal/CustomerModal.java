package rewards.customers.modal;

import java.time.LocalDate;

//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class CustomerModal {

	private Integer customerId;
	private Integer totalDollarSpent;
	private Integer transactionNo;
	private LocalDate   purchaseDate;
	
	
	
	
	
	public CustomerModal(Integer customerId, Integer totalDollarSpent, Integer transactionNo, LocalDate purchaseDate) {
		super();
		this.customerId = customerId;
		this.totalDollarSpent = totalDollarSpent;
		this.transactionNo = transactionNo;
		this.purchaseDate = purchaseDate;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getTotalDollarSpent() {
		return totalDollarSpent;
	}
	public void setTotalDollarSpent(Integer totalDollarSpent) {
		this.totalDollarSpent = totalDollarSpent;
	}
	public Integer getTransactionNo() {
		return transactionNo;
	}
	public void setTransactionNo(Integer transactionNo) {
		this.transactionNo = transactionNo;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
}
 