package ro.sci.servlet;

import Services.CalculateNumberOfDays;
import Services.CheckData;
import Services.Exception.AgeDaysServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AgeDaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String name = req.getParameter("name");
            String dOB = req.getParameter("dob");
            CheckData checkData = new CheckData(name, dOB);
            checkData.filterDataFromBrowser();
            CalculateNumberOfDays calculateNumberOfDays = new CalculateNumberOfDays(dOB);
            int numberOfDays = calculateNumberOfDays.calculateDaysFromDOB();
            resp.getWriter().println("Hello - " + name + ", you lived " + numberOfDays + " days.");
        } catch (AgeDaysServletException e) {
            resp.getWriter().println(e.getMessage());
        }
    }
}