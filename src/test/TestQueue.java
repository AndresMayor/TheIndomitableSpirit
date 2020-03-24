package test;

import static org.junit.jupiter.api.Assertions.*;
import collections.Queue;


import org.junit.jupiter.api.Test;

public class TestQueue {
	
	private Queue<String> queue;

	@Test
	
	public void setstage1() {
		
		queue = new Queue();
		
	}
	
	public void setstage2() {
		
		queue = new Queue();
		
		queue.offer("Andy");
		queue.offer("MG");
		queue.offer("JH");
		queue.offer("Dk");
	}
	
	public void testPeek() {
		setstage2();
		String element = "Andy";
		assertTrue(element.equals(queue.peek()));
	}
	
	public void testPoll() {
		setstage2();
		String element = "Dk";
		assertTrue(element.equals(queue.poll()));
	}
	
	public void testPeek2() {
		setstage1();
		String element = queue.peek();
		assertTrue(element ==null);
	}
	
	
	public void testPoll2() {
		setstage1();
		String element = queue.poll();
		assertTrue(element == null);
	}

}
