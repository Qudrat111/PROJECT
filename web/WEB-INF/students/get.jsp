<%--
  Created by IntelliJ IDEA.
  User: Salim
  Date: 9/2/2024
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        .actions a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
<h2>Student List</h2>
<a href="/student/create">Create New Student</a>
<table>
    <thead>
    <tr>
        <th>Group Id</th>
        <th>Full Name</th>
        <th>UserName</th>
        <th>Date Of Birth</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.group_id}</td>
            <td>${student.fullName}</td>
            <td>${student.userName}</td>
            <td>${student.dateOfBirth}</td>
            <td class="actions">
                <a href="/student/update?id=${student.id}">Update</a>
                <a href="/student/delete?id=${student.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
