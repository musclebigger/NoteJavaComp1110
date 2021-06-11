package Tree;

import Hashapplication.Set;

import java.util.ArrayList;
import java.util.List;

public class set<T extends Object & Comparable<? super T>> implements Set<T> {//witches grammar
    class tree{//node of the tree
        T value;
        tree left, right;

        tree(T value){
            this.value = value;
        }

        boolean add(T element){
            int comparson = value.compareTo(element);

            if (comparson<0){
                //left sub-tree
                if(left==null){
                    left = new tree(element);
                    numElements++;
                    return true;
                }else {
                    left.add(element);
                }
            }else if(comparson==0){
                //current node
                return false;
            }else if (comparson>0){
                //right sub-tree
                if(right==null){
                    right = new tree(element);
                    numElements++;
                    return true;
                }else {
                    right.add(element);
                }
            }
            return false;
        }

        void addElement(List<T> elements){
            if(left != null){
                elements.add(value);
            }
            if(right != null){
                elements.add(value);
            }
            elements.add(value);
        }
    }

    private tree root;
    private int numElements;


    @Override
    public boolean add(T element) {
        if (root == null){
            root = new tree(element);
            numElements++;
            return true;
        }else {
            return root.add(element);
        }
    }

    @Override
    public boolean remove(T element) {
        numElements--;
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public Object[] toArray() {
        List<T> elements = new ArrayList<>();
        if (root!=null){
            root.addElement(elements);
        }

        return elements.toArray();
    }

}
