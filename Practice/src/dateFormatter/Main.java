package dateFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        threadUnSafe();
        threadSafe();
    }

    private static void threadSafe() throws ParseException {
        LocalDate dt= LocalDate.now();
        DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dtStr=fmt.format(dt);
        System.out.println(dtStr);

        LocalDate dt2= LocalDate.parse(dtStr,fmt);
        System.out.println(dt2.toString());
    }

    private static void threadUnSafe() throws ParseException {
        Date dt=Calendar.getInstance().getTime();
        SimpleDateFormat fmt=new SimpleDateFormat("dd/MM/YYYY");
        String dtStr=fmt.format(dt);
        System.out.println(dtStr);
        Date dt2=fmt.parse(dtStr);
        System.out.println(dt2.toString());
    }
}
