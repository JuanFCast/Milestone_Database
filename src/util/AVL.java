package util;

import java.util.Comparator;

public class AVL<E> implements ABB<E>{

    private Node<E> root;
    private Comparator<E> comparator;
    
    public AVL(Comparator<E> c){
    	comparator = c;
    }

	@Override
	public void add(Node<E> n) {
		if(root==null) {
			root = n;
		}else {
			add(n, root);
		}
	}
	
	//mayores e iguales a la derecha*
	public void add(Node<E> n, Node<E> r) {
		if(comparator.compare(n.getElement(), r.getElement())>=0) {
			if(r.getRight()==null) {
				r.setRight(n);
				n.setUp(r);
			}else {
				add(n,r.getRight());
			}
		}else {
			if(r.getLeft()==null) {
				r.setRight(n);
				n.setUp(r);
			}else {
				add(n,r.getLeft());
			}
		}
		balance(n.getUp());
	}
	
	public Node<E> search(E s) {
		if(root == null) {
			return null;
		}else {
			return search(root, s);
		}
	}

	@Override
	public Node<E> search(Node<E> r, E s) {
		if(r.getElement()==null) {
			return r;
		}else if(comparator.compare(r.getElement(), s)==0) {
			return r;
		}else if(comparator.compare(r.getElement(), s)>0) {
			return search(r.getRight(), s);
		}else {
			return search(r.getLeft(), s);
		}
	}

	@Override
	public Node<E> delete(E d) {
		Node<E> remove = search(d);
		removeNode(remove);
		
		balance(remove.getUp());
		return remove;
	}
	
	private void removeNode(Node<E> d) {
		if(d!=null) {	
			if(isleaf(d)) {
				if(d==root) {
					root=null;
				}else if(d==d.getUp().getLeft()) {
					d.getUp().setLeft(null);
				}else {
					d.getUp().setRight(null);
				}
			}else if(d.getLeft()==null || d.getRight()==null) {
				Node<E> aux;
				if(d.getLeft()!=null) {
					aux=d.getLeft();
				}else {
					aux=d.getRight();
				}
				aux.setUp(d.getUp());
				if(d==root) {
					root=aux;
				}else if(d==d.getUp().getLeft()) {
					d.getUp().setLeft(aux);
				}else {
					d.getUp().setRight(aux);
				}
			}else {
				Node<E> succesor = min(d.getRight());
				d.setElement(succesor.getElement());
				removeNode(succesor);
			}
		}
	}
	
	private void balance(Node<E> n) {
		do {
			if(n.getUp()!=null) {
				if(n.getUp().fb()==2) {
					if(n.fb()==1 || n.fb()==0) {
						rotateLeft(n.getUp());
					}else if(n.fb()==-1){
						rotateRight(n);
						rotateLeft(n.getUp());
					}
				}else if(n.getUp().fb()==-2) {
					if(n.fb()==-1 || n.fb()==0) {
						rotateRight(n.getUp());
					}else if(n.fb()==1) {
						rotateLeft(n);
						rotateRight(n.getUp());
					}
				}
			}
			n=n.getUp();
		}while(n!=null);
	}
	
	private void rotateLeft(Node<E> n) {
		Node<E> aux = n.getRight();
		n.setRight(aux.getLeft());
		n.getRight().setUp(n);
		aux.setLeft(n);
		if(n==n.getUp().getRight()) {
			n.getUp().setRight(aux);
		}else {
			n.getUp().setLeft(aux);
		}
		aux.setUp(n.getUp());
		n.setUp(aux);
	}
	
	private void rotateRight(Node<E> n) {
		Node<E> aux = n.getLeft();
		n.setLeft(aux.getRight());
		n.getLeft().setUp(n);
		aux.setRight(n);
		if(n==n.getUp().getRight()) {
			n.getUp().setRight(aux);
		}else {
			n.getUp().setLeft(aux);
		}
		aux.setUp(n.getUp());
		n.setUp(aux);
	}
	
	private boolean isleaf(Node<E> l) {
		if(l.getLeft()==null && l.getRight()==null) {
			return true;
		}else {
			return false;
		}
	}
	
	@SuppressWarnings("unused") //este metodo no se usa
	private Node<E> max(Node<E> r){
		if(r.getRight()==null) {
			return r;	
		}else {
			return max(r.getRight());
		}
	}
	
	private Node<E> min(Node<E> r){
		if(r.getLeft()==null) {
			return r;
		}else {
			return min(r.getLeft());
		}
	}
	
	public Node<E> getRoot(){
        return root;
    }
	
}