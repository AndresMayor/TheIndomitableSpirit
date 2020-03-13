package model;

public class Bet {
	
	
	private String identificationCard;
	private String name;
	private int nameHorseBet;
	private double betAmount;
	
	
	
	public Bet(String identificationCard, String name, int nameHorseBet, double betAmount) {
		
		this.identificationCard = identificationCard;
		this.name = name;
		this.nameHorseBet = nameHorseBet;
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



	public int getNameHorseBet() {
		return nameHorseBet;
	}



	public void setNameHorseBet(int nameHorseBet) {
		this.nameHorseBet = nameHorseBet;
	}



	public double getBetAmount() {
		return betAmount;
	}



	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}
	
	
	
	

}
