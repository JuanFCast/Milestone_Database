package model;

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
		return 0;
    }

    public int fb(){
        return left.gethigh()-right.gethigh();
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