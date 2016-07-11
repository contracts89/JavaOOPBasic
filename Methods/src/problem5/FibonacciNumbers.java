package problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Radoslav on 3.7.2016 г..
 */

class Fibonacci {

    ArrayList<Long> fibs;

    public Fibonacci() {
        this.fibs = new ArrayList<>();
    }

    public void calcFib(long startNum){
        long n0 = 0L;
        long n1 = 1L;
        this.fibs.add(n0);
        this.fibs.add(n1);

        for (int i = 1; i < startNum; i++) {
            this.fibs.add(this.fibs.get(i) + this.fibs.get(i - 1));
        }

    }

    public List<Long> getNumbersInRange(int startPosition, int endPosition){
        List<Long> result = this.fibs.subList(startPosition, endPosition);
        return result;
    }
}

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int startNum = Integer.parseInt(sc.readLine());
        int endNum = Integer.parseInt(sc.readLine());
        StringJoiner stringJoiner = new StringJoiner(", ");
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.calcFib(endNum);
        List<Long> result = fibonacci.getNumbersInRange(startNum, endNum);
        for (Long aLong : result) {
            stringJoiner.add(aLong.toString());
        }

        System.out.println(stringJoiner);
    }
}
