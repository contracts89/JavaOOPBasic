package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radoslav on 9.7.2016 г..
 */
public class TemperatureConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] line = sc.readLine().split("\\s+");
            if (line[0].equals("End")){
                break;
            }
            int temp = Integer.parseInt(line[0]);
            switch (line[1]){
               case "Celsius":
                   System.out.printf("%.2f Fahrenheit", calFarenheit(temp));
                    break;
                case "Fahrenheit":
                    System.out.printf("%.2f Celsius", calCelsius(temp));
                    break;
            }
            System.out.println();
        }
    }

    static Double calFarenheit(Integer temp){
        return(double) temp * 9/5 + 32;
    }

    static Double calCelsius(Integer temp){
        return(double)(temp - 32) * 5/9;
    }
}
