<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>Dear Employee, you are welcome!</h2>
<br>
<br>

<%--Your name: ${param.employeeName}--%>

Your name: ${employee.name}
<br><br>
Your surName: ${employee.surName}
<br><br>
Your salary: ${employee.salary}
<br><br>
Your phoneNumber: ${employee.phoneNumber}
<br><br>
Your email: ${employee.email}
<br><br>
Your department: ${employee.department}
<br><br>
Your car: ${employee.carBrand}
<br><br>
Languages:
<ul>
    <c:forEach var="lang" items="${employee.languages}">

        <li>
            ${lang}
        </li>
    </c:forEach>
</ul>
</body>

</html>