package ro.sci.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;


public class AgeDaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String dOB = req.getParameter("dob");
        int numberOfDays = calculateDaysFromDOB(dOB);
        resp.getWriter().println("Hello - " + name + ", you lived " + numberOfDays + " days.");
    }

    public  int calculateDaysFromDOB(String dateOfBirth) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate birthYear = LocalDate.parse(dateOfBirth, formatter);
        int numberOfDays = (int) DAYS.between(birthYear, today);

        return numberOfDays;
    }


}
