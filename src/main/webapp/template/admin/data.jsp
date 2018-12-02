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
            </div>
            
            <form method="POST" id="js-form">
                <fieldset>
                    <legend>Data Type</legend>
                    
                    <input type="radio" name="data_type" value="categories" id="categories" checked="checked" class="js-radio">
                    <label for="categories">Categories</label>
                    
                    <input type="radio" name="data_type" value="customers" id="customers" class="js-radio">
                    <label for="customers">User</label>
                    
                    <input type="radio" name="data_type" value="locations" id="locations" class="js-radio">
                    <label for="locations">Location</label>
                </fieldset>
                <fieldset>
                    <legend>Period</legend>
                    
                    <label for="date_start"></label>
                    <input type="date" name="date_start" id="date_start" class="js-date-start">

                    <label for="date_end"></label>
                    <input type="date" name="date_end" id="date_end" class="js-date-end">
                </fieldset>
                
                <input type="hidden" name="_action" value="category">
            </form>

        </div>
        
        <%@ include file="../partial/_footer.jsp" %>
        
        <!-- Script -->
        <script src="https://www.gstatic.com/charts/loader.js"></script>
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script>
            $(document).ready( function() {
                // Get data from api with ajax
                let getDataFromApi = function(dataType, dateStart, dateEnd) {
                    let data = [["",""]];
                    
                    $.ajax({
                        method: 'GET',
                        url: '/Mini-Project/PurchaseOrder',
                        data: {data_type: dataType, date_start: dateStart, date_end: dateEnd},
                        async: false,
                        success: function(result) {
                            result.records.forEach((item) => {
                                data.push([
                                    item.value.description || item.value.name || item.value.state, 
                                    item.key
                                ]);
                            });
                        }
                    });
                    
                    return data;
                };
                
                let drawCharts = function(dataType, dateStart, dateEnd) {
                    // Draw Google Charts
                    google.charts.load('current', {'packages':['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {
                        let data = google.visualization.arrayToDataTable(getDataFromApi(dataType, dateStart, dateEnd));

                        let chart = new google.visualization.PieChart(document.getElementById('js-piechart'));

                        chart.draw(data, {});
                    }
                };
                
                // RundrawCharts(
                drawCharts(
                    $(".js-radio:checked").val(),
                    $(".js-date-start").val(), 
                    $(".js-date-end").val()
                );
                $("#js-form").on("change", function() {
                    drawCharts(
                        $(".js-radio:checked").val(),
                        $(".js-date-start").val(), 
                        $(".js-date-end").val()
                    );
                });
            });
        </script>

    </body>
</html>