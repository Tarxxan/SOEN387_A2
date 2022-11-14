
let passwordpattern = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
let postalcodepattern=/^[A-Z][1-9][a-zA-Z]\s[1-9][A-Z][1-9]$/g;
let namespattern=/[a-zA-Z\s]+(\.)?[a-zA-Z]+/g;
let phonepattern=/^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$/g
let emailpattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
let datepattern = /^\d{4}-\d{2}-\d{2}$/

function validatensformForm() {


    let name = document.forms ["nsform"] ["nsname"].value.trim();
    let lastname = document.forms ["nsform"] ["nslastname"].value.trim();
    let streetnumber = document.forms ["nsform"] ["nsestreetnumber"].value.trim();
    let streetname = document.forms ["nsform"] ["nsstreetname"].value.trim();
    let city = document.forms ["nsform"] ["nscity"].value.trim();
    let province = document.forms ["nsform"] ["nsprovince"].value.trim();
    let country = document.forms ["nsform"] ["nscountry"].value.trim();
    let postalcode = document.forms ["nsform"] ["nspostalcode"].value.trim();
    let email = document.forms ["nsform"] ["nsemail"].value.trim();
    let phone = document.forms ["nsform"] ["nsphone"].value.trim();
    let dateofbirth = document.forms ["nsform"] ["nsdateofbirth"].value.trim();
    let password = document.forms ["nsform"] ["nspassword"].value.trim();
    let confirmpassword = document.forms ["nsform"] ["nsconfirm-password"].value.trim();


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