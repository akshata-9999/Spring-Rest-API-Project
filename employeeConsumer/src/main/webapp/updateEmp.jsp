<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 40px auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }
        h2 {
            text-align: center;
            color: #007bff;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin: 12px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            margin-top: 10px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Update Employee</h2>
        <form action="update" method="post">
    <input type="hidden" name="_method" value="put" />
    <input type="hidden" name="employee_id" value="${employee.employee_id}" />
        
            <label>Employee Name:</label>
            <input type="text" name="employee_name" value="${employee.employee_name}"required />

            <label>Phone:</label>
            <input type="text" name="employee_phone" value="${employee.employee_phone}" required />

            <label>Gender:</label>
            <select name="employee_gender" required>
                <option value="">Select</option>
                <option value="Male" ${employee.employee_gender == 'Male' ? 'selected' : ''}>Male</option>
                <option value="Female" ${employee.employee_gender == 'Female' ? 'selected' : ''}>Female</option>
                <option value="Other" ${employee.employee_gender == 'Other' ? 'selected' : ''}>Other</option>
            </select>

            <label>Salary:</label>
            <input type="number" name="employee_salary" value="${employee.employee_salary}"required />

            <label>Role:</label>
            <input type="text" name="employee_role" value="${employee.employee_role}" required />

            <button type="submit">Update Employee</button>
        </form>
    </div>
</body>
</html>