package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    @Test
    public void maxWithoutComparator(){
        MaxArrayDeque<Integer> m1 = new MaxArrayDeque<>(new intComp());
        for(int i = 0; i < 5; i++){
            m1.addLast(i);
        }
        assertEquals((Integer)4,m1.max());
    }


    @Test
    public void maxWithComparator(){
        MaxArrayDeque<String> m1 = new MaxArrayDeque<>(new StringLengthComparator());
        m1.addLast("abdelrahman");
        m1.addLast("body");

        assertEquals("abdelrahman",m1.max(new StringLengthComparator()));
    }
    private static class intComp implements Comparator<Integer>{
        @Override
        public int compare(Integer int1,Integer int2){
            return int1 - int2;
        }
    }

    private static class StringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }


}
