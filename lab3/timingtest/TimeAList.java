package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE

        AList l = new AList<Integer>();
        AList list = new AList<Integer>();
        l.addLast(1000);
        l.addLast(2000);
        l.addLast(4000);
        l.addLast(8000);
        l.addLast(16000);
        l.addLast(32000);
        l.addLast(64000);
        l.addLast(128000);
        l.addLast(500000);
        l.addLast(1000000);
        int n = l.size();
        AList timings = new AList<Integer>();

        for(int i = 0; i < n; i++) {
            int counter = (int) l.get(i);
            Stopwatch w = new Stopwatch();
            for(int j=0;j< counter;j+=1){
                list.addLast(j);
            }
            double timeInSeconds = w.elapsedTime();
            list = new AList<>();
            timings.addLast(timeInSeconds);
        }
            printTimingTable(l, timings,l);

    }
}
