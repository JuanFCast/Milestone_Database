package util;

public class RBNode<E> extends BTNode<E>{
	
    private String color;
    
    //Constructor
    public RBNode(E e) {
        super(e);
        if(e != null) {
        	color = "RED";
        } else {
        	color = "BLACK";
        }
        parent = null;
        left = null;
        right = null;
    }

    public void changeColor(){
        if(getParent() != null){
            if(color.equals("RED")){
                color = "BLACK";
            } else{
                color = "RED";
            }
        } else{
            color = "BLACK";
        }
    }
    
    public int blackNodes() {
    	if(element == null) {
    		return 1;
    	} else {
    		int c = 0;
    		if(color.equals("BLACK")) {
    			c++;
    		}
    		return blackNodes(getParent()) + c;
    	}
    }
    
    private int blackNodes(RBNode<E> p) {
    	int c = 0;
    	if(p != null) {
    		if(p.getColor().equals("BLACK")) {
        		c++;
        	}
    		c += blackNodes(p.getParent());
    	}
    	return c;
    }
    
    @Override
    public boolean isLeaf() {
    	return (left.getElement() == null && right.getElement() == null);
    }
    
    //Getters & Setters
    public E getElement() {
		return element;
	}
	public RBNode<E> getParent() {
		return (RBNode<E>) parent;
	}
	public RBNode<E> getLeft() {
		return (RBNode<E>) left;
	}
	public RBNode<E> getRight() {
		return (RBNode<E>) right;
	}
	public String getColor() {
		return color;
	}
	public RBNode<E> getUncle(){
        if(getParent().getParent() != null){
            RBNode<E> g =getParent().getParent();
            if(g.getLeft().equals(getParent())){
                return g.getRight();
            } else{
                return g.getLeft();
            }
        } else{
            return null;
        }
    }

	
	public void setParent(RBNode<E> p) {
		parent = p;
	}
	public void setLeft(RBNode<E> l) {
		left = l;
	}
	public void setRight(RBNode<E> r) {
		right = r;
	}
	
}
