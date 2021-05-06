window.onload = function () {
  var mb = document.getElementById('signupBtn');
  mb.addEventListener('click', signup);
};

function signup() {
  event.preventDefault();
  const first = document.getElementById('firstName').value;
  const last = document.getElementById('lastName').value;
  const email = document.getElementById('InputEmail1').value;
  const password = document.getElementById('InputPassword1').value;

  const doc = {
    firstName: first,
    lastName: last,
    email: email,
    password: password,
  };
  var myHeaders = new Headers();
  myHeaders.append('Content-Type', 'application/json');
  fetch('http://localhost:8080/api/signup', {
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
