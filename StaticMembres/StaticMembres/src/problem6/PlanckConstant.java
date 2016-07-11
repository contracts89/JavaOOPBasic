package problem6;

/**
 * Created by Radoslav on 10.7.2016 г..
 */
class Calculation{
    private static double planck = 6.62606896e-34;
    private static double pi = 3.14159;

    public static double caclPlank(){
        return planck / (2 * pi);
    }
}

public class PlanckConstant {
    public static void main(String[] args) {
        System.out.println(Calculation.caclPlank());
    }
}
