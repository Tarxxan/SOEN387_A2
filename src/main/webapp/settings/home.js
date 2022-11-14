

let passwordpattern = new RegExp("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");

function validatehsformForm() {


    let id = document.forms["hsform"]["studentid"].value;
    let Password = document.forms["hsform"]["spassword"].value;

    if (id === "") {
        alert("ID must be filled out");
        return false;
    }

    if (Password === "") {
        alert("Password must be filled out");
        return false;
    }
    let match= Password.match(passwordpattern);
    if (!match) {
    alert("Invalid Password combination try again");
    return false;
    }

}

function validateheformForm() {

    let id = document.forms["heform"]["employeeid"].value;
    let Password = document.forms["heform"]["epassword"].value;

    if (id === "") {
            alert("ID must be filled out");

        return false;
    }

    if (Password === "") {
        alert("Password must be filled out");
        return false;
    }
    let match= Password.match(passwordpattern);
    if (!match) {
        alert("Invalid ID/Password combination try again");
        return false;
    }

}