package test;
import model.Bet;
import model.HorseRider;
import model.RaceCourse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRaceCourse {
	private RaceCourse race;
	@Test
	
	public  void setStage() {
		race= new RaceCourse();
		
		
		
		Bet b1 = new Bet("333", "dsds", 1, 100);
		Bet b2 = new Bet("32", "dss", 2, 100);
		Bet b3 = new Bet("23", "sdd", 3, 100);
		
		HorseRider h1 = new HorseRider("yegua1", "dssd", 1);
		HorseRider h2 = new HorseRider("caballoo2", "dsdds", 2);
		HorseRider h3 = new HorseRider("yegua3", "dsds", 3);
		HorseRider h4 = new HorseRider("yegua4", "dsdsd", 4);
		HorseRider h5 = new HorseRider("caballoo5", "dsdsds", 5);
		HorseRider h6 = new HorseRider("yegu6", "dssdd", 6);
		HorseRider h7 = new HorseRider("yegu7", "dssd", 7);
		
		race.addHorse(h1);
		race.addHorse(h2);
		race.addHorse(h3);
		race.addHorse(h4);
		race.addHorse(h5);
		race.addHorse(h6);
		race.addHorse(h7);
		race.addBet(b1);
		race.addBet(b2);
		race.addBet(b3);
	
}
	
	@Test
	public void game() {
		
		setStage();
		race = new RaceCourse();
		RaceCourse race1 = new RaceCourse();
		
		HorseRider h1 = new HorseRider("yegua1", "fv", 2);
		HorseRider h2 = new HorseRider("caballoo2","vef", 2);
		HorseRider h3 = new HorseRider("yegua3", "vf", 2);
		HorseRider h4 = new HorseRider("yegua4", "fv", 2);
		HorseRider h5 = new HorseRider("caballoo5", "vef", 2);
		HorseRider h6 = new HorseRider("yegua6", "vf", 2);
		HorseRider h7 = new HorseRider("yegua7", "fv", 2);
	
		race1.addHorse(h1);
		race1.addHorse(h2);
		race1.addHorse(h3);
		race1.addHorse(h4);
		race1.addHorse(h5);
		race1.addHorse(h6);
		race1.addHorse(h7);
		
		race1.game();
		
		
		boolean horses = race.getHorses().equals(race1.getHorses());
		assertTrue(!horses);
		
	}

	@Test
	public void consultBet() {
		setStage();
		Bet b1 = new Bet("33", "dsds", 1, 100);
		race.addBet(b1);
		assertTrue(b1.equals(race.getBets().search("33")));
		
		}
	
	
	}
	
