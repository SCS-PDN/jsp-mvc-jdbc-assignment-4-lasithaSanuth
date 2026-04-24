<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f0f0; }
        .container { width: 800px; margin: 50px auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; }
        th { background-color: #4CAF50; color: white; padding: 10px; }
        td { padding: 10px; border-bottom: 1px solid #ddd; text-align: center; }
        tr:hover { background-color: #f5f5f5; }
        button { padding: 8px 16px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .logout { float: right; padding: 8px 16px; background-color: #f44336; color: white; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; }
        .welcome { margin-bottom: 20px; }
    </style>
</head>
<body>
    <div class="container">
        <a href="/logout" class="logout">Logout</a>
        <div class="welcome">
            <h2>Welcome, ${student.name}!</h2>
        </div>
        <h3>Available Courses</h3>
        <table>
            <tr>
                <th>Course Name</th>
                <th>Instructor</th>
                <th>Credits</th>
                <th>Action</th>
            </tr>
            <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.name}</td>
                <td>${course.instructor}</td>
                <td>${course.credits}</td>
                <td>
                    <form action="/register/${course.courseId}" method="post">
                        <button type="submit">Register</button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>