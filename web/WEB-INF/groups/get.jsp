<%--
  Created by IntelliJ IDEA.
  User: Salim
  Date: 9/2/2024
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Group List</title>
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
<h2>Group List</h2>
<a href="/group/create">Create New group</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groups}">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td class="actions">
                <a href="/group/update?id=${group.id}">Update</a>
                <a href="/group/delete?id=${group.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

