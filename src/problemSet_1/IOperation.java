package problemSet_1;

public interface IOperation {
	boolean isIsomorphic(N_aryNode node1, N_aryNode node2);
	int countOfChildren(N_aryNode node);
	int getHeight(N_aryNode<Integer> node);
	void zigZagTraversal(N_aryNode<Integer> node);
}
