package util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @author: Juan Camilo Ramirez Tabares 
 * */
public class RBT<E> extends BST<E>{

	private RBNode<E> root;

	//Constructor
	public RBT(Comparator<E> c) {
		super(c);
		root = null;
	}

	@Override
	public boolean add(E e){
		if(root == null){
			root = new RBNode<E>(e);
			root.changeColor();
			root.setLeft(new RBNode<E>(null));
			root.setRight(new RBNode<E>(null));
			return true;
		} else {
			RBNode<E> n = new RBNode<E>(e);
			n.setLeft(new RBNode<E>(null));
			n.setRight(new RBNode<E>(null));
			return add(n, root);
		}
	}

	private boolean add(RBNode<E> n, RBNode<E> current) {
		if(current.getElement() == null){
			if(comparator.compare(n.getParent().getElement(), n.getElement()) > 0){
				n.getParent().setLeft(n);
			} else{
				n.getParent().setRight(n);
			}
			n.setLeft(new RBNode<E>(null));
			n.setRight(new RBNode<E>(null));
			balance(n);

			return true;
		} else{
			n.setParent(current);
			if(comparator.compare(current.getElement(), n.getElement()) > 0){
				return add(n, current.getLeft());
			} else{
				return add(n, current.getRight());
			}
		}
	}
	
	@Override
    public boolean remove(E e) throws Exception {
        RBNode<E> n = (RBNode<E>) search(e, root);

        if(n != null){
            if(n.isLeaf()){
                if(n != root) {
                	if(n.getParent().getLeft().equals(n)){
                        n.getParent().setLeft(new RBNode<E>(null));
                    } else{
                        n.getParent().setRight(new RBNode<E>(null));
                    }
                } else {
                	root = null;
                }
                return true;
            } else if(n.getLeft() != null && n.getRight().getElement() == null){
                n.getParent().setLeft(n.getLeft());
                n.getLeft().setParent(n.getParent());
                if(n.getColor().equals("BLACK")) {
                	n.getLeft().changeColor();
                }
                return true;
            } else if(n.getRight() != null && n.getLeft().getElement() == null){
                n.getParent().setRight(n.getRight());
                n.getRight().setParent(n.getParent());
                if(n.getColor().equals("BLACK")) {
                	n.getLeft().changeColor();
                }
                return true;
            } else{
            	if(n == root) {
            		BTNode<E> s = sucessor(n.getRight());
                    remove(s.getElement());
                    s.setParent(n.getParent());
                    s.setLeft(n.getLeft());
                    s.setRight(n.getRight());
                    s.getRight().setParent(s);
                    s.getLeft().setParent(s);
                    root = (RBNode<E>) s;
                    root.changeColor();
            	} else {
            		BTNode<E> s = sucessor(n.getRight());
                    remove(s.getElement());
                    if(n.getParent().getLeft().equals(n)){
                        n.getParent().setLeft(s);
                    } else{
                        n.getParent().setRight(s);
                    }
                    s.setParent(n.getParent());
                    s.setLeft(n.getLeft());
                    s.setRight(n.getRight());
                    s.getRight().setParent(s);
                    s.getLeft().setParent(s);
            	}
                return true;
            }
        } else{
            throw new Exception("The Element does not exist");
        }
    }
	
	@Override
    public E search(E e) {
        BTNode<E> n = search(e, root);

        if(n != null){
            return n.getElement();
        } else{
            return null;
        }
    }

    public BTNode<E> search(E e, BTNode<E> c){
    	if(c != null && c.getElement() != null){
            if(comparator.compare(c.getElement(), e) == 0){
                return c;
            } else{
                if(comparator.compare(c.getElement(), e) > 0){
                    return search(e, c.getLeft());
                } else{
                    return search(e, c.getRight());
                }
            }
        } else{
            return null;
        }
    }
    
    public List<E> listInOrder(){
    	List<E> l = new ArrayList<>();
    	
    	if(root == null) {
    		return null;
    	} else {
    		return listInOrder(root, l);
    	}
    }
    
    public List<E> listInOrder(RBNode<E> c, List<E> l){
    	if(c != null && c.getElement() != null) {
    		List<E> lLeft = listInOrder(c.getLeft(), new ArrayList<>());
    		if(lLeft != null) {
    			l.addAll(lLeft);
    		}
    		
    		l.add(c.getElement());
    		
    		List<E> lRight = listInOrder(c.getRight(), new ArrayList<>());
    		if(lRight != null) {
    			l.addAll(lRight);
    		}
    		
    		return l;
    	} else {
    		return null;
    	}
    }
    
    
//    public List<E> searchByChar(E e){
//    	if(root != null) {
//    		List<E> l = new ArrayList<>();
//    		return searchByChar(e, root, l);
//    	} else {
//    		return null;
//    	}
//    }
//    
//    public List<E> searchByChar(E e, RBNode<E> c, List<E> l){
//    	System.out.println("root: " + root.getElement());
//    	if(c != null && c.getElement() != null){
//            if(comparator.compare(c.getElement(), e) == -2){
//            	l.add(c.getElement());
//        
//                List<E> lLeft = searchByChar(e, c.getLeft(), new ArrayList<>());
//                if(lLeft != null) {
//                	l.addAll(lLeft);	
//                }
//                List<E> lRight = searchByChar(e, c.getRight(), new ArrayList<>());
//                if(lRight != null) {
//                	l.addAll(lRight);	
//                }
//            	
//            	return l;
//            } else{
//                if(comparator.compare(c.getElement(), e) > 0){
//                    return searchByChar(e, c.getLeft(), l);
//                } else{
//                    return searchByChar(e, c.getRight(), l);
//                }
//            }
//        } else{
//            return null;
//        }	
//    }
	
