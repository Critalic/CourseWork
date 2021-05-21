<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Main</title>
</head>
<body>
    <div class="bg-gradient-to-r from-yellow-400 via-red-500 to-pink-500 ...">
        <div class="relative py-3 sm:max-w-xl sm:mx-auto">
            <div class="absolute inset-0 bg-gradient-to-r from-cyan-400 to-light-blue-500 shadow-lg transform -skew-y-6 sm:skew-y-0 sm:-rotate-6 sm:rounded-3xl"></div>
            <div class="relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20">
                <div class="max-w-md mx-auto">
                    <p class="text-2xl">Active lots</p>
                    <form class = "bg-gray-100 flex justify-left">
                        <table class="border-separate border border-green-800 ...">
                            <thead>
                            <tr>
                                <th class="border border-green-600 ...">Lot name</th>
                                <th class="border border-green-600 ...">Info</th>
                                <th class="border border-green-600 ...">Owner</th>
                                <th class="border border-green-600 ...">Number of bids</th>
                                <th class="border border-green-600 ...">Last offered price </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="lot" items="${lots}" >
                                <c:if test="${lot.isActive()}" >
                                    <tr>
                                        <td class="border border-green-600 ..."><c:out value="${lot.getName()}"/></td>
                                        <td class="border border-green-600 ..."><c:out value="${lot.getInfo()}"/></td>
                                        <td class="border border-green-600 ..."><c:out value="${lot.getOwner()}"/></td>
                                        <td class="border border-green-600 ..."><c:out value="${lot.getOffers().size()}"/></td>
                                        <td class="border border-green-600 ..."><c:out value="${lot.getPrice()} $"/></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                    <a href="<c:url value="/index.jsp"/>" class="text-cyan-600 hover:text-cyan-700"> &larr; Back to main</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
