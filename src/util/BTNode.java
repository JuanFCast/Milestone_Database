package util;

public class BTNode <E>{

    protected E element;
    protected BTNode <E> parent;
    protected BTNode <E> left;
    protected BTNode <E> right;

    public BTNode(E e){
        element = e;
        parent = null;
        left = null;
        right = null;
    }

    public int size(){
        if(isLeaf() == true){
            return 1;
        } else{
            if(left != null && right == null){
                return left.size() + 1;
            } else if(left == null && right != null){
                return right.size() + 1;
            } else{
                return Math.max(left.size(), right.size()) + 1;
            }
        }
    }

    public boolean isLeaf(){
        return (left == null && right == null);
    }

    //Getters & Setters
    public E getElement(){
        return element;
    }
    public BTNode <E> getParent(){
        return parent;
    }
    public BTNode <E> getLeft(){
        return left;
    }
    public BTNode <E> getRight(){
        return right;
    }
    public void setParent(BTNode <E> p){
        parent = p;
    }
    public void setLeft(BTNode <E> l){
        left = l;
    }
    public void setRight(BTNode <E> r){
        right = r;
    }
}
