<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "/navbar.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Loan Detail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container-fluid mt-2">
    <!--<div class="row justify-content-center">
        <img  src="logo.png">
    </div>-->
</div>

<hr style="width: 98%">

<div class="container pt-4 ">

    <div class="row d-flex justify-content-center">
        <h1 class="display-4">Customer Details</h1>
    </div>
    <div class="row d-flex justify-content-center mt-5 mb-2">

        <table class="table table-striped table-hover table-bordered table-sm ">
            <tr>
                <td>Customer Code :</td>
                <td><c:out value="${customerObj.customerCode}" /></td>
            </tr>
            <tr>
                <td>First Name :</td>
                <td><c:out value="${customerObj.fisrtName}" /></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><c:out value="${customerObj.lastName}" /></td>
            </tr>
            <tr>
                <td>Date of Birth :</td>
                <td><c:out value="${customerObj.dateOfBirth}" /></td>
            </tr>
            <tr>
                <td>Nationality :</td>
                <td><c:out value="${customerObj.nationality}" /></td>
            </tr>
            <tr>
                <td>Occupation Type :</td>
                <td><c:out value="${customerObj.occupationType}" /></td>
            </tr>
            <tr>
                <td>Total Work Experience :</td>
                <td><c:out value="${customerObj.totalWorkExperience}" /></td>
            </tr>
            <tr>
                <td>Organization Name :</td>
                <td><c:out value="${customerObj.organizationName}" /></td>
            </tr>
        </table>

    </div>

    <!--<div class="row d-flex justify-content-center" >
        <button type="button" id="approveBtn" class="btn btn-success mx-3"> Approve Loan </button>
        <button type="button" class="btn btn-danger mx-3"> Reject Loan </button>
    </div>-->

</div>
</body>
</html>