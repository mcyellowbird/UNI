// Q4-E
var activeUser = JSON.parse(window.localStorage.getItem("storedUser")); // Getting currently signed in user

// Creating a list of users for testing
var listOfUsers = new Array();
u1 = {
    username: 'abc',
    password: btoa('abc@123')
};
u2 = {
    username: 'bcd',
    password: btoa('bcd@123')
};

listOfUsers.push(u1);
listOfUsers.push(u2);

window.localStorage.setItem("listOfUsers", JSON.stringify(listOfUsers));
//

// When DOM is loaded, show login form if there's no user signed in //Q4-B
document.addEventListener("DOMContentLoaded", () => {
    if (activeUser == null) {
        document.getElementById("carForm").style.display = "none";
        document.getElementById("loginForm").style.display = "block";
    } else {
        document.getElementById("loginForm").style.display = "none";
        document.getElementById("carForm").style.display = "block";
        document.getElementById("logoutButton").style.display = "block";
    }
})

function validateLogin() {
    var form = document.getElementById("loginForm");
    var formArray = new FormData(form);
    var loginValidated = false;

    // Loop through each user and see if the inputted Username and Password match
    for (var i = 0; i < listOfUsers.length; i++) {
        if (listOfUsers[i].username == formArray.get("username")) {
            if (atob(listOfUsers[i].password) == formArray.get("password")) {
                // Set the active user to the matched user in the list
                activeUser = listOfUsers[i];
                window.localStorage.setItem("storedUser", JSON.stringify(activeUser));
                loginValidated = true;
                break;
            }
        }
    }

    if (loginValidated) { //Q4-B
        document.getElementById("carForm").style.display = "block";
        document.getElementById("loginForm").style.display = "none";
        document.getElementById("logoutButton").style.display = "block";
    }
    else{
        alert("Username or Password is invalid")
    }
}

//Q4-C
function checkPassword(password, verifyPassword) {
    var errorMessage = "";
    var validated = false;
    var lengthValid = false;
    var capitalValid = false;
    var numberValid = false;
    var passwordVerified;

    // Check password length
    if (password.length >= 8){
        lengthValid = true;
    }
    else{
        errorMessage += "Password must be 8 or more characters in length\n";
    }

    // Check if password contains a capital letter where / is the start and end of the regular expression,
    // [ ] match any set of characters, and A-Z specifies all letters from A to Z in uppercase
    if (Boolean(password.match(/[A-Z]/))){
        capitalValid = true;
    }
    else{
        errorMessage += "Password must contain a capital letter\n";
    }

    // Check if password contains a number
    if (Boolean(password.match(/\d/))){
        numberValid = true;
    }
    else{
        errorMessage += "Password must contain a number\n";
    }

    // Check if passwords match
    if (password === verifyPassword){
        passwordVerified = true;
        document.getElementById("verifyPassword").classList.remove("inputError");
        document.getElementById("verifyPassword").classList.add("inputValid");
    }
    else{
        errorMessage += "Passwords do not match\n";
        document.getElementById("verifyPassword").classList.add("inputError");
    }

    if (lengthValid && capitalValid && numberValid){
        validated = true;
    }

    if (!validated){
        document.getElementById("signupError").textContent = errorMessage;
        document.getElementById("signupError").style.display = "block";
        document.getElementById("signupPassword").classList.add("inputError");
    }
    else{
        document.getElementById("signupError").textContent = "";
        document.getElementById("signupError").style.display = "none";
        document.getElementById("signupPassword").classList.remove("inputError");
    }

    return validated;
}

function validateSignup() {
    var form = document.getElementById("signupForm");
    var formArray = new FormData(form);
    var canSignup = false;

    // Loop through each user and see if the inputted Username is already taken
    for (var i = 0; i < listOfUsers.length; i++) {
        if (listOfUsers[i].username != formArray.get("username")) {
            canSignup = true;
        } else {
            canSignup = false;
        }
    }
    // Check if there's a username and password inputted, and if the username is not taken
    if (checkPassword(formArray.get("password"), formArray.get("verifyPassword"))){
        var newUser = {
            username: formArray.get("username"),
            password: btoa(formArray.get("password"))
        };

        // Add new user to the list of users
        listOfUsers.push(newUser);
        window.localStorage.setItem("listOfUsers", JSON.stringify(listOfUsers));
        showLogin();
    }
}

function showSignup() { //Q4-B
    document.getElementById("loginForm").style.display = "none";
    document.getElementById("signupForm").style.display = "block";
}

function showLogin() { //Q4-B
    document.getElementById("loginForm").style.display = "block";
    document.getElementById("signupForm").style.display = "none";
}

function logout() {
    activeUser = null;
    window.localStorage.clear("storedUser");
}