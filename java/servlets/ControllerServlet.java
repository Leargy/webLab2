package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ControllerServlet extends HttpServlet {
    public ControllerServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/main_page.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double.parseDouble(req.getParameter("X"));
            Double.parseDouble(req.getParameter("Y"));
            Double.parseDouble(req.getParameter("R"));
            getServletContext().getRequestDispatcher("/areacheck").forward(req, resp);
        }catch (NumberFormatException ex) {
            getServletContext().getRequestDispatcher("/main_page.jsp").forward(req, resp);
        }catch (Exception ex) {
            resp.getWriter().write(ex.getMessage());
            resp.getWriter().close();
        }
    }
}
