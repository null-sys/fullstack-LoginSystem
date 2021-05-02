//var xhr = new XMLHttpRequest();
//xhr.open('GET', url, false);
//xhr.onload = () => {};
window.onload = function () {
  var mb = document.getElementById('signupBtn');
  mb.addEventListener('click', signup);
};

function signup() {
  const first = document.getElementById('firstName').value;
  const last = document.getElementById('lastName').value;
  const email = document.getElementById('InputEmail1').value;
  const password = document.getElementById('InputPassword1').value;
  console.log(first);
  console.log(last);
  console.log(email);
  console.log(password);
}

//   async function basiclogin(email, password) {
//     const response = await zlFetch.post(loginEndpoint, {
//       auth: {
//         username: email,
//         password: password,
//       },
//       body: {
//         /*...*/
//       },
//     });
//     const { token } = response.body;

//     localStorage.setItem('token', token);
//   }

// document.getElementById('userDetail').addEventListener(
//   'click',
//   function () {
//     console.log('Button clicked');
//     //xhr.send(data);
//   },
//   false
// );
