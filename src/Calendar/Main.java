package Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) throws ParseException {
        Date startDate = getStartDateFromUser();
        Date endDate = getStopDateFromUser();
        System.out.println("Start date: " + startDate);
        System.out.println("End date" + endDate);
        System.out.println("***");
        System.out.println("Here's the list of week days in provided period: ");
        List<Date> listResultDates = getWorkingDaysFromGivenPeriod(startDate, endDate);
        for (Date element : listResultDates) {
            System.out.println(element);
        }
    }

    private static Date getStartDateFromUser() throws ParseException {
        System.out.println("Please type START date in format DD.MM.YYYY");
        String userInput = SCANNER.nextLine().trim();
        return parseStringToDate(userInput);
    }

    private static Date getStopDateFromUser() throws ParseException {
        System.out.println("Please type STOP date in format DD.MM.YYYY");
        String userInput = SCANNER.nextLine().trim();
        return parseStringToDate(userInput);
    }

    static List<Date> getWorkingDaysFromGivenPeriod(Date startDate, Date endDate) {
        List<Date> listOfdates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        while (calendar.getTime().getTime() <= endDate.getTime()) {
            Date result = calendar.getTime();
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                    && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                listOfdates.add(result);
            }
            calendar.add(Calendar.DATE, 1);
        }
        return listOfdates;
    }

    private static Date parseStringToDate(String stringDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(stringDate);
        } catch (ParseException pe) {
            System.out.println("Something went wrong with parsing.");
        }
        return parsedDate;
    }
}
