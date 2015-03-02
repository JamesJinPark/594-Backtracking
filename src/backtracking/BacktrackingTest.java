package backtracking;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * @author James Park
 * CIT 594 - Backtracking test
 *
 */
public class BacktrackingTest {
	
	int[] array1 = {3, 6, 4, 1, 3, 4, 2, 5, 3, 0};
	int[] array2 = {3, 1, 2, 3, 0};
	int[] array3 = {3, 6, 4, 1, 3, 4, 2, 5, 3, 20};
	int[] array4 = {3, 6, 4, 1, 200, 4, 2, 5, 3, 0};
	int[] array5 = {3, 6, 4, 1, 0, 4, 2, 5, 3, 10};
	int[] array6 = {1, 1, 1, 1, 1};
	int[] array7 = {2};
	int[] array8 = {3, 6, 4, 1, 3, 4, 2, 5, 3, 1, 2, 9, 2};
	
	Stack<Character> stack1;
	Stack<Character> stack2;
	Stack<Character> stack3;
	
	Set<Stack<Character>> empty = Collections.emptySet();
	
	/**
     * Test method for {@link backtracking.Backtracking#solve()}.
     */
	@Test
	public void testSolve() {
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		Stack<Character> stack3 = new Stack<Character>();
		
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		
		stack2.push('R');
		stack2.push('R');
		stack2.push('R');
		stack2.push('R');
				
		assertNull(Backtracking.solve(array2));
		assertTrue(Backtracking.solve(array1).equals(stack1));
		
		assertTrue(Backtracking.solve(array3).equals(stack1));
		assertTrue(Backtracking.solve(array4).equals(stack1));
		assertTrue(Backtracking.solve(array5).equals(stack1));
		
		assertTrue(Backtracking.solve(array6).equals(stack2));
		assertTrue(Backtracking.solve(array7).equals(stack3));		
	}

	/**
     * Test method for {@link backtracking.Backtracking#findAllSolutions()}.
     */
	@Test
	public void testFindAllSolutions() {
		
		assertTrue(empty.equals(Backtracking.findAllSolutions(array2)));
			
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		Stack<Character> stack3 = new Stack<Character>();
		Stack<Character> stack4 = new Stack<Character>();
		Stack<Character> stack5 = new Stack<Character>();
		Stack<Character> stack6 = new Stack<Character>();
		Stack<Character> stack7 = new Stack<Character>();
		Stack<Character> stack8 = new Stack<Character>();
		
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('L');
		stack1.push('R');
		stack1.push('R');
		stack1.push('R');
		
		stack2.push('R');
		stack2.push('R');
		stack2.push('R');
		stack2.push('R');
		
		stack3.push('R');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		stack3.push('L');
		stack3.push('R');
		stack3.push('R');
		stack3.push('R');

		stack4.push('R');
		stack4.push('L');
		stack4.push('R');
		stack4.push('L');
		stack4.push('L');
		stack4.push('R');
		stack4.push('R');

		stack5.push('R');
		stack5.push('R');
		stack5.push('L');
		stack5.push('R');
		stack5.push('R');
		
		stack6.push('R');
		stack6.push('L');
		stack6.push('R');
		stack6.push('R');
		stack6.push('L');
		stack6.push('L');
		stack6.push('R');
		stack6.push('R');
		
		stack7.push('R');
		stack7.push('L');
		stack7.push('R');
		stack7.push('L');
		stack7.push('R');
		stack7.push('R');
		
		stack8.push('R');
		stack8.push('R');
		stack8.push('R');
		stack8.push('L');
		stack8.push('R');
		stack8.push('R');
		stack8.push('L');
		stack8.push('R');
		stack8.push('R');
		stack8.push('R');
						
		Set<Stack<Character>> set1 = new HashSet<Stack<Character>>();
		
		set1.add(stack1);
		set1.add(stack2);
		set1.add(stack3);
		set1.add(stack4);
		set1.add(stack5);
		set1.add(stack6);
		set1.add(stack7);
		set1.add(stack8);

		assertTrue(set1.equals(Backtracking.findAllSolutions(array8)));
		
		Stack<Character> stack9 = new Stack<Character>();
		Stack<Character> stack10 = new Stack<Character>();
		Stack<Character> stack11 = new Stack<Character>();
		
		stack9.push('R');
		stack9.push('R');
		stack9.push('R');
		stack9.push('L');
		stack9.push('R');
		stack9.push('R');
		stack9.push('L');
		stack9.push('R');
		
		stack10.push('R');
		stack10.push('R');
		stack10.push('L');
		stack10.push('R');
		stack10.push('L');
		stack10.push('R');
		stack10.push('R');
		stack10.push('L');
		stack10.push('R');

		stack11.push('R');
		stack11.push('L');
		stack11.push('R');
		stack11.push('R');
		stack11.push('L');
		stack11.push('R');

		Set<Stack<Character>> set2 = new HashSet<Stack<Character>>();
		
		set2.add(stack9);
		set2.add(stack10);
		set2.add(stack11);
		
		assertTrue(set2.equals(Backtracking.findAllSolutions(array1)));
	}
}
