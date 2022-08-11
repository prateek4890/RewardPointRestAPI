package rewards.customers.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rewards.customers.modal.AggrigateRewardsModal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class RewardsResponse {
	private  Boolean status;
	private  String msg;
	private  List<AggrigateRewardsModal>   data;

}
