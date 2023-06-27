package randomizedtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;
import timingtest.SLList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {

        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList<>();

        for (int i = 0; i <= 2; i++) {
            a.addLast(i);
            b.addLast(i);
        }

        for (int i = 0; i <= 2; i++) {
            assertEquals(a.removeLast(), b.removeLast());
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {

                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);

            } else if (operationNumber == 1) {
                int a = correct.size();
                int b = broken.size();
                assertEquals(a,b);

            } else if(correct.size()> 0) {

                if(operationNumber==2){
                    int a = correct.getLast();
                    int b = broken.getLast();
                    assertEquals(a,b);

                } else if (operationNumber==3){
                    int a = correct.removeLast();
                    int b = broken.removeLast();
                    assertEquals(a,b);
                }
              }
            }
        }


}
