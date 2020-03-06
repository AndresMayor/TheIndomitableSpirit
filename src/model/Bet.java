package model;

public class Bet {
	
	
	private int identificationCard;
	private String name;
	private String nameHorseBet;
	private double betAmount;
	
	
	
	public Bet(int identificationCard, String name, String nameHorseBet, double betAmount) {
		
		this.identificationCard = identificationCard;
		this.name = name;
		this.nameHorseBet = nameHorseBet;
		this.betAmount = betAmount;
	}



	public int getIdentificationCard() {
		return identificationCard;
	}



	public void setIdentificationCard(int identificationCard) {
		this.identificationCard = identificationCard;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getNameHorseBet() {
		return nameHorseBet;
	}



	public void setNameHorseBet(String nameHorseBet) {
		this.nameHorseBet = nameHorseBet;
	}



	public double getBetAmount() {
		return betAmount;
	}



	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}
	
	
	
	

}
