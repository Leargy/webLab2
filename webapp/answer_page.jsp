<%@ page import="java.util.ArrayList" %>
<%@ page import="session.Entry" %>
<%@ page import="session.EntryList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Answer</title>
    <link rel="stylesheet" type="text/css" href="answer.css">
</head>
    <body>
    <%
        ArrayList<Entry> entryList = (ArrayList<Entry>) ((EntryList) request.getSession().getAttribute("entryList")).getEntryList();
        Entry lastEntry = entryList.get(entryList.size() - 1);
    %>
        <table class="table">
            <th id="header-text" colspan="3" nowrap>
                Сушкевич Антон Дмитриевич, P3214, вариант 2530
            </th>
            <tr>
                <td id="message" colspan="3">
                    <%
                      if (lastEntry.getIsHit()) {
                          out.print("The point has hit the field!");
                      }else {
                          out.print("The point hasn't hit the field!");
                      }
                    %>
                </td>
            </tr>
            <tr>
                <td class="resultCells" >
                    <%= lastEntry.getX() %>
                </td>
                <td class="resultCells" >
                    <%= lastEntry.getY() %>
                </td>
                <td class="resultCells" >
                    <%= lastEntry.getR() %>
                </td>
            </tr>
            <tr>
                <td id="buttonCell"colspan="3">
                    <form>
                    <button class="button" type="submit"></button>
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
