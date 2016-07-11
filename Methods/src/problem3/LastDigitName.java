package problem3;

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

    public void lastDigit(){
        int index = this.num.length() - 1;
        char c = this.num.charAt(index);
        String result = "";
        switch (c){
            case '0':
                result = "zero";
                break;
            case '1':
                result = "one";
                break;
            case '2':
                result = "two";
                break;
            case '3':
                result = "three";
                break;
            case '4':
                result = "four";
                break;
            case '5':
                result = "five";
                break;
            case '6':
                result = "six";
                break;
            case '7':
                result = "seven";
                break;
            case '8':
                result = "nine";
                break;
            case '9':
                result = "nine";
                break;
        }

        System.out.println(result);
    }
}

public class LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        Number number = new Number(line);
        number.lastDigit();
    }
}
