<%--
  Created by IntelliJ IDEA.
  User: Salim
  Date: 9/2/2024
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>File Download</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .download-form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .download-form h2 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

        .download-form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .download-form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
        }

        .download-form input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="download-form">
    <h2>Download a File</h2>
    <form action="download" method="post">
        <select name="file" required>
            <c:forEach var="file" items="${files}" varStatus="status">
                <option value="${file}">File ${status.index+1}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Download">
    </form>
</div>

</body>
</html>
