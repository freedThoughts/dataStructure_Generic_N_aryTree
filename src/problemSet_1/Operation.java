package problemSet_1;

import java.util.Stack;

public class Operation<T> implements IOperation{
	
	public N_aryNode createNaryTree(){
		
		N_aryNode<Integer> node10 = new N_aryNode<Integer>(100, null, null);
		N_aryNode<Integer> node9 = new N_aryNode<Integer>(90, null, null);
		N_aryNode<Integer> node8 = new N_aryNode<Integer>(80, node10, node9);
		N_aryNode<Integer> node7 = new N_aryNode<Integer>(70, null, null);
		N_aryNode<Integer> node6 = new N_aryNode<Integer>(60, null, node7);
		N_aryNode<Integer> node5 = new N_aryNode<Integer>(50, null, node6);
		N_aryNode<Integer> node4 = new N_aryNode<Integer>(40, null, null);
		N_aryNode<Integer> node3 = new N_aryNode<Integer>(30, node8, node4);
		N_aryNode<Integer> node2 = new N_aryNode<Integer>(20, node5, node3);
		N_aryNode<Integer> node1 = new N_aryNode<Integer>(10, node2, null);
		return node1;
	}
	
	public N_aryNode createNaryTree2(){
		
		N_aryNode<Integer> node10 = new N_aryNode<Integer>(100, null, null);
		N_aryNode<Integer> node9 = new N_aryNode<Integer>(90, null, null);
		N_aryNode<Integer> node8 = new N_aryNode<Integer>(80, node10, node9);
		N_aryNode<Integer> node7 = new N_aryNode<Integer>(70, null, null);
		N_aryNode<Integer> node6 = new N_aryNode<Integer>(60, null, node7);
		N_aryNode<Integer> node5 = new N_aryNode<Integer>(50, null, node6);
		N_aryNode<Integer> node4 = new N_aryNode<Integer>(40, null, null);
		N_aryNode<Integer> node3 = new N_aryNode<Integer>(30, node8, node4);
		N_aryNode<Integer> node2 = new N_aryNode<Integer>(20, node5, node3);
		N_aryNode<Integer> node1 = new N_aryNode<Integer>(10, node2, null);
		return node1;
	}

	@Override
	public boolean isIsomorphic(N_aryNode node1, N_aryNode node2){
		if(node1 == null && node2 == null)
			return true;
		if((node1 != null && node2 == null) ||
				(node1 == null && node2 != null))
			return false;
		
		return isIsomorphic(node1.firstChild, node2.firstChild) && 
				isIsomorphic(node1.nextSibling, node2.nextSibling);
	}

	@Override
	public int countOfChildren(N_aryNode node){
		if(node == null || node.firstChild == null ) 
			return 0;
		
		int count = 1; // for first Child
		return countOfChildren(node.firstChild.nextSibling, count);
	}
	
	private int countOfChildren(N_aryNode node, int count){
		if(node == null)
			return count;
		count++;
		return countOfChildren(node.getNextSibling(), count);
	}

	@Override
	public int getHeight(N_aryNode<Integer> node) {
		if (node == null)
			return 0;
		return Math.max(1 + getHeight(node.firstChild), getHeight(node.nextSibling));
	}

	// Time complexity = O(2*n) ~~ O(n)  -- Once at the time of inserting in stack and once at time of retrieval from stack
	// Space Complexity = O(2n), when not considering jvn inner stack for method - pushChildrenInReverseSequence
	@Override
	public void zigZagTraversal(N_aryNode<Integer> node) {
		Stack<N_aryNode<Integer>> firstToLastChild = new Stack<>();
		Stack<N_aryNode<Integer>> lastToFirstChild = new Stack<>();
		lastToFirstChild.push(node);
		while (!firstToLastChild.isEmpty() || !lastToFirstChild.isEmpty()) {
			while (!lastToFirstChild.isEmpty()) {
				N_aryNode<Integer> currentNode = lastToFirstChild.pop();
				System.out.print(currentNode.data + " ");
				N_aryNode<Integer> firstChild = currentNode.firstChild;
				if (firstChild == null) continue;
				// Push first child and then, nextChildren are added in sequence
				firstToLastChild.push(firstChild);
				N_aryNode<Integer> nextSibling = firstChild.nextSibling;
				while (nextSibling != null) {
					firstToLastChild.push(nextSibling);
					nextSibling = nextSibling.nextSibling;
				}
			}

			while (!firstToLastChild.isEmpty()) {
				N_aryNode<Integer> currentNode = firstToLastChild.pop();
				System.out.print(currentNode.data + " ");
				N_aryNode<Integer> firstChild = currentNode.firstChild;
				if (firstChild == null) continue;
				// nextChildren are added in reverse sequence and then, first child is added
				pushChildrenInReverseSequence(lastToFirstChild, firstChild.nextSibling);
				lastToFirstChild.push(firstChild);
			}
		}
 	}

 	private void pushChildrenInReverseSequence(Stack<N_aryNode<Integer>> stack, N_aryNode<Integer> nextChild) {
		if (nextChild.nextSibling != null)
			pushChildrenInReverseSequence(stack, nextChild.nextSibling);
		stack.push(nextChild);
	}

	public static void main(String[] args) {
		Operation object = new Operation();
		N_aryNode root1 = object.createNaryTree();
		N_aryNode root2 = object.createNaryTree2();
		object.zigZagTraversal(root1);
		//System.out.println(object.countOfChildren(root1));
	}

}
