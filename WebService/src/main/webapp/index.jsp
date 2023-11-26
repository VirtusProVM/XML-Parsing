<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Service Assignment</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        
        <div class="mainContainer">
            <div id="searchByManufacturer">
                <input id="manufacturer" type="text" name="manufacturer" size="20" placeholder="Input car name..." /><br />

                <a id="link" href="getCarsByManufacturer.jsp">Search</a>
            </div><br />

            <div id="searchByYear">
                <input id="fromYear" type="number" placeholder="From year..." size="20" name="fromYear" /> <br />

                <a id="searchCarByYear" href="getCarsByYear.jsp">Refresh</a>
            </div><br />
            
            <div id="searchByFuelType">
                <label for="fuelCar">Select fuel type</label><br />
                <select id="selectCar" name="fuelType">
                    <option id="electric">Electric</option>
                    <option id="fuel">Fuel</option>
                    <option id="hybrid">Hybrid</option>
                </select><br />
                
                <a id="searchCarByFuelType" href="getCarsByFuelType.jsp">Refresh</a>
            </div>
        </div>
        
    </body>
    
    <script>
        var value = document.getElementById("link");
        var valueFromTextField = document.getElementById("manufacturer");
        var url = value.href;
        
        valueFromTextField.onchange = function() {
            value.href = url + "?manufacturer=" + this.value;
        };
        
        
        
        
        var fromYear = document.getElementById("fromYear");
        
        var hrefValue = document.getElementById("searchCarByYear");
        var yearURL = hrefValue.href;
        
        fromYear.onchange = function() {
            hrefValue.href = yearURL + "?fromYear=" + this.value;
        };
        
        
        
        
        var selectedValue = document.getElementById("selectCar");
        var fuelValue = selectedValue.value;
        var textValue = selectedValue.options[selectedValue.selectedIndex].text;
        
        var fuelUrl = document.getElementById("searchCarByFuelType");
        var hrefFuelValue = fuelUrl.href;
        
        selectedValue.onchange = function() {
            fuelUrl.href = hrefFuelValue + "?fuelType=" + this.value;
        };
        
        var fuel = document.getElementById("fuel");
        var electric = document.getElementById("electric");
        var hybrid = document.getElementById("hybrid");
        
        
        
    </script>
   
</html>
