<link href="settings/styles.css" rel="stylesheet"/>

<?php
include "database.php";

session_start();
error_reporting(E_ALL ^ E_NOTICE);

$bl = new BusinessLogic();

if (isset($_POST['slogin']) || isset($_POST['elogin'])) {
    $bl->checkLoginCredentials();
}

if (isset($_POST['nssubmit'])) {
    $bl->addNewStudent();
}

if (isset($_POST['nesubmit'])) {
    $bl->addNewEmployee();
}

if (isset($_POST['ncsubmit'])) {
    $bl->adminAddCourse();
}

if (isset($_POST['sfsubmit'])) {
    $bl->studentRegisterCourse();
}

if (isset($_POST['sdsubmit'])) {
    $bl->studentDropCourse();
}

if(isset($_POST['rssubmit'])||isset($_POST['rcsubmit']) ){
    $bl->displayreports();
}

class BusinessLogic
{
    public $student;
    public $db;

    public function __construct()
    {
        $this->db = $this->dbInit();
        $this->student = true;
    }

    public function dbInit()
    {
        $db = new database();
        return $db->db_connect();

    }

    public function checkLoginCredentials()
    {
        extract($_POST);


        // Checks the database for a matching ID in the corresponding tables.
        if ($studentid) {
            $stmt = $this->db->prepare("Select studentID FROM railway.student WHERE studentID=?");
            $stmt->bindParam(1, $studentid);
            $stmt->execute();
            $_SESSION['id'] = $studentid;
        } else {
            $stmt = $this->db->prepare("Select employeeID FROM railway.employee WHERE employeeID=?");
            $stmt->bindParam(1, $employeeid);
            $stmt->execute();
            $this->student = false;
            $_SESSION['id'] = $employeeid;
        }

        // Returns an associative array or false. Hence the !result== no results found in the database
        $result = $stmt->fetch(PDO::FETCH_ASSOC);

        //Redirection checks for both students and admins
        if (!$result && $this->student) {
            echo '<script type="text/javascript">
               alert("Invalid ID/Password combination try again");
               window.location.href="home.html"
                          </script>';

        } elseif (!$result && !($this->bl->student) && isset($employeeid)) {
            echo '<script type="text/javascript">
            window.alert("Contact HR to make an admin account");
            window.location.href="home.html"</script>';
        } else {
            if ($this->student)

                 header("Location: registrationform.php");
            else {
                header("Location: adminsite.php");
            }
        }
    }

    public function addNewEmployee()
    {

        extract($_POST);

        //Checks the db if the given id is being used
        $stmt = $this->db->prepare("SELECT person.personalID FROM railway.person 
                                            LEFT JOIN railway.employee ON employee.employeeID=person.personalID
                                            LEFT JOIN railway.student ON person.personalID=student.studentID
                                            WHERE employee.employeeID=? OR student.studentID =?");
        $stmt->bindParam(1, $nemployeeid);
        $stmt->bindParam(2, $nemployeeid);
        $stmt->execute();

        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);


        if ($result) {
            echo '<script type="text/javascript">
                window.alert("ID is already taken,please try again with a different ID.");
                window.location.href="newemployee.html"
                </script>';
        }

        // Both table INSERTS since they are all connected
        $sql = "INSERT INTO railway.person(personalID,firstName,lastName,email,phoneNumber,dateOfBirth,streetName,streetNumber,city,country,postalCode)
        VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        $stmt = $this->db->prepare($sql);
        $bind = array($nemployeeid, $nename, $nelastname, $neemail, $nephone, $nedateofbirth, $nestreetname, $neestreetnumber, $necity, $necountry, $nepostalcode);
        $stmt = $this->bindAll($stmt, $bind);
        $stmt->execute();

        $sql = "INSERT INTO railway.employee(employeeID,personalID)VALUES(?,?)";
        $stmt = $this->db->prepare($sql);
        $bind = array($nemployeeid, $nemployeeid);
        $stmt = $this->bindALl($stmt, $bind);
        $stmt->execute();

    }

    public function bindALl($stmt, $arr)
    {
        for ($i = 0; $i < count($arr); $i++) {
            $stmt->bindParam($i + 1, $arr[$i]);
        }
        return $stmt;
    }

