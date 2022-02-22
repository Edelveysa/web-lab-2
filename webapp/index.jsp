<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="history" class="com.model.ShotHistory" scope ="session"/>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <title>Лабораторная работа 2</title>
        <link rel="stylesheet" href="css/style.css">
</head>
<body onload="canvas_init()">
<div class ="header">
        <h2>
                Севрюкова Екатерина, вариант 13209
        </h2>
</div>
<div id = "image">
        <canvas id="target_canvas" width="480" height="480"></canvas>
</div>
<div id = "last_hit_results">
        <p id = "last_hit_result"></p>
</div>
<div class = "shoot_form">
        <form id="shoot_form" name="shoot_form"  enctype='multipart/form-data'>
                <table id="shoot_form_table">
                        <tr>
                                <td>
                                        <label class="choose"> Выберете X: </label>
                                </td>
                                <% for (int i = -3; i <= 5; i++) { %>
                                <td>
                                        <input type="radio" name="x_input" id="x_input" value="<%=i%>">
                                        <%=i%>
                                </td>
                                <% } %>
                        </tr>
                        <tr>
                                <td>
                                        <label class="choose">Выберите Y:</label>
                                </td>
                                <td>

                                </td>
                                <td>
                                        <input type="text" id="y_input" name="y_input">
                                </td>
                        <tr>
                                <td>
                                        <label class="choose">Выберите R:</label>
                                </td>

                                <% for (double i = 1; i <= 3; ) { %>
                                <td>
                                        <input type="radio" name="r_input" id="r_input" value="<%=i%>">
                                        <%=i%>
                                        <%i += 0.5; %>
                                </td>
                                <% } %>
                        </tr>
                </table>
                <button type = "button" onclick="shoot()">отправка</button>
        </form>
</div>
<p id="script_time_start"></p>
<p id="script_time"></p>
<div> <link rel="stylesheet" href="css/table.css">
        <table id="hits_table">
                <thead id="hits_table_head"  class = "table_header">
                <tr>
                        <td>X</td>
                        <td>Y</td>
                        <td>R</td>
                        <td>Result</td>
                </tr>
                </thead>
                <tbody id="hits_table_body">
                <%
                        for (int i = history.getHistory().size() - 1; i >= 0; i--) {
                                out.println(String.format(
                                        "<tr class=\"content\"><td>%.3f</td><td>%.3f</td><td>%d</td><td class=\"%s\">%s</td></tr>",
                                        history.getHistory().get(i).getX(),
                                        history.getHistory().get(i).getY(),
                                        Math.round(history.getHistory().get(i).getR()),
                                        history.getHistory().get(i).getIsHit() ? "hit" : "miss",
                                        history.getHistory().get(i).getIsHit() ? "hit" : "miss"
                                ));
                        }
                %>
                </tbody>
        </table>
</div>

<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/controller.js"></script>
<script type="text/javascript" src="js/canvas_controller.js"></script>
<script type="text/javascript" src="js/r_and_x.js"></script>

</body>

</html>