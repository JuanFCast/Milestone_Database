package util;

public class Node<E>{

    E element;
    Node<E> up;
    Node<E> left;
    Node<E> right;

    public Node(E e, Node<E> n){
        element = e;
        up = n;
    }

    public int gethigh(){
		if(left==null && right==null) {
			return 1;
		}else {
			return max(left.gethigh(), right.gethigh());
		}
    }

    private int max(int l, int r) {
		if(l>=r) {
			return l;
		}else {
			return r;
		}
		
	}

	public int fb(){
        return right.gethigh()-left.gethigh();
    }
	
	public boolean isbalance() {
		if(fb()==1 || fb()==0 || fb()==-1) {
			return true;
		}else {
			return false;
		}
	}

    public E getElement(){
        return element;
    }

    public void setElement(E element){
        this.element = element;
    }

    public Node<E> getUp(){
        return up;
    }

    public void setUp(Node<E> up){
        this.up = up;
    }

    public Node<E> getLeft(){
        return left;
    }

    public void setLeft(Node<E> left){
        this.left = left;
    }

    public Node<E> getRight(){
        return right;
    }

    public void setRight(Node<E> right){
        this.right = right;
    }

}