package unisa.dse.a2.students;

public class ListedCompany {

	/**
	 * The full name of the company
	 */
	private String name;
	
	public String getName() {
		return this.name;
	}

	/**
	 * The listing code of the company
	 */
	private String code;
	
	public String getCode() {
		return this.code;
	}

	/**
	 * Current price of the company after last trade
	 */
	private double currentPrice;
	
	public double getCurrentPrice() {
		return this.currentPrice;
	}
	
	public ListedCompany(String code, String name, double currentPrice) {
		this.code = code;
		this.name = name;
		this.currentPrice = currentPrice;
	}
	
	/**
	 * Processing a trade should increase the current price of the company by 
	 *    quantity / 100
	 * A company's price CANNOT go below 1
	 * 
	 * @param quantity
	 * @return the price after adjustment
	 */
	public double processTrade(double quantity)	{
		if (this.currentPrice + (quantity / 100) >= 1) {
			this.currentPrice += quantity / 100;
			return this.currentPrice;
		}else {
			this.currentPrice = 1;
			return this.currentPrice;
		}
	}
}
