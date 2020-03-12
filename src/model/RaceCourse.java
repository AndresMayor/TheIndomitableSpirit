package model;



import java.util.ArrayList;

import collections.HashTable;
import collections.Queue;
import collections.Stack;

public class RaceCourse{
	
	private Queue<HorseRider> horses;
	private HashTable<String, ArrayList<Queue<Bet>>> bet;
	private int size;
	
	public Queue<HorseRider> getHorses() {
		return horses;
	}

	public void setHorses(Queue<HorseRider> horses) {
		this.horses = horses;
	}

	public RaceCourse() {
		
		horses = new Queue<HorseRider>();
		bet = new HashTable<String, ArrayList<Queue<Bet>>>();
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
		}
		return def;
	}
	
	public void sizeQueue(int number) {
		size = number;
	}
	
	public Queue<HorseRider> rematch() {
		Queue<HorseRider> def = game();
		Stack<HorseRider> rematch = new Stack<HorseRider>();
		
		for (int i = 0; i < size; i++) {
			rematch.push(def.poll());
		}
		for (int i = 0; i < size; i++) {
			def.offer(rematch.pop());
		}
		return def;
	}
	
}