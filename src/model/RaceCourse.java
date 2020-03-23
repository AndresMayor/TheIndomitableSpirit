package model;





import collections.HashTable;
import collections.Queue;
import collections.Stack;

public class RaceCourse{
	
	private Queue<HorseRider> horses;
	private Queue<HorseRider> resultado;
	private HashTable<String, Bet> bets;
	private int size;
	
	public Queue<HorseRider> getHorses() {
		return horses;
	}

	public void setHorses(Queue<HorseRider> horses) {
		this.horses = horses;
	}

	public RaceCourse() {
		resultado = new Queue<HorseRider>();
		horses = new Queue<HorseRider>();
		bets = new HashTable<String, Bet>();
		
	}
	
	public void addHorse(HorseRider h) {
		horses.offer(h);
		
	}
	
	public Queue<HorseRider> game() {
		Queue<HorseRider> def = new Queue<HorseRider>();
		HorseRider[] array = new HorseRider[10];
		for (int i = 0; i < size;) {
			HorseRider h1 = horses.peek();
			int pos = (int) (Math.random()*size);
			if(array[pos]==null) {
				array[pos] = h1;
				horses.poll();
				i++;
			}
		}	
		for (int i = 0; i < size; i++) {
			def.offer(array[i]);
			addHorse(array[i]);
		}
		resultado = def;
		return def;
	}
	
	public void sizeQueue(int number) {
		size = number;
	}
	
	public Queue<HorseRider> rematch() {
		Queue<HorseRider> def = resultado;
		Stack<HorseRider> rem = new Stack<HorseRider>();
		
		for (int i = 0; i < size; i++) {
			rem.push(def.poll());
		}
		for (int i = 0; i < size; i++) {
			def.offer(rem.pop());
		}
		resultado = null;
		resultado = def;
		return def;
	}
	
	public void addBet(Bet b) {
		bets.insert(b.getIdentificationCard(), b);
	}
	
	
	
	public HashTable<String,Bet> getBets(){
		return bets;
	}

	public void setBets(HashTable<String, Bet> bets) {
		this.bets = bets;
	}
	
	
	
	
	public String  searchBet(String cc) {
		
		
		String thebest ="You LOST the bet :("+"\n";
		
		
		Bet bet = bets.search(cc);
		
		
		
		if (bet.getNumberHorse()  == horses.peek().getTrack()) {
			
			thebest ="You WON the bet :) "+ bet.getBetAmount()*2+ "\n" ;
	
		}
		thebest += bet ;
		
		return thebest;
	}

	
	public String show() throws Exception {
		String ms = "";

		for (int i = 0; i < horses.getSize(); i++) {
			HorseRider h = horses.dequeue();
			ms += h.toString() + "\n";
			addHorse(h);

		}

		return ms;
	}
	
	public String showRematch() throws Exception {
		String ms = "";

		for (int i = 0; i < size; i++) {
			HorseRider h = resultado.dequeue();
			ms += h.toString() + "\n";
			addHorse(h);

		}

		return ms;
	}

	
	

	
	
	
	
}