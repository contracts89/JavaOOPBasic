package problem7;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Radoslav on 5.7.2016 г..
 */

class ImmutableList {
    private ArrayList<Integer> arrayList;

    public ImmutableList() {
            this.arrayList = new ArrayList<>();
    }

    public ImmutableList getArrayList() {
        return new ImmutableList();
    }
}

public class ImmutableListMain{
    public static void main(String[] args) {
        Class listClass = ImmutableList.class;
        Field[] fields = listClass.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }

        Method method = listClass.getDeclaredMethods()[0];
        System.out.println(method.getReturnType().getSimpleName());

    }
}
