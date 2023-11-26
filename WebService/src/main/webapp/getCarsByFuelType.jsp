<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <c:import var="cars" url="files/cars.xml" />
        
        <x:parse xml="${cars}" var="carName" />
        
        <%
            String fuelType = request.getParameter("fuelType").toLowerCase();
            request.setAttribute("fuel", fuelType);
        %>
        
        <table>
            <tr>
                <th>Manufacturer</th>
                <th>Model</th>
                <th>Production Year</th>
                <th>HP</th>
                <th>Price</th>
                <th>Consumption</th>
                <th>Consumption Type</th>
            </tr>
                    
            <x:forEach select="$carName/cars/car[consumption/@type = $fuel]" var="item">
                

                <tr>
                    <td><x:out select="$item/manufacturer" /></td>
                    <td><x:out select="$item/model" /></td>
                    <td><x:out select="$item/production-year" /></td>
                    <td><x:out select="$item/horsepower" /></td>
                    <td><x:out select="$item/price" /></td>
                    <td><x:out select="$item/consumption" /></td>
                    <td><x:out select="$item/consumption/@type" /></td>
                </tr>
                
            </x:forEach> 
        </table>
    </body>
</html>