    public function addNewStudent()
    {

        extract($_POST);

        //Checks the db if the given id is being used
        $stmt = $this->db->prepare("SELECT person.personalID FROM railway.person 
                                            LEFT JOIN railway.employee ON employee.employeeID=person.personalID
                                            LEFT JOIN railway.student ON person.personalID=student.studentID
                                            WHERE employee.employeeID=? OR student.studentID =?");
        $stmt->bindParam(1, $nstudentid);
        $stmt->bindParam(2, $nstudentid);
        $stmt->execute();

        $result = $stmt->fetchAll(PDO::FETCH_ASSOC);

        if ($result) {
            echo '<script type="text/javascript">
                window.alert("ID is already taken,please try again with a different ID.");
                window.location.href="newstudent.html"
                </script>';
        }

        $sql = "INSERT INTO railway.person(personalID,firstName,lastName,email,phoneNumber,dateOfBirth,streetName,streetNumber,city,country,postalCode)
        VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        $stmt = $this->db->prepare($sql);
        $bind = array($nstudentid, $nsname, $nslastname, $nsemail, $nphone, $nsdateofbirth, $nsstreetname, $nsestreetnumber, $nscity, $nscountry, $nspostalcode);
        $stmt = $this->bindAll($stmt, $bind);
        $stmt->execute();

        $sql = "INSERT INTO railway.student(studentID,personalID)VALUES(?,?)";
        $stmt = $this->db->prepare($sql);
        $bind = array($nstudentid, $nstudentid);
        $stmt = $this->bindALl($stmt, $bind);
        $stmt->execute();

        // REDIRECT PAGE TO CREATE ADD COURSES( CAROLINA)
        //header("location: reports.php");
    }

    public function adminAddCourse()
    {

        extract($_POST);
        extract($_SESSION);

        $comp = strcmp($_POST['startDate'], $_POST['endDate']);

        if ($comp == 0 || $comp > 0) {
            echo '<script type="text/javascript">
                window.alert("Start and End dates are incorrect, please verify before re-submitting");
                window.location.href="newcourse.html"
                $_POST=null;
                </script>';
        }

        $sql = "INSERT INTO railway.courses(courseCode,title,semester,days,time,instructor,classroom,startDate,endDate,createdBy)
        VALUES(?,?,?,?,?,?,?,?,?,?)";
        $stmt = $this->db->prepare($sql);
        $binds = array($courseCode, $courseTitle, $semester, $days, $time, $instructor, $room, $startDate, $endDate, $id);
        $stmt = $this->bindAll($stmt, $binds);
        try {
            $stmt->execute();
        } catch (PDOException $e) {
            echo '<script type="text/javascript">
                window.alert("Course code already exist, try another one");
                window.location.href="newcourse.html"
                </script>';
        }
        //header("location: newcourse.html");

    }

    public function displayreports()
    {
        extract($_POST);

        // Displays all students taking a certain course
        if (isset($rssubmit)) {
            $sql = "SELECT studentID, CONCAT(person.firstName,' ',person.lastName) as name ,title FROM railway.enrollment 
                    INNER JOIN railway.person ON person.personalID=enrollment.studentID
                    INNER JOIN railway.courses ON enrollment.courseCode=courses.courseCode WHERE enrollment.courseCode=?";
            $stmt = $this->db->prepare($sql);
            $stmt->bindParam(1, $courseToDisplay);
            $stmt->execute();
            $arr=$stmt->fetchAll();
            $this->displayStudentsInCourse($arr,$courseToDisplay);

        }
        else{
            $this->displayCoursesTable($studentCourse);
        }

    }

    // Change to course params when we get the db

    public function studentRegisterCourse()
    {
        extract($_POST);
        extract($_SESSION);

        $sql = "SELECT courseCode FROM railway.enrollment WHERE studentID=?";
        $stmt = $this->db->prepare($sql);
        $binds=array($id);
        $stmt=$this->bindALl($stmt, $binds);
        $stmt->execute();
        $courses = $stmt->fetchAll();

        $sql.=" and courseCode=?";
        $stmt = $this->db->prepare($sql);
        $binds[] = $addCourse;
        $stmt=$this->bindALl($stmt, $binds);
        $stmt->execute();
        $inCourse = $stmt->fetchAll();

        // CHECK IF COURSE ALREADY BELONGS TO THAT STUDENT
        if (sizeof($courses) == 5 || sizeof($inCourse) > 0) {
            $_POST = null;
            echo '<script type="text/javascript">
                window.alert("Course cannot be added. You are already in 5 courses or are registered in this course");
                window.location.href="registrationform.php"
                </script>';
            return;
        }

        $sql = "SELECT courses.courseCode FROM railway.courses
                WHERE courses.courseCode =? and CURRENT_DATE < DATE_ADD(courses.startDate, INTERVAL 1 WEEK)";
        $stmt = $this->db->prepare($sql);
        $stmt->bindParam(1,$addCourse);
        try{
            $stmt->execute();
        }
       catch(PDOException $e){
            echo $e;
       }
       $courses = $stmt->fetchAll();
        if(sizeof($courses)>0){
            $sql = "INSERT INTO railway.enrollment(enrollID,studentID,courseCode)VALUES(?,?,?)";
            $stmt = $this->db->prepare($sql);
            $ranEnrollID = rand(0, 99999999);
            $binds = array($ranEnrollID, $id, $addCourse);
            $this->bindALl($stmt, $binds);
            $stmt->execute();
        }

        else {
            echo '<script type="text/javascript">
                window.alert("Course Add date has passed");
                window.location.href="registrationform.php"
                </script>';
        }
    }

    public function studentDropCourse()
    {
        extract($_POST);
        extract($_SESSION);

        $sql="SELECT courses.courseCode from railway.enrollment 
                inner join railway.courses on courses.courseCode=enrollment.courseCode  
                where endDate > CURRENT_DATE AND courses.courseCode=?";

        $stmt = $this->db->prepare($sql);
        $stmt->bindParam(1, $dropCourse);
        try{
            $stmt->execute();
        }catch(PDOException $e){
            echo $e;

        }
        $result=$stmt->fetchAll();

        if(sizeof($result)!=0){
            $sql = "DELETE FROM railway.enrollment WHERE courseCode=? AND studentID=?";
            $stmt = $this->db->prepare($sql);
            $stmt->bindParam(1, $dropCourse);
            $stmt->bindParam(2, $id);
            $result=$stmt->execute();
            header("location: registrationform.php");
        }
        else {
            echo '<script type="text/javascript">
                window.alert("Deadline to drop course has passed");
                window.location.href="registrationform.php"
                $_POST=null;
                </script>';
            return;
        }
    }

    public function displayCoursesTable($adminReq=false)
    {
        extract($_SESSION);

        $sql = "SELECT courses.courseCode,title, instructor ,startDate ,endDate  FROM railway.courses 
                    INNER JOIN railway.enrollment ON enrollment.courseCode= railway.courses.courseCode WHERE enrollment.studentID=?";
        $stmt = $this->db->prepare($sql);
        if($adminReq){
            $stmt->bindParam(1, $adminReq);
        }
        else {
            $stmt->bindParam(1, $id);
        }

        $stmt->execute();
        $result = $stmt->fetchAll();

        if (sizeof($result) > 0) {
            echo "<table >";
            echo "<tr>";
            echo "<th>Course Code</th>";
            echo "<th>Title</th>";
            echo "<th>Instructor</th>";
            echo "<th>Start Date</th>";
            echo "<th>End Date</th>";
            echo "</tr>";

            foreach ($result as $row) {
                echo "<tr>";
                echo "<td>" . $row['courseCode'] . "</td>";
                echo "<td>" . $row['title'] . "</td>";
                echo "<td>" . $row['instructor'] . "</td>";
                echo "<td>" . $row['startDate'] . "</td>";
                echo "<td>" . $row['endDate'] . "</td>";
                echo "</tr>";
            }
            echo "</table>";
        }
    }

    public function displayCoursesDropdown()
    {
        $sql = "SELECT courseCode as 'Course Code' FROM railway.courses";
        $stmt = $this->db->query($sql);

        while ($row = $stmt->fetch()) {
            echo "<option value='" . $row['Course Code'] . "'>" . $row['Course Code'] . "</option>";
        }
    }

    public function displayStudentDropdown()
    {
        $sql = "SELECT DISTINCT studentID FROM railway.enrollment";
        $stmt = $this->db->query($sql);

        var_dump($stmt);
        while ($row = $stmt->fetch()) {
            echo $row['studentID'];
            echo "<option value='" . $row['studentID'] . "'>" . $row['studentID'] . "</option>";
        }
    }

    public function courseById()
    {
        extract($_SESSION);
        $sql = "SELECT courseCode FROM railway.enrollment WHERE studentID=?";
        $stmt = $this->db->prepare($sql);
        $stmt->bindParam(1, $id);
        $stmt->execute();
        while ($row = $stmt->fetch()) {
            echo "<option value='" . $row['courseCode'] . "'>" . $row['courseCode'] . "</option>";
        }
    }

    public function displayStudentsInCourse($arr, $courseToDisplay)
    {
        echo "<table >";
        echo "<tr>";
        echo "<th>Course</th>";
        echo "<th>Course Title</th>";
        echo "<th>Student ID</th>";
        echo "<th>Student Name</th>";
        echo "</tr>";
        if (sizeof($arr) > 0) {
            foreach ($arr as $row) {
                echo "<tr>";
                echo "<td>" . $courseToDisplay. "</td>";
                echo "<td>" . $row['title'] . "</td>";
                echo "<td>" . $row['studentID'] . "</td>";
                echo "<td>" . $row['name'] . "</td>";
                echo "</tr>";
            }
        }
        echo "</table>";
    }

    public function createID(){
        extract($_SESSION);
        $sql = "SELECT CONCAT(person.firstName,' ',person.lastName) as name FROM railway.person  WHERE personalID=?";
        $stmt = $this->db->prepare($sql);
        $stmt->bindParam(1, $id);
        $stmt->execute();
        $result=$stmt->fetch();
        echo "<h2>".$result['name']."</h2>";
    }
}