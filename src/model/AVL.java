package model;

public class AVL<E> implements ABB<E>{

    private Node<E> root;
    
    public AVL(){
    	
    }

	@Override
	public void add(Node<E> n) {
		if(root==null) {
			root = n;
		}else {
			add(n, root);
		}
	}
	
	public void add(Node<E> n, Node<E> r) {
		
	}

	@Override
	public E search(Node<E> s) {
		
		return null;
	}

	@Override
	public E delete(Node<E> d) {
		
		return null;
	}
	
	public Node<E> getRoot(){
        return root;
    }
	
}