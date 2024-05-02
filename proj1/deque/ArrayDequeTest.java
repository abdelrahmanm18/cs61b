package deque;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArrayDequeTest {

    @Test
    public void SizeTest(){
        ArrayDeque<Integer> list = new ArrayDeque<>();
        assertTrue("a newly initialized ArrayDeque should be empty", list.isEmpty());

        list.addLast(10);
        assertEquals(1, list.size());


        list.addLast(20);
        assertEquals(2,list.size());
    }

    @Test
    public void addRemoveTest(){
        ArrayDeque<String> list = new ArrayDeque<>();
        assertTrue("list should be empty upon initialization", list.isEmpty());

        list.addLast("first item");
        assertFalse("list should contain 1 item ", list.isEmpty());

        list.removeLast();
        assertTrue("list should be empty", list.isEmpty());

    }

    @Test
    public void circularAddLastTest(){
        ArrayDeque<String> list = new ArrayDeque<>();
        list.addLast("c");
        list.addLast("A");
        list.addLast("m");
        list.addLast("k");
        list.addLast("z");
        list.addLast("m");

        String errorMsg = "Bad result returned when removing first element. \n";
        errorMsg += "list removeFirst() returned "  + list.removeFirst() + "\n";
        errorMsg += "but the actual value is " + list.getFirst() + "\n";
        assertEquals(errorMsg, list.getFirst(), list.removeFirst());
    }

    @Test
    public void circularAddFirstTest(){
        ArrayDeque<String> list = new ArrayDeque<>();
        list.addFirst("c");
        list.addFirst("A");
        list.addFirst("m");
        list.addFirst("k");
        list.addFirst("z");
        list.addFirst("m");

        String errorMsg = "Bad result returned when removing last element. \n";
        errorMsg += "list removeLast() returned "  + list.removeLast() + "\n";
        errorMsg += "but the actual value is " + list.getLast() + "\n";
        assertEquals(errorMsg, list.getLast(), list.removeLast());
    }

    /** adding a lot of elements to check if the resizing up working correctly */
    @Test
    public void resizingUpTest() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        assertEquals("the deque size should be 100",100,list.size());
    }

    /** checking if the order of elements is correct after resizing up*/
    @Test
    public void resizingUpTest2(){
        ArrayDeque<String> list = new ArrayDeque<>();
        //crocodile - zebra - husky - chicken - monkey - lion - cat - dog - fish - tiger - lion
        list.addFirst("cat");
        list.addLast("dog");
        list.addFirst("lion");
        list.addLast("fish");
        list.addFirst("monkey");
        list.addFirst("chicken");
        list.addFirst("husky");
        list.addFirst("zebra");
        list.addFirst("crocodile");
        list.addLast("tiger");
        list.addLast("lion");
        String[] array = {"crocodile", "zebra", "husky" , "chicken" , "monkey" ,"lion" , "cat" , "dog" , "fish" , "tiger" ,"lion"};
        for(int i = 0; i < list.size();i++){
            assertEquals("should have the same value", list.removeFirst(), array[i]);
        }
    }

    /** checking if the order of elements is correct after resizing up*/
    @Test
    public void resizingUpTest3(){
        ArrayDeque<String> list = new ArrayDeque<>();
        //crocodile - zebra - husky - chicken - monkey - lion - cat - dog - fish - tiger - lion
        list.addFirst("cat");
        list.addLast("dog");
        list.addFirst("lion");
        list.addLast("fish");
        list.addFirst("monkey");
        list.addFirst("chicken");
        list.addFirst("husky");
        list.addFirst("zebra");
        list.addFirst("crocodile");
        list.addLast("tiger");
        list.addLast("lion");
        String[] array = {"crocodile", "zebra", "husky" , "chicken" , "monkey" ,"lion" , "cat" , "dog" , "fish" , "tiger" ,"lion"};
        for(int i = list.size() - 1; i >= 0;i--){
            assertEquals("should have the same value", list.removeLast(), array[i]);
        }
    }

    /** Add large number of elements to deque ; check if order and Resizing down is working correctly. */
    @Test
    public void resizingUpTestAndResizingDownTest(){

    ArrayDeque<Integer> lld1 = new ArrayDeque<>();

    for (int i = 0; i < 1000000; i++) {
        lld1.addLast(i);
    }

    for (double i = 0; i < 500000; i++) {
        assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
    }

    for (double i = 999999; i > 500000; i--) {
        assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
    }

    }

    /** check if null is returned when removing from empty list*/
    @Test
    public void emptyNullReturnTest(){
        ArrayDeque<String> lld1 = new ArrayDeque<>();
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }

    /** Check if you can create ArrayDeque with different parameterized types */
    @Test
    public void multiParamTest(){

        ArrayDeque<String>  lld1 = new ArrayDeque<>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }


    /** Check if I can iterate with enhanced for loop over the Deque*/
    @Test
    public void iteratingTest(){
        int index = 0;

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for(int i = 0; i < 10;i++){
            lld1.addLast(i);
        }

        for(int x: lld1){
            int y = lld1.get(index);
            assertEquals("Should iterate over every element in the deque in sequence ", x, y);
            index++;
        }
    }


    /** Check if equals method works correctly */
    @Test
    public void equalsTest(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();

        for(int i = 0; i < 10;i++){
            lld1.addLast(i);
        }

        for(int i = 0; i < 10;i++){
            lld2.addLast(i);
        }

        assertTrue("Should return true because the two lists have the same elements", lld1.equals(lld2));

    }

    /** Check if equals method works correctly */
    @Test
    public void equalsTest2(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();

        for(int i = 0; i < 9;i++){
            lld1.addLast(i);
        }

        for(int i = 0; i < 10;i++){
            lld2.addLast(i);
        }

        assertFalse("Should return false because the two lists have different size ", lld1.equals(lld2));
    }

    /** Check if equals method works correctly */
    @Test
    public void equalsTest3(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();

        for(int i = 10; i < 20;i++){
            lld1.addLast(i);
        }

        for(int i = 0; i < 10;i++){
            lld2.addLast(i);
        }

        assertFalse("Should return false because the two lists have different elements ", lld1.equals(lld2));
    }

    /** Check if equals method works correctly */
    @Test
    public void equalsTest4(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        ArrayDeque<Integer> lld2 = lld1;

        for(int i = 0; i < 10;i++){
            lld1.addLast(i);
        }

        assertTrue("Should return true because the two lists are the same ", lld1.equals(lld2));
    }
}
