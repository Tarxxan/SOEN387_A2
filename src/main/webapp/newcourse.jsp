
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
        <a href="alterCourse.jsp">Modify course</a>

    </div>


    <div class="content-wrapper w-container">

        <div class="content-section">

        <form action=<%= request.getContextPath() %>/NewCourseServlet method="post" name="ncform" onsubmit="return validatencformForm()" target="_self">

            <div class="card">
                <div class="row ">
                    <div class="col-75 ">

                    <div class="form-group">
                        <label for="courseCode" class="center-box">Add Course </label><br>
                        <input class="form-control"
                               id= "courseCode" name="courseCode" placeholder="Course code"  type="text">
                    </div>

                    <div class="form-group">
                        <input class="form-control" name="courseTitle" placeholder="Course Title"  type="text">
                    </div>

                        <div class="form-group">
                            <input class="form-control" name="instructor" placeholder="Instructor"  type="text">
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-75">

                    <div class="form-group">
                        <input class="form-control" name="semester" placeholder="Semester"  type="text">
                    </div>

                        <div class="form-group">
                            <input class="form-control" name="room" placeholder="Room"  type="text">
                        </div>
                    </div>


                    <div class="col-75">
                    <div class="form-group">
                        <input class="form-control" name="days" placeholder="Days"  type="text" title="ex Mon-Fri" >
                    </div>

                    <div class="form-group">
                        <input class="form-control" name="time" placeholder="Time"
                               type="text" title="ex 12:00 to 14:00">
                    </div>
                    </div>
                    <div class="col-75">
                        <div class="form-group">
                            <input class="form-control" name="startDate" placeholder="Start Date" type="date">
                        </div>
                        <div class="form-group">
                            <input class="form-control" name="endDate" placeholder="End date" type="date">
                        </div>
                    </div>
                </div>


                    <input class="center-box" style="margin-bottom: 20px" name="ncsubmit" type="submit" value="save">
                <br>
                </div>

        </form>
    </div>


        <div class="content-section">

            <button class="btn center-box" style="margin-outside: 20px" onclick="window.location.href='adminsite.jsp';">
                Cancel
            </button>

        </div>
        <footer class="footer">

        </footer>
    </div>

</div>
<script src="settings/newcourse.js" type="text/javascript"></script>
</body>
</html>