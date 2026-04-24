<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f0f0f0; }
        .container { width: 400px; margin: 100px auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); text-align: center; }
        .success { color: #4CAF50; font-size: 24px; }
        .error { color: #f44336; font-size: 24px; }
        a { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px; }
        a:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <div class="container">
        <% if(Boolean.TRUE.equals(request.getAttribute("success"))) { %>
            <p class="success">✅ ${message}</p>
        <% } else { %>
            <p class="error">❌ ${message}</p>
        <% } %>
        <a href="/courses">Back to Courses</a>
    </div>
</body>
</html>