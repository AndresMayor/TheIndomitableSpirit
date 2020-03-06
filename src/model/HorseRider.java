package model;

public class HorseRider {

	
	
	private String nameJinete;
	private String nameHorse;
	private int track;
	
	
	public HorseRider(String nameJinete, String nameHorse, int track) {
		
		this.nameJinete = nameJinete;
		this.nameHorse = nameHorse;
		this.track = track;
	}


	public String getNameJinete() {
		return nameJinete;
	}


	public void setNameJinete(String nameJinete) {
		this.nameJinete = nameJinete;
	}


	public String getNameHorse() {
		return nameHorse;
	}


	public void setNameHorse(String nameHorse) {
		this.nameHorse = nameHorse;
	}


	public int getTrack() {
		return track;
	}


	public void setTrack(int track) {
		this.track = track;
	}
	
	
	
}
