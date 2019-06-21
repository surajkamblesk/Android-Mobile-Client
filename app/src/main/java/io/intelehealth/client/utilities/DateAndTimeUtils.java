package io.intelehealth.client.utilities;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateAndTimeUtils {


    public String currentDateTime() {
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
// you can get seconds by adding  "...:ss" to it
        Date todayDate = new Date();
        return date.format(todayDate);
    }

    public static int getAge(String s) {
        if (s == null) return 0;

        String[] components = s.split("\\-");

        int year = Integer.parseInt(components[0]);
        int month = Integer.parseInt(components[1]);
        int day = Integer.parseInt(components[2]);

        LocalDate birthdate = new LocalDate(year, month, day);          //Birth date
        LocalDate now = new LocalDate();                    //Today's date
        Period period = new Period(birthdate, now, PeriodType.yearMonthDay());

        return period.getYears();
    }

    public static String SimpleDatetoLongFollowupDate(String dateString) {
        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd-MMMM-yyyy");
            Date date = originalFormat.parse(dateString);
            formattedDate = targetFormat.format(date);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return formattedDate;
    }

    public static String SimpleDatetoLongDate(String dateString) {
        String formattedDate = null;
        try {
            DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Date date = originalFormat.parse(dateString);
            formattedDate = targetFormat.format(date);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return formattedDate;
    }

    public static int getMonth(String s1) {
        if (s1 == null) return 0;

        String[] components = s1.split("\\-");

        int year = Integer.parseInt(components[0]);
        int month = Integer.parseInt(components[1]);
        int day = Integer.parseInt(components[2]);

        LocalDate birthdate1 = new LocalDate(year, month+1, day);          //Birth date
        LocalDate now = new LocalDate();                    //Today's date
        Period period = new Period(birthdate1, now, PeriodType.yearMonthDay());
        return period.getMonths();
    }

    public static String formatDateFromOnetoAnother(String date, String sourceFormat, String anotherFormat) {

        String result = "";
        SimpleDateFormat sdf;
        SimpleDateFormat sdf1;

        try {
            sdf = new SimpleDateFormat(sourceFormat);
            sdf1 = new SimpleDateFormat(anotherFormat);
            result = sdf1.format(sdf.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            sdf = null;
            sdf1 = null;
        }
        return result;
    }

}