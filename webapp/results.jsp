<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="result" class="com.rogachova.web2.model.Shot" scope ="request"/>
<html>
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
                <tr class="content">
                <td>${result.x}</td>
                <td>${result.y}</td>
                <td>${result.r}</td>
                <td class = ${result.isHit ? "hit": "miss"}>${result.isHit ? "hit": "miss"}</td>
                </tr>
        </tbody>
        </table>
        </div>
</html>