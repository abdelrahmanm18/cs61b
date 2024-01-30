package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = 10000;
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList L = new AList();
        SLList list = new SLList();
        AList times = new AList();
        L.addLast(1000);
        L.addLast(2000);
        L.addLast(4000);
        L.addLast(8000);
        L.addLast(16000);
        L.addLast(32000);
        L.addLast(64000);
        L.addLast(128000);
        int size = L.size();
        int m = 10000;
        for(int i=0;i < size;i++){
            int n = (int) L.get(i);
            for(int j = 0; j < n; j++){
                list.addLast(j);
            }
            Stopwatch w = new Stopwatch();
            for(int k = 0; k < m;k++){
                list.getLast();
            }
            double timeInSeconds = w.elapsedTime();
            list = new SLList<>();
            times.addLast(timeInSeconds);

        }
        printTimingTable(L, times);

    }

}
