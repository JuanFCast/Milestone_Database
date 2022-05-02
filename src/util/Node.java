package util;

public class Node<E>{

    E element;
    Node<E> up;
    Node<E> left;
    Node<E> right;

    public Node(E e){
        element = e;
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