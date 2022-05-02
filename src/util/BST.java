package util;

import java.util.Comparator;

import util.Interface.IBST;

public class BST <E> implements IBST<E> {

    private BTNode<E> root;
    protected Comparator<E> comparator;

    public BST(Comparator<E> c){
        comparator = c;
        root = null;
    }

    @Override
    public boolean add(E e) {
        if(root == null){
            root = new BTNode<E>(e); 
            return true;
        } else{
            BTNode<E> n = new BTNode<E>(e);
            return add(root, n);
        }
    }

    private boolean add(BTNode<E> c, BTNode<E> n){
        if(c == null){
            if(comparator.compare(n.getParent().getElement(), n.getElement()) > 0){
                n.getParent().setLeft(n);
            } else{
                n.getParent().setRight(n);
            }

            c = n;
            return true;
        } else{
            n.setParent(c);
            if(comparator.compare(c.getElement(), n.getElement()) > 0){
                return add(c.getLeft(), n);
            } else{
                return add(c.getRight(), n);
            }
        }
    }

    @Override
    public boolean remove(E e) throws Exception {
        BTNode<E> n = search(e, root);

        if(n != null){
            if(n.isLeaf()){
                if(n.getParent().getLeft().equals(n)){
                    n.getParent().setLeft(null);
                } else{
                    n.getParent().setRight(null);
                }
                return true;
            } else if(n.getLeft() != null && n.getRight() == null){
                n.getParent().setLeft(n.getLeft());
                n.getLeft().setParent(n.getParent());
                return true;
            } else if(n.getRight() != null && n.getLeft() == null){
                n.getParent().setRight(n.getRight());
                n.getRight().setParent(n.getParent());
                return true;
            } else{
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

                return true;
            }
        } else{
            throw new Exception("The Element does not exist");
        }
    }

    @Override
    public E search(E e) {
        BTNode<E> n = search(e, root);

        if(search(e, root) != null){
            return n.getElement();
        } else{
            return null;
        }
    }

    public BTNode<E> search(E e, BTNode<E> c){
    	if(c != null){
            if(comparator.compare(c.getElement(), e) == 0){
            	System.out.println("Retornar " + c.getElement());
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

    protected BTNode<E> sucessor(BTNode<E> n){
        if(n.getLeft() == null){
            return n;
        } else{
            return sucessor(n.getLeft());
        }
    }

    public Integer size(){
        return (root == null)?0:root.size();
    }

    public String inOrder(){
        return inOrder(root);
    }

    private String inOrder(BTNode<E> c){
        String s = "";
        if(c != null){
            s += inOrder(c.getLeft());
            s += c.getElement() + ", ";
            s += inOrder(c.getRight());
        }
        return s;
    }

    public String printWithRelations(){
        return printWithRelations(root);
    }

    private String printWithRelations(BTNode<E> c){
        String s = "";
        if(c != null){
            s += printWithRelations(c.getLeft());
            if(c.getParent() != null){
                s += "Parent: " + c.getParent().getElement() + "\n";
            } else{
                s += "Parent: null"  + "\n";
            }
            
            s += "Current: " + c.getElement() + "\n";
            s += printWithRelations(c.getRight());
        }
        return s;
    }
    
}
