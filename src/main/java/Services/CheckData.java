package Services;

import Services.Exception.AgeDaysServletException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckData {

    private String name;
    private String dOB;

    public CheckData(String name, String dOB) {
        this.name = name;
        this.dOB = dOB;
    }

    public void filterDataFromBrowser() throws AgeDaysServletException {

        if (empty(name)) {
            throw new AgeDaysServletException("Prietene fii onest si prezinta-te !", "Nume vid.");
        } else {
            if (empty(dOB)) {
                throw new AgeDaysServletException("Te rog " + name + " indrodu data nasterii.", "dOB obligatoriu.");
            } else {
                if (!checkDOBValidity()) {
                    throw new AgeDaysServletException("Data nasterii nu este corecta !", "dOB incorecta.");
                }
            }
        }
    }

    public boolean empty(String s) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }

    public boolean checkDOBValidity() throws AgeDaysServletException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate birthYear = checkStringFormatToDate();
        return (birthYear.isBefore(today));
    }

    public LocalDate checkStringFormatToDate() throws AgeDaysServletException {
        try {
            return LocalDate.parse(dOB, DateTimeFormatter.ofPattern("d/MM/yyyy"));
        } catch (DateTimeParseException excep) {
        }

        throw new AgeDaysServletException("Formatul datei este invalid. Te rog " + name + " introdu o data valida de forma 3/07/1996.", "String invalid.");
    }
}
