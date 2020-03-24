package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.Stack;

public class TestStack {
	
	private Stack<String> stack;
	@Test
	
	
	public void setStage1() {
		
		stack = new Stack();
		
	}	
	public void setStage2() {
		
		stack = new Stack();
		stack.push("Andy");
		stack.push("albert");
		stack.push("Olga");
	}
	
	public  void testPop1() {
		setStage1();
		String element = stack.pop();
		assertTrue(element == null);
		
	}

	public  void testPop2() {
		setStage2();
		String element = "Olga";
		assertTrue(element.equals(stack.pop()));
		
	}
	
	public  void testPeek1() {
		setStage1();
		String element = stack.peek();
		assertTrue(element == null);
		
	}

	public  void testPeek2() {
		setStage2();
		String element = "Andy";
		assertTrue(element.equals(stack.peek()));
		
	}
	
	public void testpush1() {
		setStage1();
		String element = "Olga";
		stack.push(element);;
		assertTrue(element.equals(stack.peek()));
	}
	public void testpush2() {
		setStage2();
		String element = "Olga";
		stack.push(element);;
		assertTrue(element.equals(stack.peek()));
	}

}
