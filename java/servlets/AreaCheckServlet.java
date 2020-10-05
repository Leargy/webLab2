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
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {

    private void sendAnswer(Entry entry, HttpServletResponse response) throws IOException {

        String result = entry.getIsHit()?"The point has hit the field!":"The point hasn't hit the field!";
        String answer = "<html>\n" +
                "<head>\n" +
                "    <title>Answer</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"answer.css\">\n" +
                "</head>\n" +
                "    <body>\n" +
                "        <table class=\"table\">\n" +
                "            <th id=\"header-text\" colspan=\"3\" nowrap>\n" +
                "                Сушкевич Антон Дмитриевич, P3214, вариант 2530\n" +
                "            </th>\n" +
                "            <tr>\n" +
                "                <td id=\"message\" colspan=\"3\">\n" +
                                result +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td class=\"resultCells\" >\n" +
                                entry.getX() +
                "                </td>\n" +
                "                <td class=\"resultCells\" >\n" +
                                entry.getY() +
                "                </td>\n" +
                "                <td class=\"resultCells\" >\n" +
                                entry.getR() +
                "                </td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td id=\"buttonCell\"colspan=\"3\">\n" +
                "                    <form>\n" +
                "                    <button class=\"button\" type=\"submit\"></button>\n" +
                "                    </form>\n" +
                "                </td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </body>\n" +
                "</html>";
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(answer);
        out.close();
    }
    
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

        sendAnswer(entry, resp);

//        getServletContext().getRequestDispatcher("/answer_page.jsp").forward(req, resp);
    }

}
