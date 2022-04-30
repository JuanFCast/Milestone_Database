package util;

public interface ABB<E> {

    public void add(Node<E> n);

    public Node<E> search(Node<E> r, E s);

    public Node<E> delete(E d);

}