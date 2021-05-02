//var xhr = new XMLHttpRequest();
//xhr.open('GET', url, false);
//xhr.onload = () => {};
window.onload = function () {
  var mb = document.getElementById('loginBtn');
  mb.addEventListener('click', login);
};

function login() {
  const email = document.getElementById('InputEmail1').value;
  const password = document.getElementById('InputPassword1').value;
}

// async function basiclogin(email, password) {
//   const response = await zlFetch.post(loginEndpoint, {
//     auth: {
//       username: email,
//       password: password,
//     },
//     body: {
//       /*...*/
//     },
//   });
//   const { token } = response.body;

//   localStorage.setItem('token', token);
// }

// document.getElementById('userDetail').addEventListener(
//   'click',
//   function () {
//     console.log('Button clicked');
//     //xhr.send(data);
//   },
//   false
// );
