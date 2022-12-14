<%@ page import="Classes.DisplayHelper" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify&nbsp;courses</title>

    <link href="settings/reset.css" rel="stylesheet">
    <link href="settings/styles.css" rel="stylesheet"/>
    <link href="settings/formsstyles.css" rel="stylesheet"/>

</head>
<body>
<div class="page-container">

    <div class="header">
        <h1>Administrator site</h1>
        <h2>Modify&nbsp;Course</h2>

    </div>


    <div class="navbar">
        <a class="right" href="index.jsp">Logout</a>
        <a href="adminsite.jsp">Reports</a>
        <a href="newemployee.jsp">New employee</a>
        <a href="newstudent.jsp">New student</a>
        <a href="newcourse.jsp">New course</a>
        <a class="active" href="altercourse.jsp">Modify course</a>
        <a href="alterperson.jsp">Modify Person Info</a>

    </div>


    <div class="content-wrapper w-container">

        <div class="content-section">

            <form action=<%= request.getContextPath() %>/UpdateCoursesServlet method="post" name="ucform" onsubmit="return validatencformForm()" target="_self">

                <div class="card ">
                    <div class="row ">

                        <div class="form-group" style="width: 100%">
                            <label for="ucdropdown" class="center-box">Update Course</label>
                            <select id="ucdropdown" name="ucdropdown">
                                <%= DisplayHelper.displayAllCourses()%>
<%--                                <%= session = request.getSession()%>--%>
<%--                               <% session.setAttribute("Hashmap",DisplayHelper.idMap);%>--%>
                            </select>
                        </div>


                    </div>

                    <div class="row ">
                        <div class="col-75 ">

                            <div class="form-group">
                                <input class="form-control" name="courseTitle" placeholder="Course Title" type="text">
                            </div>

                            <div class="form-group">
                                <input class="form-control" name="instructor" placeholder="Instructor" type="text">
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-75">

                            <div class="form-group">
                                <input class="form-control" name="semester" placeholder="Semester" type="text">
                            </div>

                            <div class="form-group">
                                <input class="form-control" name="room" placeholder="Room" type="text">
                            </div>
                        </div>

                        <div class="col-75">
                            <div class="form-group">
                                <input class="form-control" name="days" placeholder="Days" type="text"
                                       title="ex Mon-Fri">
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

                    <input class="center-box" style="margin-bottom: 20px" name="ucsubmit" type="submit" value="save">
                    <br>
                </div>
            </form>
        </div>
        <div class="content-section">
            <form action=<%= request.getContextPath() %>/DeleteCourseServlet method="post" name="dcdform"
                  onsubmit="return validatencformForm()" target="_self">

                <div class="card ">
                    <div class="row">

                        <div class="form-group">

                            <label for="dcdropdown" class="center-box ">Delete Course</label>
                            <select id="dcdropdown" name="dcdropdown">
                                <%= DisplayHelper.displayAllCourses()%>

<%--                                <%=session.setAttribute("Hashmap", DisplayHelper.idMap)%>--%>

                            </select>
                        </div>
                    </div>
                    <div class="content-section">

                        <button class="btn center-box" name="dcdsubmit" type="submit">Delete Course</button>
                    </div>
                </div>

            </form>
        </div>

        <div class="content-section">

            <button class="btn center-box" onclick="window.location.href='adminsite.jsp';">
                Cancel
            </button>

        </div>
        <footer class="footer">

        </footer>
    </div>

</div>
<script src="settings/altercourse.js" type="text/javascript"></script>
</body>

</html>