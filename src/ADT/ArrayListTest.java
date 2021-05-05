package ADT;

public class ArrayListTest extends ListTest{
    @Override
    public <T> List<T> createList() {
        return new Arraylist<>();
    }
}
