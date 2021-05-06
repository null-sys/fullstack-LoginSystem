window.onload = function () {
  var mb = document.getElementById('loginBtn');
  mb.addEventListener('click', login);
};

function login() {
  event.preventDefault();
  const email = document.getElementById('InputEmail1').value;
  const password = document.getElementById('InputPassword1').value;
  console.log('Login clicked');

  var doc = {
    email: email,
    password: password,
  };
  var myHeaders = new Headers();
  myHeaders.append('Content-Type', 'application/json');
  fetch('http://localhost:8080/api/login', {
    method: 'post',
    mode: 'cors',
    headers: myHeaders,
    credentials: 'omit',
    body: JSON.stringify(doc),
  })
    .then((res) => res.json())
    .then((body) => {
      localStorage.setItem('token', body.jwtString);
      localStorage.setItem('user', body.user);
      if (body.user !== null) {
        window.location.replace('http://127.0.0.1:5500/index.html');
      }
    });
}
