package rewards.customers.service;

public interface CalculateRewardPoint {
	public static   Integer calRewardPoint(int amount) {
		int point = 0;
		if (amount > 50 && amount <= 100) {
			point = (amount - 50) * 1;
		} else if (amount > 100) {
			point = (amount - 100) * 2;
			point = point + 50;
		}
		return point;
	}

}
