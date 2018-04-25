/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 8.3.2018 г.
 * Time: 10:38 ч.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class _01CountWorkingDays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = reader.readLine();
        String secondInput = reader.readLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate firstDate = LocalDate.parse(firstInput, formatter);
        LocalDate secondDate = LocalDate.parse(secondInput, formatter);

        DateTimeFormatter holidayFormatter = DateTimeFormatter.ofPattern("dd-MM");

        String[] holidays = {"01-01",
                "03-03",
                "01-05",
                "06-05",
                "24-05",
                "06-09",
                "22-09",
                "01-11",
                "24-12",
                "25-12",
                "26-12"};

        int workingDays = 0;

        String currentDayMonth = firstDate.format(holidayFormatter);

        while (firstDate.compareTo(secondDate) <= 0) {
            boolean holiday = checkIfHoliday(firstDate, holidays, currentDayMonth);

            if (!holiday) {
                workingDays++;
            }

            firstDate = firstDate.plusDays(1);
            currentDayMonth = firstDate.format(holidayFormatter);
        }

        System.out.println(workingDays);
    }

    private static boolean checkIfHoliday(LocalDate localDate, String[] holidays, String currentDateMonth) {

        int dayOfWeek = localDate.getDayOfWeek().getValue();

        return dayOfWeek == 6 || dayOfWeek == 7
                || holidaysContains(holidays, currentDateMonth);
    }

    private static boolean holidaysContains(String[] holidays, String currentDateMonth) {

        for (String holiday : holidays) {
            if (holiday.equals(currentDateMonth)) {
                return true;
            }
        }
        return false;
    }
}