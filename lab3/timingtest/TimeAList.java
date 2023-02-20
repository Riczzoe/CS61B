package timingtest;
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

    /*
           N     time (s)        # ops  microsec/op
------------------------------------------------------------
        1000         0.00         1000         1.00
        2000         0.00         2000         2.00
        4000         0.01         4000         2.25
        8000         0.03         8000         4.25
       16000         0.07        16000         4.19
       32000         0.39        32000        12.06
       64000         0.90        64000        14.11
      128000         3.05       128000        23.83


           N     time (s)        # ops  microsec/op
------------------------------------------------------------
        1000         0.00         1000         2.00
        2000         0.00         2000         1.50
        4000         0.01         4000         2.75
        8000         0.04         8000         4.63
       16000         0.10        16000         6.50
       32000         0.22        32000         6.91
       64000         0.94        64000        14.67
      128000         3.14       128000        24.49
     */
    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int i = 10000; i <= 1280000; i *= 2) {
            Ns.addLast(i);
            opCounts.addLast(i);

            Stopwatch sw = new Stopwatch();
            AList<Integer> aList = new AList<>();
            for (int j = 0; j < i; j++) {
                aList.addLast(j);
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(Ns, times, opCounts);

    }
}
