package problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 10.7.2016 г..
 */
class MathUtil{
    public static float sumNums(float firstNum, float secondNum){
        return firstNum + secondNum;
    }

    public static float subtractNums(float firstNum, float secondNum){
        return firstNum - secondNum;
    }

    public static float multiplyNums(float firstNum, float secondNum){
        return firstNum * secondNum;
    }

    public static float divideNums(float firstNum, float secondNum){
        return firstNum / secondNum;
    }

    public static float percenageNums(float firstNum, float secondNum){
        return firstNum * (secondNum / 100);
    }
}

public class BasicMath {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String[] line = sc.readLine().split("\\s+");
            if(line[0].equals("End")){
                break;
            }
            float fistFloat = Float.parseFloat(line[1]);
            float secondFloat = Float.parseFloat(line[2]);
            switch (line[0]){
                case "Sum":
                    System.out.printf("%.2f", MathUtil.sumNums(fistFloat, secondFloat));
                    break;
                case "Multiply":
                    System.out.printf("%.2f", MathUtil.multiplyNums(fistFloat, secondFloat));
                    break;
                case "Percentage":
                    System.out.printf("%.2f", MathUtil.percenageNums(fistFloat, secondFloat));
                    break;
                case "Divide":
                    System.out.printf("%.2f", MathUtil.divideNums(fistFloat, secondFloat));
                    break;
                case "Subtract":
                    System.out.printf("%.2f", MathUtil.subtractNums(fistFloat, secondFloat));
                    break;

            }
            System.out.println();
        }
    }
}
