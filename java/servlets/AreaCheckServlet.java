package servlets;

import filters.Check;
import session.Entry;
import session.EntryList;
import session.TimeContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AreaCheckServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TimeContainer currentTimeContainer = new TimeContainer();
        currentTimeContainer.start();

        Double x = Double.parseDouble(req.getParameter("X"));
        Double y = Double.parseDouble(req.getParameter("Y"));
        Double r = Double.parseDouble(req.getParameter("R"));

        HttpSession session = req.getSession();
        EntryList entryList = (EntryList) session.getAttribute("entryList");
        if (entryList == null) {
            entryList = new EntryList();
        }
        Entry entry = new Entry(x, y, r);

        Check.isHit(entry); //this filter sets field "ishit" in following value

        currentTimeContainer.stop();
        entry.setTimeContainer(currentTimeContainer);

        entryList.setElement(entry);
        session.setAttribute("entryList", entryList);

        getServletContext().getRequestDispatcher("/answer_page.jsp").forward(req, resp);
    }

}
