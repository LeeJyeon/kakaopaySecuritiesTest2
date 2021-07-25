import java.util.*;

public class Task2 {

    public static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("insert input");

        int row = Integer.parseInt(sc.next());
        int col = Integer.parseInt(sc.next());
        String d = sc.next();

        String[] a = d.split(",");
        int[][] m = new int[col][row];

        int seq = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                m[i][j] = Integer.parseInt(a[seq]);
                seq++;
            }
        }

        int neo = 0;
        int prodo = row - 1;

        /*print*/
        //printMethod(row, col, m);
        /*print*/

        down(0, neo, prodo, m, 0);

        System.out.println("result = " + result);

    }

    private static void printMethod(int row, int col, int[][] m) {
        System.out.println("/***************/");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("/***************/");
    }

    public static void down(int step, int neo, int prodo, int[][] m, int score) {

        if (result < score) {
            result = score;
        }

        if (step == m.length ) {
            return;
        }

        List<Integer> neoNext = new ArrayList<>();
        List<Integer> prodoNext = new ArrayList<>();

        for (int i = -1; i < 2; i++) {
            if (neo + i < m[0].length && neo + i >= 0) {
                neoNext.add(neo + i);
            }
            if (prodo + i < m[0].length && prodo + i >= 0) {
                prodoNext.add(prodo + i);
            }
        }

        for (int i = 0; i < neoNext.size(); i++) {
            for (int j = 0; j < prodoNext.size(); j++) {
                int tmp = m[step][neoNext.get(i)] + m[step][prodoNext.get(j)];
                if (neoNext.get(i) == prodoNext.get(j)) {
                    tmp = tmp/2;
                }
                down(step + 1, neoNext.get(i), prodoNext.get(j), m, score + tmp);
            }
        }
    }
}
