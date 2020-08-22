<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TODO List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script>
        function updateItemList() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/todolist/itemlist',
                dataType: 'json'
            }).done(function(data) {
                let content = "";

                // todo: make item list with check/edit links etc.

                // for (let k in data) {
                //     content += "<tr>";
                //     content += "<th>" + k + "</th>";
                //     for (let c in data[k]) {
                //         let seatData = data[k][c];
                //         let dis = seatData.accId > 0 ? " disabled=\"disabled\" " : "";
                //         let color = seatData.accId > 0 ? " bgcolor=\"red\" " : "";
                //         content += "<td " + color + ">";
                //         content += "<input type=\"radio\" name=\"place\" value=\"" + seatData.id + "\" " +
                //             dis + " > " +
                //             "Ряд " + seatData.row + ", Место " + seatData.number;
                //         content += "</td>";
                //     }
                //     content += "</tr>";
                // }
                $('#tdata').html(content);
            });
        }
        updateItemList();
    </script>

</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">TODO List</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="edit.jsp">New Item</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th><i class="fa fa-check-square-o" aria-hidden="true"></i></th>
            <th><i class="fa fa-edit mr-3"></i></th>
            <th>Description</th>
            <th>Created</th>
            <th>Done</th>
        </tr>
        </thead>
        <tbody id="tdata">
        <tr>
			<td>
                <a href='<c:url value="<%=request.getContextPath()%>/edit?id=${can.id}"/>'>
                    <i class="fa fa-square-o" aria-hidden="true"></i>
                </a>
            </td>
            <td>
                <a href='<c:url value="<%=request.getContextPath()%>/edit?id=${can.id}"/>'>
                    <i class="fa fa-edit mr-3"></i>
                </a>
            </td>
            <td>Make TODO List app</td>
            <td>22/08/2020</td>
            <td></td>
        </tr>
        <tr>
			<td>
                <a href='<c:url value="<%=request.getContextPath()%>/edit?id=${can.id}"/>'>
                    <i class="fa fa-check-square-o" aria-hidden="true"></i>
                </a>
            </td>
            <td>
                <a href='<c:url value="<%=request.getContextPath()%>/edit?id=${can.id}"/>'>
                    <i class="fa fa-edit mr-3"></i>
                </a>
            </td>
            <td>Call Harry</td>
            <td>20/08/2020</td>
            <td>21/08/2020</td>
        </tr>
        <tr>
			<td>
                <a href='<c:url value="<%=request.getContextPath()%>/edit?id=${can.id}"/>'>
                    <i class="fa fa-square-o" aria-hidden="true"></i>
                </a>
            </td>
            <td>
                <a href='<c:url value="<%=request.getContextPath()%>/edit?id=${can.id}"/>'>
                    <i class="fa fa-edit mr-3"></i>
                </a>
            </td>
            <td>Read the Hibernate Manual Guide</td>
            <td>21/08/2020</td>
            <td></td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
