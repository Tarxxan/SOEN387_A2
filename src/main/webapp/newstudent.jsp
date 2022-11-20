<%--
  Created by IntelliJ IDEA.
  User: christian.henneveld
  Date: 2022-11-15
  Time: 7:45 p.m.
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
  <title>New&nbsp;student&nbsp;account</title>
</head>
<body>
<div class="page-container">
  <div class="header">
    <h1>Administrator site</h1>
    <h2>New&nbsp;student&nbsp;account</h2>
    <h2></h2>
  </div>

  <div class="navbar">
    <a class="right" href="index.jsp">Logout</a>
    <a href="adminsite.jsp">Reports</a>
    <a href="newemployee.jsp">New employee</a>
    <a class="active" href="newstudent.jsp">New student</a>
    <a href="newcourse.jsp">New course</a>
  </div>

  <div class="content-wrapper w-container ">

    <!--action="BusinessLogic.php"-->
    <form action="<%=request.getContextPath()%>/NewStudentServlet" method="post" name="nsform" novalidate onsubmit="return validatensformForm()"
          target="_self">
      <div class="row card">
        <div class="column">

          <div class="form-group">
            <input class="form-control" name="nsname" placeholder="Name"  type="text">
          </div>
          <div class="form-group">

            <input class="form-control" name="nslastname" placeholder="Last Name"
                   type="text">

          </div>
          <div class="form-group">

            <input class="form-control" name="nsdateofbirth" placeholder="Date of birth"
                   type="date">

          </div>

          <div class="form-group">
            <input class="form-control" name="nsestreetnumber"
                   placeholder="Street number"
                   type="text">

          </div>
              <div class="form-group">

          <input class="form-control" name="nsappartmentnumber" placeholder="Appartment number"
                 type="text">

        </div>
          <div class="form-group">
            <input class="form-control" name="nsstreetname" placeholder="Street name"

                   type="text">

          </div>
          <div class="form-group">
            <input class="form-control" name="nscity" placeholder="City"  type="text">

          </div>
          <div class="form-group">
            <input class="form-control" name="nsprovince" placeholder="Province"
                   type="text">

          </div>

          <div class="form-group">
            <input class="form-control" name="nscountry" placeholder="Country"
                   type="text">

          </div>

          <button class="btn center-box" onclick="window.location.href='adminsite.jsp';">Cancel
          </button>

        </div>
        <div class=" column">

          <div class="form-group">
            <input class="form-control" name="nspostalcode"

                   placeholder="Postal Code" type="text">

          </div>
          <div class="form-group">



            <input class="form-control" name="nsemail"  placeholder="Email" type="email">

          </div>
          <div class="form-group">
            <input class="form-control" name="nsphone"  placeholder="Phone number"
                   type="tel">

          </div>
          <div class="form-group">
            <input class="form-control" name="nspassword"
                   placeholder="Password"
                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                   type="password">

          </div>
          <div class="form-group">
            <input class="form-control" name="nsconfirm-password"
                   placeholder="confirm-password"

                   title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                   type="password">

          </div>

          <input class="center-box" name="nssubmit" type="submit" value="Save">


        </div>
      </div>

    </form>

    <footer class="footer">

    </footer>
  </div>
</div>


<script src="settings/newstudent.js" type="text/javascript"></script>
</body>