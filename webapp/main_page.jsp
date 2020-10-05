<%@ page import="session.Entry" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="session.EntryList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sniper</title>
    <link rel="stylesheet" type="text/css" href="main.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script>
</head>
<body>
<table class="table" id="mainTable">
    <tr>
        <th id="header-text" colspan="3" nowrap>
            Сушкевич Антон Дмитриевич, P3214, вариант 2515
        </th>
    </tr>
    <tr id="mainFrame">
        <!--cell for the arrows of target area-->
        <td id="arrows" width="500px" height="500px">
            <canvas class="canvas" id="canvasArrows"></canvas>
            <canvas class="canvas" id="canvasMarks"></canvas>
            <canvas class="canvas" id="canvasDots"></canvas>
        </td>
        <td id="fixser">
            <form id="form" method="post">
            <table id="buttons-table">
                <tr >
                    <div id="shield" ></div>
                </tr>
                <tr>
                    <td class="headerText">
                        X:
                    </td>
                    <td class="textField" >
                        <input id="xField" type="text" name="X" maxlength="25" autofocus oninput="validate()" onchange="validate()" serialize="true">
                    </td>

                </tr>
                <tr>
                    <td class="headerText">
                        Y:
                    </td>
                    <td id="yField">
                        <input type="button" name="Y" class="yButton" value="-3" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="-2" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="-1" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="0" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="1" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="2" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="3" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="4" onclick="saveY(this)" serialize="true">
                        <input type="button" name="Y" class="yButton" value="5" onclick="saveY(this)" serialize="true">
                        <input id="yValue" type="hidden" name="Y" value="">
                    </td>
                </tr>
                <tr>
                    <td class="headerText">
                        R:
                    </td>
                    <td>
                        <input type="button" name="R" class="rButton" value="1" onclick="saveR(this)" serialize="true">
                        <input type="button" name="R" class="rButton" value="2" onclick="saveR(this)" serialize="true">
                        <input type="button" name="R" class="rButton" value="2.5" onclick="saveR(this)" serialize="true">
                        <input type="button" name="R" class="rButton" value="3" onclick="saveR(this)" serialize="true">
                        <input id="rValue" type="hidden" name="R" value="">
                    </td>
                </tr>
                <tr>
                    <td class="headerText">
                        <button class="submitButton" type="submit" value="send" id="sendingButton" ></button>
                    </td>
                    <td id="informationCell">
                        <p class="commonText" id="informationText">

                        </p>
                    </td>
                </tr>
            </table>
            </form>
        </td>
    </tr>
    <tr id="resultRow">
        <table class="table" id="resultTable">
            <tr>
                <td class="headerText">
                    X
                </td>
                <td class="headerText">
                    Y
                </td>
                <td class="headerText">
                    R
                </td>
                <td  class="headerText">
                    Hit
                </td>
                <td class="headerText">
                    Data time
                </td>
                <td class="headerText">
                    Answer time
                </td>
            </tr>

            <jsp:useBean id="entryList" scope="session" class="session.EntryList"/>
            <c:forEach var="tempEntry" items="${entryList.entryList}">


                        <tr>
                            <td class="commonText">
                                ${tempEntry.getX()}
                            </td>
                            <td class="commonText">
                                    ${tempEntry.getY()}
                            </td>
                            <td class="commonText">
                                    ${tempEntry.getR()}
                            </td>
                            <td class="commonText">
                                    ${tempEntry.getIsHit()}
                            </td>
                            <td class="commonText">
                                    ${tempEntry.getTimeContainer().getData()}
                            </td>
                            <td class="commonText">
                                    ${tempEntry.getTimeContainer().getTime()}
                            </td>
                        </tr>


            </c:forEach>
        </table>
    </tr>
    <tr>
        <td id="audio" >
            <audio controls="" merg >
                <source src="sources/homm3 - OST.mp3">
            </audio>
        </td>
    </tr>
</table>
<script src="js/arrows.js"></script>
<script src="js/validation.js"></script>
<script src="js/send.js"></script>
<script src="js/tableManager.js"></script>
</body>
</html>