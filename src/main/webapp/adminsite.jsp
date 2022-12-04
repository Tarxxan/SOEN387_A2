<%@ page import="Classes.DisplayHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html dir="ltr" lang="en">
<head>
  <meta charset="utf-8">
  <link href="settings/reset.css" rel="stylesheet">
  <link href="settings/styles.css" rel="stylesheet"/>
  <link href="settings/formsstyles.css" rel="stylesheet"/>
  <title>Administrator&nbsp;reports</title>
</head>
<body>
<div class="page-container">
  <div class="header">
    <h1>Administrator site</h1>
    <h2>Reports</h2>
    <h2>${name}</h2>
  </div>

  <div class="navbar">
    <a class="right" href="index.jsp" onclick="processLogout()">Logout</a>
    <a class="active" href="adminsite.jsp">Reports</a>
    <a href="newemployee.jsp">New employee</a>
    <a href="newstudent.jsp">New student</a>
    <a href="newcourse.jsp">New course</a>
    <a href="altercourse.jsp">Modify course</a>
  </div>


  <div class="content-wrapper w-container">

    <div class="row card">


      <div class="column ">
        <form method="POST" action="<%=request.getContextPath()%>/AdminServlet" target="myIframeAdmin">
          <div class="form-group">

            <label for="addCourse" >Course&nbsp;participants</label>
            <select id="addCourse" name="studentCourse">
              <% DisplayHelper dh= new DisplayHelper((int)session.getAttribute("id"));%>
                <%= dh.displayAvailableCoursesDropdown()%>
              </select>


          </div>
          <input type="submit" name="rssubmit" value="Students in course"/>
        </form>
      </div>



      <div class="column ">
        <form method="POST" action="<%=request.getContextPath()%>/AdminServlet" target="myIframeAdmin">
          <div class="form-group">
            <label for="studentCourse">Student&nbsp;course&nbsp;load</label>
            <select id="studentCourse" name="courseToDisplay">
                <%= dh.displayReportCourses()%>
            </select>
          </div>
          <input type="submit" name="rcsubmit" value="Courses taken by student"/>
        </form>
      </div>

    </div>



    <div class="row">
      <iframe loading="lazy" name="myIframeAdmin"
              title="Report display window"
              width="100%" src="iframedefault.html">
      </iframe>
    </div>



  </div>


  <footer class="footer">

  </footer>
</div>

</body>

</html>