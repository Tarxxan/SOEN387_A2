<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>School&nbsp;website&nbsp;home</title>
  <link href="settings/reset.css" rel="stylesheet">
  <link href="settings/styles.css" rel="stylesheet"/>
  <link href="settings/formsstyles.css" rel="stylesheet"/>
  <meta content="width=device-width, initial-scale=1" name="viewport">

</head>
<body>

<div class="header">
  <h1>Welcome&nbsp;to&nbsp;your&nbsp;school&nbsp;website</h1>
  <br>
</div>
<div class="navbar">

</div>

<div class="content-wrapper ">
  <div class="row ">


    <div class="column">

      <h1>Student</h1>

      <br><br>

      <span>If you are a student, login to the student course registration page and sign in to your account with your student ID and your password</span>
      <br><br>

      <form action="<%= request.getContextPath() %>/LoginServlet" method="post" onsubmit="return validatehsformForm()" name="hsform" >


        <label for="studentid"> Student ID</label>

        <input class="form-control" id="studentid" name="studentid"
               placeholder="Student ID"
               type="text">
        <br>

        <label for="studentpassword"> Password</label>
        <input class="form-control" id="studentpassword"  name="spassword" placeholder="Password"
               title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
               type="password">


        <input  name="slogin" type="submit"  value="Login">

      </form>
    </div>


    <div class="column ">


      <h1>Administrator</h1>
      <br><br>

      <span>If you are as administrator, login to the employee course registration page and sign in to your account with your employee ID and your password</span>
      <br><br>

      <form action="<%= request.getContextPath() %>/LoginServlet" method="POST" onsubmit="return validateheformForm()" name="heform" target="_self">

        <label for="employeeid"> Administrator ID</label>
        <input class="form-control success" id="employeeid" name="employeeid"
               placeholder="Employee ID"
               type="text">
        <br>

        <label for="employeepassword">Password</label>
        <input class="form-control " id="employeepassword" name="epassword"
               placeholder="Password"
               title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
               type="password">


        <input  name="elogin" type="submit"
                value="Login">

      </form>

    </div>

  </div>
  <footer class="footer">

  </footer>
</div>

<script src="settings/home.js" type="text/javascript"> </script>
</body>

</html>