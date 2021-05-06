window.onload = function () {
  var mb = document.getElementById('userDetail');
  mb.addEventListener('click', autoRedirect);
};

async function isLoggedIn() {
  const token = localStorage.getItem('token');
  console.log(token);
  return token;
}

async function autoRedirect() {
  const validLogin = await isLoggedIn();
  if (!validLogin)
    window.location.replace('http://127.0.0.1:5500/html/login.html');
  else getUserData();
}

function getUserData() {
  event.preventDefault();
  console.log('Use info button clicked');

  const token = localStorage.getItem('token');
  var myHeaders = new Headers();
  myHeaders.append('jwt', token);
  fetch('http://localhost:8080/api/info', {
    method: 'get',
    mode: 'cors',
    headers: myHeaders,
    credentials: 'omit',
  })
    .then((res) => res.json())
    .then((body) => {
      displayTable(body);
    });
}

function displayTable(arr) {
  var out = '';
  i = 0;
  arr.forEach((element) => {
    i = i + 1;
    out +=
      '<tr class="table-light">' +
      '<th scope="row">' +
      i +
      '</th>' +
      '<td> ' +
      element.firstName +
      '</td>' +
      '<td> ' +
      element.lastName +
      '</td> </tr>';
  });

  document.getElementById('display-body').innerHTML = out;
  document.getElementById('table-vis').style.display = 'block';
}
