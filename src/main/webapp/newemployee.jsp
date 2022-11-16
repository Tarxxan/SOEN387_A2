<%--
  Created by IntelliJ IDEA.
  User: christian.henneveld
  Date: 2022-11-15
  Time: 8:06 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
    <meta charset="utf-8">
    <link href="settings/reset.css" rel="stylesheet">
    <link href="settings/styles.css" rel="stylesheet"/>
    <link href="settings/formsstyles.css" rel="stylesheet"/>


    <title>New&nbsp;administrator&nbsp;account</title>
</head>
<body>
<div class="page-container">
    <div class="header">
        <h1>Administrator site</h1>
        <h2>New&nbsp;administrator&nbsp;account</h2>
    </div>
    <div class="navbar">
        <a class="right" href="index.jsp" >Logout</a>
        <a href="adminsite.jsp">Reports</a>
        <a class="active" href="newemployee.jsp">New employee</a>
        <a href="newstudent.jsp">New student</a>
        <a href="newcourse.html">New course</a>
    </div>


    <div class="content-wrapper w-container ">


        <form novalidate action="/NewEmployeeServlet" onsubmit="return validateneformForm()" name="neform" method="post" target="_self">
            <div class="row card">
                <div class="column">

                    <div class="form-group">

                        <input class="form-control" name="nename" placeholder="Name"  type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="nelastname" placeholder="Last Name"  type="text">
                    </div>

                    <div class="form-group">
                        <input class="form-control" name="neestreetnumber"
                               placeholder="Street number"
                               type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="nestreetname" placeholder="Street name"  type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="necity" placeholder="City"  type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="neprovince" placeholder="Province"  type="text">
                    </div>

                    <div class="form-group">
                        <input class="form-control" name="necountry" placeholder="Country"
                               type="text">

                    </div>

                    <button class="btn center-box" onclick="window.location.href='adminsite.html';">Cancel
                    </button>
                </div>

                <div class="column">
                    <div class="form-group">
                        <input class="form-control" name="nepostalcode"
                               placeholder="Postal Code"  type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="neemail" placeholder="Email"  type="email">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="nephone"
                               placeholder="Phone number"
                               type="tel">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="nedateofbirth" placeholder="Date of birth"
                               type="date">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="nepassword"
                               placeholder="Password"

                               title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                               type="password">
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="neconfirmpassword"

                               placeholder="confirm-password"

                               title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                               type="password">

                    </div>

                    <input class="center-box" name="nesubmit" type="submit" value="Save">

                </div>
            </div>
        </form>

        <footer class="footer">

        </footer>
    </div>
</div>

<script src="settings/newemployee.js" type="text/javascript"></script>
</body>
</html>