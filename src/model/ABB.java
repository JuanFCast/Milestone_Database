package model;

public interface ABB<E> {

    public void add(Node<E> n);

    public E search(Node<E> s);

    public E delete(Node<E> d);

}