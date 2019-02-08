package Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalculateNumberOfDays {

    private String dateOfBirth;

    public CalculateNumberOfDays(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int calculateDaysFromDOB() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate birthYear = LocalDate.parse(dateOfBirth, formatter);
        int numberOfDays = (int) DAYS.between(birthYear, today);

        return numberOfDays;
    }
}
