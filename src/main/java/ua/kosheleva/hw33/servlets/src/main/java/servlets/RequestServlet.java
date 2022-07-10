package servlets;

import model.Information;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RequestServlet", value = "/RequestServlet")
public class RequestServlet extends HttpServlet {
    private final List<Information> informationList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter doGet");
        resp.setContentType("text/html");
        LocalTime localTime = LocalTime.now();
        Information information = new Information(req.getRemoteAddr(), req.getHeader("USER-AGENT"), localTime);
        informationList.add(information);
        req.setAttribute("informationList", informationList);
        req.getRequestDispatcher("/information.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
