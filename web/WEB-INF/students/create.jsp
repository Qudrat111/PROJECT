<%--
  Created by IntelliJ IDEA.
  User: Salim
  Date: 9/2/2024
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Student</title>
    <style>
        .form-container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        .form-container h2 {
            margin-bottom: 20px;
        }

        .form-container label {
            display: block;
            margin-bottom: 10px;
        }

        .form-container input[type="text"],
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Create New Student</h2>
    <form action="/student/create" method="post">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required>
        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName" required>
        <label for="dateOfBirth">Date Of Birth:</label>
        <input type="date" id="dateOfBirth" name="dateOfBirth" required>
        <label for="groupId">Group Id</label>
        <input type="number" id="groupId" name="groupId" required>
        <input type="submit" value="Create Student">
    </form>
</div>
</body>
</html>