	private void rotateLeft(RBNode<E> n) {
		if(!n.equals(root)) {	
			RBNode<E> p = n.getParent();

			n.setParent(n.getRight());
			n.getRight().setParent(p);
			n.setRight(n.getRight().getLeft());
			n.getRight().setLeft(new RBNode<E>(null));
			n.getRight().setParent(n);
			n.getParent().setParent(p);
			n.getParent().setLeft(n);

			if(p.getLeft().equals(n)) {
				p.setLeft(n.getParent());
			} else {
				p.setRight(n.getParent());
			}			
		} else {
			RBNode<E> left = root;
			RBNode<E> aux = n.getRight();
			
			root.setRight(aux.getLeft());
			aux.getLeft().setParent(root);
			root = aux;
			root.setParent(left.getParent());
			root.setLeft(left);
			left.setParent(aux);
		}
	}
	
	private void rotateRight(RBNode<E> n) {
		if(!n.equals(root)) {
			RBNode<E> p = n.getParent();
			
			n.setParent(n.getLeft());
			n.getLeft().setParent(p);
			n.setLeft(n.getLeft().getRight());
			n.getLeft().setRight(new RBNode<E>(null));
			n.getLeft().setParent(n);
			n.getParent().setParent(p);
			n.getParent().setRight(n);
			
			if(p.getLeft().equals(n)) {
				p.setLeft(n.getParent());
			} else {
				p.setRight(n.getParent());
			}
		} else {
			RBNode<E> right = root;
			RBNode<E> aux = n.getLeft();
			
			root.setLeft(aux.getRight());
			aux.getRight().setParent(root);
			root = aux;
			root.setParent(right.getParent());
			root.setRight(right);
			right.setParent(aux);
		}
	}

	private void balance(RBNode<E> n) {
		if(n != null) {
			if(n.getColor().equals("RED")) {
				RBNode<E> grandParent = null;
				if(n.getParent() != null) {
					grandParent = n.getParent().getParent();
				}
				
				if(grandParent != null) {
					if(n.getParent().getColor().equals("RED") && n.getUncle().getColor().equals("RED")) {
						cases(0, n);
					} else if(n.getParent().getColor().equals("RED") && n.getUncle().getColor().equals("BLACK")) {
						if(n.getParent().getParent().getLeft().equals(n.getParent())) {
							if(n.getParent().getRight().equals(n)) {
								cases(1, n);
							} else {
								cases(2, n);
							}
						} else {
							if(n.getParent().getRight().equals(n)) {
								cases(3, n);
							} else {
								cases(4, n);
							}
						}			
					}
				}
			}
			balance(n.getParent());
		}
	}
	
	private void cases(int c, RBNode<E> n) {
		switch(c) {
		case 1: //Parent RED, Uncle: BLACK, Parent Left Children and N right children.
			rotateLeft(n.getParent());
			balance(n.getLeft());
			break;
		case 2: //Parent RED, Uncle: BLACK, Parent Left Children and N left children.
			rotateRight(n.getParent().getParent());
			n.getParent().changeColor();
			n.getParent().getRight().changeColor();
			balance(n);
			break;
		case 3: //Parent RED, Uncle: BLACK, Parent right Children and N right children.
			rotateLeft(n.getParent().getParent());
			n.getParent().changeColor();
			n.getParent().getLeft().changeColor();
			balance(n);
			break;
		case 4: //Parent RED, Uncle: BLACK, Parent right Children and N left children.
			rotateRight(n.getParent());
			balance(n.getRight());
			break;
		default: //Parent RED Uncle: RED
			n.getParent().changeColor();
			n.getUncle().changeColor();
			n.getParent().getParent().changeColor();
			break;
		}
	}
	
	@Override
	protected RBNode<E> sucessor(BTNode<E> n){
        if(n.getLeft().getElement() == null){
            return (RBNode<E>) n;
        } else{
            return sucessor(n.getLeft());
        }
    }
	
	public boolean isEmpty() {
		return(root == null);
	}
	
	public RBT<E> reOrder(){
		return null;
	} 
    
    public String inOrder(){
        return inOrder(root);
    }

    private String inOrder(BTNode<E> c){
        String s = "";
        if(c.getElement() != null){
            s += inOrder(c.getLeft());
            if(c.getElement() != null) {
            	s += c.getElement() + ", ";
            }
            s += inOrder(c.getRight());
        }
        return s;
    }
}
