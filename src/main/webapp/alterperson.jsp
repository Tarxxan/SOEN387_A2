<%--
  Created by IntelliJ IDEA.
  User: christian.henneveld
  Date: 2022-12-04
  Time: 8:21 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Classes.DisplayHelper" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify&nbsp;Person</title>

    <link href="settings/reset.css" rel="stylesheet">
    <link href="settings/styles.css" rel="stylesheet"/>
    <link href="settings/formsstyles.css" rel="stylesheet"/>

</head>
<body>
<div class="page-container">

    <div class="header">
        <h1>Administrator site</h1>
        <h2>Modify&nbsp;Person</h2>

    </div>


    <div class="navbar">
        <a class="right" href="index.jsp">Logout</a>
        <a href="adminsite.jsp">Reports</a>
        <a href="newemployee.jsp">New employee</a>
        <a href="newstudent.jsp">New student</a>
        <a href="newcourse.jsp">New course</a>
        <a href="altercourse.jsp">Modify Course</a>
        <a class="active" href="alteremployee.jsp">Modify Person Info</a>

    </div>


    <div class="content-wrapper w-container">

        <div class="content-section">

            <form action=<%= request.getContextPath() %>/UpdatePersonServlet method="post" name="upform" onsubmit="return validatenpformForm()" target="_self">

                <div class="card ">
                    <div class="row ">
                        <div class="col-75">

                            <%-- Make the drop down menu to pick an employee to modify  --%>
                        <div class="form-group" style="width: 100%">
                            <label for="updropdown" class="center-box">Update Information</label>
                            <select id="updropdown" name="updropdown">
                                <%= DisplayHelper.displayAllPerson()%>

                            </select>
                        </div>

                        </div>
                    </div>

                    <div class="row ">
                        <div class="col-75 ">

                            <div class="form-group">
                                <input class="form-control" name="npname" placeholder="First Name" type="text">
                            </div>

                            <div class="form-group">
                                <input class="form-control" name="nplastname" placeholder="Last Name" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="npdateofbirth" placeholder="Date of Birth" type="date">
                            </div>

                        </div>

                    </div>

                    <div class="row">
                        <div class="col-75">
                            <div class="form-group">
                                <input class="form-control" name="npestreetnumber"
                                       placeholder="Street number"
                                       type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="npstreetname" placeholder="Street name" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="nppostalcode" placeholder="postal Code" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="npapartmentNum" placeholder="Apartment number" type="text">
                            </div>

                        </div>

                        <div class="col-75">
                            <div class="form-group">
                                <input class="form-control" name="npcity" placeholder="City" type="text">
                            </div>
<%--                            <div class="form-group">--%>
<%--                                <input class="form-control" name="npprovince" placeholder="Province" type="text">--%>
<%--                            </div>--%>
                            <div class="form-group">
                                <input class="form-control" name="npcountry" placeholder="Country"
                                       type="text">
                            </div>

                        </div>

                        <div class="col-75">


                            <div class="form-group">
                                <input class="form-control" name="npemail" placeholder="E-mail" type="email">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="npphone" placeholder="Phone Number" type="text">
                            </div>


                        </div>

                        <div class="col-75">
                            <div class="form-group">
                                <input class="form-control" name="nppasssword" placeholder="password" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" name="npconfirmpasssword" placeholder="Confirm password" type="text">
                            </div>
                        </div>
                    </div>

                    <input class="center-box" style="margin-bottom: 20px" name="upsubmit" type="submit" value="save">
                    <br>
                </div>
            </form>
        </div>
        <div class="content-section">
            <div class="content-section">

                <button class="btn center-box " onclick="window.location.href='adminsite.jsp';">
                    Cancel
                </button>

            </div>
            <footer class="footer">

            </footer>
        </div>

    </div>

    <div class="content-section">
        <form action=<%= request.getContextPath() %>/DeletePersonServlet method="post" name="dpdform"
              onsubmit="return validatencformForm()" target="_self">

            <div class="card ">
                <div class="row">

                    <div class="form-group">

                        <label for="dpdropdown" class="center-box">Delete Person</label>
                        <select id="dpdropdown" name="dpdropdown">
                            <%= DisplayHelper.displayAllPerson()%>
                        </select>
                    </div>
                </div>

                <input class="btn center-box" style="margin-bottom: 20px" name="dpdsubmit" type="submit"
                       value="Delete Person">
                <br>
            </div>

        </form>
    </div>
</div>
<script src="settings/updatePerson.js" type="text/javascript"></script>
</body>

</html>