package problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Radoslav on 7.7.2016 г..
 */
class DateModifier{
    private long difference;

    public DateModifier() {
        this.setDifference(difference);
    }

    public long getDifference() {
        return difference;
    }

    public void setDifference(long difference) {
        this.difference = difference;
    }

    public long calcDifference(String startDate, String endDate){
        String[] fD = startDate.split("\\s+");
        String[] sD = endDate.split("\\s+");
        int startYear = Integer.parseInt(fD[0]);
        int startMont = Integer.parseInt(fD[1]);
        int startDay = Integer.parseInt(fD[2]);
        int endYear = Integer.parseInt(sD[0]);
        int endMonth = Integer.parseInt(sD[1]);
        int endDay = Integer.parseInt(sD[2]);
        Calendar firstCalendar = Calendar.getInstance();
        Calendar secondCalendar = Calendar.getInstance();
        firstCalendar.set(startYear, startMont, startDay);
        secondCalendar.set(endYear, endMonth, endDay);
        Date d1 = firstCalendar.getTime();
        Date d2 = secondCalendar.getTime();
        long difference = d2.getTime() - d1.getTime();
        return Math.abs(difference/(24 * 60 * 60 * 1000));
    }
}

public class DateModifierMain {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        String startDate = line;
        line = sc.readLine();
        String endDate = line;
        DateModifier dateModifier = new DateModifier();
        System.out.println(dateModifier.calcDifference(startDate, endDate));
    }
}
