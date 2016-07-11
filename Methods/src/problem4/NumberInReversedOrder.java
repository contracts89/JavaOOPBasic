package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 3.7.2016 г..
 */
class Number{
    String num;

    public Number(String num) {
        this.num = num;
    }

    public void reverseNum(){
        StringBuilder sb = new StringBuilder();
        sb.append(num).reverse();
        System.out.println(sb);
    }
}
public class NumberInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String num = sc.readLine();
        Number number = new Number(num);
        number.reverseNum();

    }
}
