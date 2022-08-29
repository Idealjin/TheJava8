package java8to11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateAndTime {
    public static void main(String[] args) {
        //기존에 사용하던 Date 유형들
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        //-> 불편햇다 불편한점은 https://codeblog.jonskeet.uk/2017/04/23/all-about-java-util-date/ 여기
        Calendar sangjinBirthDat = new GregorianCalendar(1990, Calendar.OCTOBER, 22);
        // -> 10월은 숫자로 9로 표현 (0부터 1월이기떄문에)

        Long time = date.getTime();
        //-> 기계용 시간
        System.out.println(time);

    }}
