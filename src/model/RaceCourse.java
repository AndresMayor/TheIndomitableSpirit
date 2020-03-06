package model;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RaceCourse{
	
	private Queue<HorseRider> horses;
	private int size;
	
	public RaceCourse() {
		
		horses = new LinkedList<HorseRider>();
		
	}
	
	public void addHorse(HorseRider h) {
		horses.offer(h);
	}
	
	public Queue<HorseRider> game() {
		Queue<HorseRider> def = new LinkedList<HorseRider>();
		HorseRider[] array = new HorseRider[10];
		if(sizeQueue()) {
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
		}
		return def;
	}
	
	public boolean sizeQueue() {
		size = horses.size();
		if(size<10) {
			return true;
		}else {
			return false;
		}
	}
	
	public Queue<HorseRider> rematch() {
		size = game().size();
		Queue<HorseRider> def = game();
		Stack<HorseRider> rematch = new Stack<HorseRider>();
		if(sizeQueue()) {
			for (int i = 0; i < size; i++) {
				rematch.push(def.poll());
			}
			for (int i = 0; i < size; i++) {
				def.offer(rematch.pop());
			}
		}
		return def;
	}
	
}