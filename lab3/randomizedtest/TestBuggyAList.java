package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing L = new AListNoResizing();
        BuggyAList L2 = new BuggyAList();
        for(int i = 4; i < 7;i++){
            L.addLast(i);
            L2.addLast(i);
        }

        assertEquals(L.size(), L2.size());

        for(int i = 0;i < 3;i++){
            assertEquals(L.removeLast(), L2.removeLast());
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Buggy = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Buggy.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int buggySize = Buggy.size();

                assertEquals(size,buggySize);
                
                System.out.println("size: " + size);
                System.out.println("BuggySize: " + buggySize);
            } else if (operationNumber == 2  ) {
                if(L.size() == 0){
                    continue;
                }
                System.out.println("getLast: " + L.getLast());
                System.out.println("BuggyGetLast: " + Buggy.getLast());
                assertEquals(L.getLast(),Buggy.getLast());


            } else if (operationNumber == 3) {
                if(L.size() == 0){
                    continue;
                }
                System.out.println("RemoveLast: " + L.removeLast());
                System.out.println("BuggyRemoveLast: " + Buggy.removeLast());

            }
        }
    }

    public static void main(String[] args) {

    }


}
