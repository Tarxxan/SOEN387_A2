<%@ page import="Classes.DisplayHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
  <meta charset="utf-8">
  <link href="settings/reset.css" rel="stylesheet">
  <link href="settings/styles.css" rel="stylesheet"/>
  <link href="settings/formsstyles.css" rel="stylesheet"/>
  <title>Course&nbsp;enrollment</title>
</head>
<body>
<div class="page-container">
  <div class="header">
    <h1>Course enrollment</h1>
<%--    <h2>  <?php echo $b->createID();?></h2>--%>
  </div>

  <div class="navbar">
    <a class="right" href="home.html" >Logout</a>
    <a class="active" href="registrationform.php">Classes.Enrollment</a>

  </div>

  <div class="content-wrapper w-container">

    <div class="row card">


      <div class="column">
        <form method="POST" action="/AddDropCourseServlet" target="_self">
          <div class="form-group">
            <label for="addCourse" class="center-box">Enroll</label>
            <select id="addCourse" name="addCourse">
            <% DisplayHelper dh= new DisplayHelper((int)session.getAttribute("id"));%>
            <%= dh.displayCoursesDropdown()%>
            </select>
          </div>

          <input type="submit" name="sfsubmit" value="Add Course"/>
        </form>

      </div>
      <div class="column">
        <form method="POST" action="/AddDropCourseServlet" target="_self">
          <div class="form-group">
            <label for="dropCourse" class="center-box">Drop</label>
            <select id="dropCourse" name="dropCourse">
              <%= dh.displayDropableCourses()%>
            </select>
          </div>
          <input type="submit" name="sdsubmit" value="Drop Classes.Courses"/>
        </form>
      </div>
    </div>
    <div>
    <%= dh.displayCourses()%>
    </div>

  </div>

  <footer class="footer">


  </footer>
</div>
</body>


</html>