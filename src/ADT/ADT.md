Abstract data types describe(ADT) the behavior(semantics) of a data type without specifying its implementation, not concrete

A container is very general ADT, serving as a holder of objects. A list is an example of a specific container ADT

semantic operation

ADT 1: list ADT
ADT is a container known mathematically as finite sequence of elements. A list has some fundamental properties:
duplicates are allowed
order is preserved
List supports function: add, isEmpty, create


Creating list interface:
public interface List<Type>{
void add (T value);
T get (int index);
int size();
remove(int index);
void reverse();
}

list implement:
Arrays -> 1) (advantage) fast look up any element; 2) (downside) A little messy to grow and contract
Linked list -> 1) Logical fit to a list; 2) need to traverse list to find the arbitrary element 