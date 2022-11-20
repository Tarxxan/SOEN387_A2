
let passwordpattern = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
let postalcodepattern=/^[A-Z][1-9][a-zA-Z]\s[1-9][A-Z][1-9]$/g;
let namespattern=/[a-zA-Z\s]+(\.)?[a-zA-Z]+/g;
let phonepattern=/^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g
let emailpattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
let datepattern = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/

function validateneformForm() {

    let name = document.forms ["neform"] ["nename"].value.trim();
    let lastname = document.forms ["neform"] ["nelastname"].value.trim();
    let streetnumber = document.forms ["neform"] ["neestreetnumber"].value.trim();
    let streetname = document.forms ["neform"] ["nestreetname"].value.trim();
    let city = document.forms ["neform"] ["necity"].value.trim();
    let province = document.forms ["neform"] ["neprovince"].value.trim();
    let country = document.forms ["neform"] ["necountry"].value.trim();
    let postalcode = document.forms ["neform"] ["nepostalcode"].value.trim();
    let email = document.forms ["neform"] ["neemail"].value.trim();
    let phone = document.forms ["neform"] ["nephone"].value.trim();
    let dateofbirth = document.forms ["neform"] ["nedateofbirth"].value.trim();
    let password = document.forms ["neform"] ["nepassword"].value.trim();
    let confirmpassword = document.forms ["neform"] ["neconfirmpassword"].value.trim();



    if (name === "") {
        alert("Name must be filled out");
        return false;
    }
    if (lastname === "") {
        alert("Last name must be filled out");
        return false;
    }
    if( streetnumber === "") {
        alert("street number must be filled out");
        return false;
    }
    if( streetname === "") {
        alert ("street name must be filled out")
        return false;
    }
    if( city === "") {
        alert ("city must be filled out");
        return false;
    }
    if( province === "") {
        alert ("province must be filled out");
        return false;
    }
    if( country === "") {
        alert ("Country must be filled out");
        return false;
    }
    if( postalcode === "") {
        alert ("postal code must be filled out");
        return false;
    }
    if( email === "") {
        alert ("email must be filled out");
        return false;
    }
    if( phone === "") {
        alert ("phone number must be filled out");
        return false;
    }
    if( dateofbirth === "") {
        alert ("date of birth must be filled out");
        return false;
    }
    if( password === "") {
        alert ("password must be filled out");
        return false;
    }
    if( confirmpassword === "") {
        alert ("Password confirmation must be filled out");
        return false;}


    if(!email.match(emailpattern)){
        alert("This is not an email address try again");
        return false;
    }
    if(!phone.match(phonepattern)){
        alert("wrong phone number, try again ");
        return false;
    }
    if(!name.match(namespattern)  ){
        alert( "Invalid Name, try again");
        return false;
    }
    if(!lastname.match(namespattern)  ){
        alert( "Invalid Last Name, try again");
        return false;
    }
    if(!streetnumber.match( /^\d+$/) ){
        alert("Invalid street number, try again");
        return false;
    }
    if(!streetname.match( namespattern)   ){
        alert("Invalid street name, try again");
        return false;
    }
    if(!city.match( namespattern )){
        alert( "Invalid city name, try again");
        return false;
    }
    if(!province.match(namespattern)){
        alert( "Invalid province name, try again" + province);
        return false;
    }
    if(!postalcode.match(postalcodepattern )){
        alert("Invalid postal code, try again");
        return false;
    }

    if(!dateofbirth.match(datepattern)){
        alert( "wrong dob, try again ");
        return false;
    }

    let match = password.match(passwordpattern);
    if (!match) {
        alert("Invalid Password complexity, try again");
        return false;
    }

    if(confirmpassword!==password){
        alert("Password confirmation does not match the password chosen try again");
        return false;
    }
}