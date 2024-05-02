package deque;

public interface Deque<Item>{
    public void addFirst(Item item);
    public void addLast(Item item);
    default public boolean isEmpty(){
        if (size() == 0) return true;
        return false;
    };
    public Item getFirst();
    public Item getLast();
    public Item removeFirst();
    public Item removeLast();
    public int size();
    public Item get(int index);
    public void printDeque();


}
