package problem6;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Radoslav on 4.7.2016 г..
 */
class Number {
    private int number;
    private boolean prime;

    public Number(int number) {
        this.setNumber(number);
        this.prime = true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getPrime() {
        return prime;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public boolean isPrime(int number) {

        for (int i = 2; 2 * i < number; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }

    public Number findNextPrime() {
        if (this.getNumber() == 0 || this.getNumber() == 1) {
            return new Number(this.getNumber() + 1);
        }
        for (int i = this.getNumber() + 1; i < 2 * this.getNumber(); i++) {
            boolean result = isPrime(i);
            if (result) {
                return new Number(i);
            }

        }
        return new Number(0);
    }
}

public class PrimeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(sc.readLine());
        Number number = new Number(num);
        number.setPrime(number.isPrime(num));
        Number second = number.findNextPrime();
        System.out.printf("%d, %s", second.getNumber(), number.getPrime());
        Field[] fields = Number.class.getDeclaredFields();

        List<Field> filedsDeclared = Arrays.stream(fields)
                .filter(f -> f.getName().contains("prime") || f.getName().contains("number"))
                .collect(Collectors.toList());

        List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() > 1)
                .collect(Collectors.toList());

        if (filedsDeclared.size() < 1 || constructors.size() < 1) {
            throw new ClassFormatException();
        }

    }
}
