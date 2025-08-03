<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-4">
    <h2 class="text-center text-primary mb-4">Employee Management System</h2>
<br>
<a href="insertEmployee" class="btn btn-sm btn-warning btn-action">Insert New Employee</a><br><br>
    <!-- Employee Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>SI.NO</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Gender</th>
                    <th>Salary</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${employees}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${employee.employee_id}</td>
                        <td>${employee.employee_name}</td>
                        <td>${employee.employee_phone}</td>
                        <td>${employee.employee_gender}</td>
                        <td>${employee.employee_salary}</td>
                        <td>${employee.employee_role}</td>
                        <td>
                       <a href="editEmp?employee_id=${employee.employee_id}" class="btn btn-sm btn-warning">Edit</a>


            <a href="deleteEmployee/${employee.employee_id}" 
   class="btn btn-sm btn-danger btn-action"
   onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>

               </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
