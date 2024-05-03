package deque;

/*my variants
*circular version of the DoublyLinkedList
* */


import java.util.Iterator;


public class LinkedListDeque<Item> implements Deque<Item>, Iterable<Item>{
    private  class Node{
        public Item item;
        public Node next;

        public Node prev;

        public Node(Item x, Node next,Node prev){
            this.item = x;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;


    private Node sentinel;


    public LinkedListDeque(){
        size = 0;
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(Item item) {
        sentinel = new Node(null, null , null);
        sentinel.prev = sentinel.next = new Node(item, sentinel, sentinel);
        size = 1;
    }

    public int size(){
        return size;
    }

    public void addFirst(Item item){
        sentinel.next.prev = new Node(item, sentinel.next,sentinel);
        sentinel.next = sentinel.next.prev;
        size = size + 1;
    }


    public Item getFirst(){
        return sentinel.next.item;
    }


    public Item removeFirst(){
        if (isEmpty()){
            return null;
        }

        Item item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size = size - 1;
        return item;
    }



    public void addLast(Item item){
        sentinel.prev.next = new Node(item, sentinel,sentinel.prev);
        sentinel.prev = sentinel.prev.next;
        size = size + 1;
    }


    public Item getLast(){
        return sentinel.prev.item;
    }



    public Item removeLast(){
        if(isEmpty()){
            return null;
        }
        Item item = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return item;
    }


    public Item get(int index){
        //fix it
        if (isEmpty()) return null;
        int counter = 0;
        Node pointer = sentinel.next;
        while (index > counter && counter < size()){
            pointer = pointer.next;
            counter++;
        }
        return pointer.item;
    }

    public Item getRecursive(int index){
        if(isEmpty()) return null;
        Node pointer = sentinel.next;
        return getRecursiveHelper(index,  0, pointer);
    }

    private Item getRecursiveHelper(int index, int counter, Node pointer){
        // base case when I reach the index that I actually want
        if(index == counter){
            return pointer.item;
        }else{
            pointer = pointer.next;
            return getRecursiveHelper(index, ++counter ,pointer);
        }
    }


    public void printDeque(){
        Node pointer = sentinel.next;
        while (pointer != sentinel){
            System.out.print(pointer.item + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public Iterator<Item> iterator(){
        return new LLDequeIterator();
    }
    private class LLDequeIterator implements Iterator<Item>{

        private int index;
        public LLDequeIterator(){
            index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < size;
        }
        @Override
        public Item next() {
            Item item = get(index);
            index++;
            return item;
        }

    }

    @Override
    public boolean equals(Object o){
            int index = 0;
            if(this == o){
                return true;
            }

            if(o instanceof LinkedListDeque deque){
                if(this.size != deque.size){
                    return false;
                }
                for(Item x : this){
                    Item y = (Item) deque.get(index);
                    if(x != y){
                        return false;
                    }
                    index += 1;
                }
                return true;
            }

        return false;
        }





    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(10);
        System.out.println(list.getRecursive(2));

    }
}

