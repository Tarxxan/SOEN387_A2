let datepattern = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/
let namespattern=/[a-zA-Z\s]+(\.)?[a-zA-Z]+/g;
let timepattern =/(?:[01]\d|2[0123]):(?:[012345]\d)\sto\s(?:[01]\d|2[0123]):(?:[012345]\d)/


function validatencformForm() {
    let courseCode = document.forms["ucform"]["ucdropdown"].value;
    let courseTitle = document.forms["ucform"]["courseTitle"].value;
    let semester = document.forms["ucform"]["semester"].value;
    let days = document.forms["ucform"]["days"].value;
    let time = document.forms["ucform"]["time"].value;
    let startDate = document.forms["ucform"]["startDate"].value;
    let endDate = document.forms["ucform"]["endDate"].value;
    let instructor = document.forms["ucform"]["instructor"].value;
    let room = document.forms["ucform"]["room"].value;


    if(courseCode === "") {
        alert("Course code cannot be blank, try again");
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
        alert(" Not a name, try again");
        return false;
    }

}