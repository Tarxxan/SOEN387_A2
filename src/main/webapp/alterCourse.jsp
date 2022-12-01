<%@ page import="Classes.DisplayHelper" %><%--
  Created by IntelliJ IDEA.
  User: cpang
  Date: 2022-11-30
  Time: 10:30 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: cpang
  Date: 2022-11-16
  Time: 9:20 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>New&nbsp;course</title>

  <link href="settings/reset.css" rel="stylesheet">
  <link href="settings/styles.css" rel="stylesheet"/>
  <link href="settings/formsstyles.css" rel="stylesheet"/>

</head>
<body>
<div class="page-container">

  <div class="header">
    <h1>Administrator site</h1>
    <h2>New&nbsp;Course</h2>

  </div>


  <div class="navbar">
    <a class="right" href="index.jsp" >Logout</a>
    <a href="adminsite.jsp">Reports</a>
    <a href="newemployee.jsp">New employee</a>
    <a href="newstudent.jsp">New student</a>
    <a class="active" href="newcourse.jsp">New course</a>

  </div>


  <div class="content-wrapper w-container">

    <form action=<%= request.getContextPath() %>/UpdateCoursesServlet method="post" name="ncform" onsubmit="return validatencformForm()" target="_self">
      <div class="row card">
        <div class="column">

          <div class="form-group">
            <label for="courseCode1" class="center-box">Delete Course</label>
            <select id="courseCode1" name="courseCode">
              <%= DisplayHelper.displayAllCourses()%>
            </select>
          </div>
          <div class="form-group">
            <input class="form-control" name="courseTitle" placeholder="Course Title"  type="text">
          </div>
          <div class="form-group">
            <input class="form-control" name="semester" placeholder="Semester"  type="text">
          </div>

          <div class="form-group">
            <input class="form-control" name="days" placeholder="Days"  type="text" title="ex Mon-Fri" >
          </div>
          <div class="form-group">
            <input class="form-control" name="time" placeholder="Time"
                   type="text" title="ex 12:00 to 14:00">
          </div>



          <button class="btn center-box" onclick="window.location.href='adminsite.jsp';">Cancel
          </button>

        </div>

        <div class=" column">

          <div class="form-group">
            <input class="form-control" name="startDate" placeholder="Start Date"  type="date">
          </div>
          <div class="form-group">
            <input class="form-control" name="endDate" placeholder="End date"  type="date">
          </div>

          <div class="form-group">
            <input class="form-control" name="instructor" placeholder="Instructor"  type="text">
          </div>
          <div class="form-group">
            <input class="form-control" name="room" placeholder="Room"  type="text">
          </div>

          <input class="center-box" name="ncsubmit" type="submit" value="save">

        </div>
      </div>
    </form>

    <form action=<%= request.getContextPath() %>/DeleteCourseServlet method="post" name="ncdform" onsubmit="return validatencformForm()" target="_self">
    <div class="form-group">
      <label for="courseCode" class="center-box">Delete Course</label>
      <select id="courseCode" name="courseCode">
          <%= DisplayHelper.displayAllCourses()%>
      </select>
    </div>
      <input class="center-box" name="ncdsubmit" type="submit" value="Delete Course">
    </form>



    <footer class="footer">

    </footer>
  </div>
</div>
<script src="settings/newcourse.js" type="text/javascript"></script>
</body>
</html>
</body>
</html>
