<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert New Employee</title>
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
        <h2>Add New Employee</h2>
        <form method="post" action="insertEmp">
            <label>Employee Name:</label>
            <input type="text" name="employee_name" required />

            <label>Phone:</label>
            <input type="text" name="employee_phone" required />

            <label>Gender:</label>
            <select name="employee_gender" required>
                <option value="">Select</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">other</option>
            </select>

            <label>Salary:</label>
            <input type="number" name="employee_salary" required />

            <label>Role:</label>
            <input type="text" name="employee_role" required />

            <button type="submit">Insert Employee</button>
        </form>
    </div>
</body>
</html>