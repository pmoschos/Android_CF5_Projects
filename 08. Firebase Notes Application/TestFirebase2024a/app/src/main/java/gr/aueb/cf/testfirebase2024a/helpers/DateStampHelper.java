package gr.aueb.cf.testfirebase2024a.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateStampHelper {
    public static String getDateStamp() {
        //getting current time in millis
        long currentTime = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTime);
        String showTime = String.format("%1$tI:%1$tM:%1$tS%1$Tp", calendar);

        ///current  date
        Date now = new Date();
        long timestamp = now.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        String dateString = simpleDateFormat.format(timestamp);

        // final format
        return showTime + dateString;
    }
}
