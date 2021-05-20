<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Available lots</title>
</head>
<body>
    <c:if test="${user==null}" >

            <div class = "bg-gray-100 flex justify-left">
                <table class="border-separate border border-green-800 ...">
                    <thead>
                    <tr>
                        <th class="border border-green-600 ...">Lot name</th>
                        <th class="border border-green-600 ...">Info</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="lot" items="${lots}" >
                        <tr>
                            <td class="border border-green-600 ..."><c:out value="${lot.getName()}"/></td>
                            <td class="border border-green-600 ..."><c:out value="${lot.getInfo()}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
    </c:if>
</body>
</html>
