package ADT;

public interface List <T>{
    void add(T value);
    T get(int index);
    int size();
    T remove(int index);
    void reverse();
}

