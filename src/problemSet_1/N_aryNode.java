package problemSet_1;

public class N_aryNode<T> {
	T data;
	N_aryNode<T> firstChild;
	N_aryNode<T> nextSibling;
	
	public N_aryNode(){};
	
	public N_aryNode(T data, N_aryNode<T> firstChild, N_aryNode<T> nextSibling) {
		this.data = data;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * @return the firstChild
	 */
	public N_aryNode<T> getFirstChild() {
		return firstChild;
	}
	/**
	 * @param firstChild the firstChild to set
	 */
	public void setFirstChild(N_aryNode<T> firstChild) {
		this.firstChild = firstChild;
	}
	/**
	 * @return the nextSibling
	 */
	public N_aryNode<T> getNextSibling() {
		return nextSibling;
	}
	/**
	 * @param nextSibling the nextSibling to set
	 */
	public void setNextSibling(N_aryNode<T> nextSibling) {
		this.nextSibling = nextSibling;
	}
	

}
