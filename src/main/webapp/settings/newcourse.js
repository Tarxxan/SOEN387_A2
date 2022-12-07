let datepattern = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/
let namespattern=/[a-zA-Z\s]+(\.)?[a-zA-Z]+/g;
let coursecodepattern=/^[A-Z]{3,4}\s[1-9]{3,4}$/
let timepattern =/(?:[01]\d|2[0123]):(?:[012345]\d)\sto\s(?:[01]\d|2[0123]):(?:[012345]\d)/
let roompattern = /\w$/

function validatencformForm() {
    let courseCode = document.forms["ncform"]["courseCode"].value;
    let courseTitle = document.forms["ncform"]["courseTitle"].value;
    let semester = document.forms["ncform"]["semester"].value;
    let days = document.forms["ncform"]["days"].value;
    let time = document.forms["ncform"]["time"].value;
    let startDate = document.forms["ncform"]["startDate"].value;
    let endDate = document.forms["ncform"]["endDate"].value;
    let instructor = document.forms["ncform"]["instructor"].value;
    let room = document.forms["ncform"]["room"].value;


    if(courseCode === "") {
        alert("Course code cannot be blank, try again");
        return false;
    }
    if(courseTitle === "") {
        alert("Course title cannot be blank, , try again");
        return false;
    }
    if(semester === "") {
        alert("Semester cannot be blank, , try again");
        return false;
    }
    if(days === "") {
        alert("Day cannot be blank, , try again");
        return false;
    }
    if(time === "") {
        alert("Time cannot be blank, , try again");
        return false;
    }
    if(startDate === "") {
        alert("Start date cannot be blank, , try again");
        return false;
    }
    if(endDate === "") {
        alert("End date cannot be blank, , try again");
        return false;
    }
    if(instructor === "") {
        alert("Instructor cannot be blank, , try again");
        return false;
    }
    if(room  === "") {alert("Room cannot be blank, try again");
        return false;
    }

    if(!courseCode.match(coursecodepattern)) {
        alert("Not a course code, try again");
        return false;
    }
    if(!courseTitle.match(namespattern)) {
        alert("Not a course title, try again");
        return false;
    }


    if(!time.match(timepattern)) {
        alert("Wrong time format, try again");
        return false;
    }
    if(!startDate.match(datepattern)) {
        alert("Not a date, try again");
        return false;
    }

    if(startDate>=endDate){
        alert("Verify your dates, try again");
        return false;

    }
    if(!endDate.match(datepattern)) {
        alert("Not a date, try again");
        return false;
    }
    if(!instructor.match(namespattern)) {
        alert("Not a name, try again");
        return false;
    }
    if(!room.match(roompattern)) {alert("Not a room, try again");
        return false;
    }

}