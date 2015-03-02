package backtracking;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author James Park
 * CIT 594 - Backtracking
 *
 */
public class Backtracking {
		
	/**
	 * Helper function for solve()
	 * 
	 * Returns a Stack of Rs and Ls that gives a path from puzzle[0] to puzzle[puzzle.length -1]
	 * 
	 * @param top
	 * @param visited
	 * @param puzzle
	 * @param stack
	 * @return Stack<Character>
	 */
	private static Stack<Character> solveHelper(int top, int[] visited, int[] puzzle, Stack<Character> stack){
		if(top == (puzzle.length - 1)){
			return stack;
		}
		//for each child of puzzle[top]
		int left = top - puzzle[top];
		int right = top + puzzle[top];
		if(left >= 0 && left < puzzle.length && visited[left] != 'X'){
			stack.push('L');
			visited[left] = 'X';
			if(solveHelper(left, visited, puzzle, stack) != null){
				return stack;
			}
			else{
				stack.pop();
			}
		}
		if(right >= 0 && right < puzzle.length && visited[right] != 'X'){
			stack.push('R');
			visited[right] = 'X';
			if(solveHelper(right, visited, puzzle, stack) != null){
				return stack;
			}
			else{
				stack.pop();
			}
		}
		return null;
	}
	
	/**
	 * Takes a puzzle and calls solveHelper to find a path from the beginning to the end
	 * 
	 * Returns a Stack of Rs and Ls 
	 * 
	 * @param puzzle
	 * @return Stack<Character>
	 */
	public static Stack<Character> solve(int[] puzzle){
		Stack<Character> stack = new Stack<Character>();
		int[] visited = new int[puzzle.length];
		int top = 0;
		stack = solveHelper(top,visited, puzzle, stack);
		if(stack == null){
			return null;
		}
		else{
			return stack;
		}
	}


	/**
	 * 
	 * Helper function for findAllSolutions
	 * 
	 * Finds all possible solutions for a given int[] puzzle and puts them in a set
	 * 
	 * @param top
	 * @param visited
	 * @param puzzle
	 * @param stack
	 * @param set
	 * @return Set<Stack<Character>>
	 */
	@SuppressWarnings("unchecked")
	private static Set<Stack<Character>> findHelper(int top, int[] visited, int[] puzzle, Stack<Character> stack, Set<Stack<Character>> set){
		if(top == (puzzle.length - 1)){
			set.add((Stack<Character>)stack.clone());
			return null;
		}
		//for each child of puzzle[top]
		int left = top - puzzle[top];
		int right = top + puzzle[top];
		if(left >= 0 && left < puzzle.length && visited[left] != 'X'){
			stack.push('L');
			visited[left] = 'X';
			if(findHelper(left, visited, puzzle, stack, set) != null){
				return set;
			}
			else{
				stack.pop();
				visited[left] = 0;
			}
		}
		if(right >= 0 && right < puzzle.length && visited[right] != 'X'){
			stack.push('R');
			visited[right] = 'X';
			if(findHelper(right, visited, puzzle, stack, set) != null){
				return set;
			}
			else{
				stack.pop();
				visited[right] = 0;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * Takes an int[] puzzle and finds all possible solutions and puts them in a set
	 * 
	 * Calls helper function, findHelper
	 * 
	 * @param puzzle
	 * @return Set<Stack<Character>>
	 */
	public static Set<Stack<Character>> findAllSolutions(int[] puzzle){
		Set<Stack<Character>> set = new HashSet<Stack<Character>>();
		Stack<Character> stack = new Stack<Character>();
		int[] visited = new int[puzzle.length];
		int top = 0;
		findHelper(top, visited, puzzle, stack, set); 
		return set;
	}
}
