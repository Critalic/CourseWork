<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Film library</title>

</head>
<body >

<div class="min-h-screen bg-gray-100 py-6 flex flex-col justify-center sm:py-12">
    <div class="relative py-3 sm:max-w-xl sm:mx-auto">
        <div class="absolute inset-0 bg-gradient-to-r from-cyan-400 to-light-blue-500 shadow-lg transform -skew-y-6 sm:skew-y-0 sm:-rotate-6 sm:rounded-3xl"></div>
        <div class="relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20">
            <div class="max-w-md mx-auto">
                <div class="divide-y divide-gray-200">
                    <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
                        <p><h2>Welcome to the auction!</h2></p>
                        <ul class="list-disc space-y-2">

                            <li class="flex items-start">
                              <span class="h-6 flex items-center sm:h-7">
                                  <form action = "Creators/ActorCreator.jsp" method="post" >
                                    <button class = "bg-blue-300 text-x1 font-semibold px-4 py-1 rounded hover:bg-blue-800 hover:text-white " type="submit">Sign in</button>
                                  </form>
                              </span>
                            </li><br>

                            <li class="flex items-start">
                              <span class="h-6 flex items-center sm:h-7">
                                <form action = "Creators/MovieCreator.jsp" method="post">
                                  <button class = "bg-blue-300 text-x1 font-semibold px-4 py-1 rounded hover:bg-blue-800 hover:text-white " type="submit">Log in</button>
                                </form>
                              </span>
                            </li><br>

                            <li class="flex items-start">
                              <span class="h-6 flex items-center sm:h-7">
                                <form action = "deleter" method="get">
                                  <button class = "bg-blue-300 text-x1 font-semibold px-4 py-1 rounded hover:bg-blue-800 hover:text-white " type="submit">View lots</button>
                                </form>
                              </span>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
