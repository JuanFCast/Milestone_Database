package util.Interface;

public interface IBST <E> {
    public boolean add(E e);
    public boolean remove(E e) throws Exception;
    public E search(E e);
}
