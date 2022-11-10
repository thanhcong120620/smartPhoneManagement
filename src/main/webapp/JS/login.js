const username = document.getElementById('username');
const password = document.getElementById('password');
const password2 = document.getElementById('password2');
const fullName = document.getElementById('fullName');
const age = document.getElementById('age');
const email = document.getElementById('email');
const phone = document.getElementById('phone');
const form  = document.getElementById('form');
const errorUser = document.getElementById('errorUser');
const errorPassword = document.getElementById('errorPassword');
const errorPassword2 = document.getElementById('errorPassword2');
const errorEmail = document.getElementById('errorEmail');
const errorFullName = document.getElementById('errorFullName');
const errorAge = document.getElementById('errorAge');   
const errorPhone = document.getElementById('errorPhone');   


form.addEventListener('submit', (e) => {
    let messages1 = [];
    let messages2 = [];
    let messages3 = [];
    let messagesN = [];
    let messagesA = [];
    let messagesP = [];
    let messagesE = [];
    if(username.value === "" || username.value == null){
        messages1.push("Please enter your username again");
    }
    if(password.value === "" || password.value == null){
        messages2.push("Please enter your password again");
    }
    if(password2.value === "" || password2.value == null || password2.value != password.value){
        messages3.push("Password not match");
    }
    if(fullName.value === "" || fullName.value == null){
        messagesN.push("Please enter your name again");
    }
    if(age.value === "" || age.value == null){
        messagesA.push("Please enter your age again");
    }
    if(phone.value === "" || phone.value == null){
        messagesP.push("Please enter your phone number again");
    }
    if(email.value === "" || email.value == null){
        messagesE.push("Please enter your email again");
    }

    if(messages1.length > 0 || messages2.length > 0 || messages3.length > 0 || messagesN >0 || messagesA >0
        || messagesP >0|| messagesE >0){
        e.preventDefault();
        errorUser.innerText = messages1.join(', ');
        errorPassword.innerText = messages2.join(', ');;
        errorPassword2.innerText = messages3.join(', ');;
        errorAge.innerText = messagesA.join(', ');
        errorPhone.innerText = messagesP.join(', ');
        errorEmail.innerText = messagesE.join(', ');
        errorFullName.innerText = messagesN.join(', ');
    }

});
