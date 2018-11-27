<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin:Data</title>
        
        <link rel="stylesheet" type="text/css" href="./css/design.css"> 
    </head>
    <body>
        <%@ include file="../partial/_header.jsp" %>
        
        <div class="s-container-main">
            <jsp:include page="../partial/_flashes.jsp">
                <jsp:param name="flashBag" value="${flashBag}" />
            </jsp:include>
            
            <h2>Graphique</h2>
            <div id="js-piechart" style="width: 100%; height: 500px;">
                Loading ...
            </div>
            
            <form method="POST">
                <label for="date_start"></label>
                <input type="date" name="date_start" id="date_start">
                
                <label for="date_end"></label>
                <input type="date" name="date_end" id="date_end">
                
                <input type="hidden" value="_action" value="category">
            </form>

        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
        
        <!-- Script -->
        <script src="https://www.gstatic.com/charts/loader.js"></script>
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script>
            $(document).ready(
                function () {
                    
                    // Draw Google Charts
                    google.charts.load('current', {'packages':['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {

                      var data = google.visualization.arrayToDataTable([
                        ['Task', 'Hours per Day'],
                        ['Work',     11],
                        ['Eat',      2],
                        ['Commute',  2],
                        ['Watch TV', 2],
                        ['Sleep',    7]
                      ]);

                      var options = {
                        title: 'My Daily Activities'
                      };

                      var chart = new google.visualization.PieChart(document.getElementById('js-piechart'));

                      chart.draw(data, options);
                    }
                }
            );
        </script>

    </body>
</html>