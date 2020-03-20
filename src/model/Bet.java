package model;

public class Bet {
	
	
	private String identificationCard;
	private String name;
	private int numberHorseBet;
	private double betAmount;
	
	
	
	public Bet(String identificationCard, String name, int numberHorseBet, double betAmount) {
		
		this.identificationCard = identificationCard;
		this.name = name;
		this.numberHorseBet = numberHorseBet;
		this.betAmount = betAmount;
	}



	public String getIdentificationCard() {
		return identificationCard;
	}



	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNumberHorse() {
		return numberHorseBet;
	}



	public void setNumberHorse(int nameHorseBet) {
		this.numberHorseBet = nameHorseBet;
	}



	public double getBetAmount() {
		return betAmount;
	}



	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}



	@Override
	public String toString() {
		return "Bet [identificationCard=" + identificationCard + ", name=" + name + ", numberTrackHorse=" + numberHorseBet
				+ ", betAmount=" + betAmount + "]";
	}
	
	
	
	

}
