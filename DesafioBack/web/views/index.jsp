<%-- 
    Document   : index
    Created on : 26/07/2018, 19:11:26
    Author     : Leo
--%>

<%@page import="controller.ControllerCustomer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Desafio Back</title>
    </head>
    <body>
        <% 
            // Instanciando classe ControllerCustomer
            ControllerCustomer concus = new ControllerCustomer();
            // Ordenando inserção dos usuários
            concus.insert(1496,"10055522288", "Maria", true, "400.50");
            concus.insert(1497,"11155522288", "Frederico", true, "600.50");
            concus.insert(1498,"20055522388", "Flavio", true, "950.50");
            concus.insert(1499,"30055523288", "Joana", false, "300.50");
            concus.insert(1500,"10055521288", "Cleber", true, "1500.50");
            concus.insert(1501,"30055522288", "Frederico", true, "145.50");            
            concus.insert(1502,"20155522288", "Marcinho", false, "300.50");
            concus.insert(1503,"23355522288", "Diany", true, "9999.50");
            concus.insert(1504,"10055525248", "Vinicius", true, "8001.50");
            concus.insert(1505,"29955828258", "Janaina", true, "9990.50");
            concus.insert(1506,"70755722788", "Jose", true, "8000.50");
            // Mostra quantos usuários foram inseridos
            out.print("<h3>Quantidade de registros inseridos: "+concus.execute()+"<h3>");
            out.print("<h3>Média: "+concus.showAvg().toString()+"<h3>");
            for(int i=0; i<concus.showCust().size(); i++) {
                if(i>1 && i%5==0) {
                    out.println("<br/>");
                }
                out.println(" "+concus.showCust().get(i));
            }
        %>
    </body>
</html>
