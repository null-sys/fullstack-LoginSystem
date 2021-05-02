//var xhr = new XMLHttpRequest();
//xhr.open('GET', url, false);
//xhr.onload = () => {};
window.onload = function () {
  var mb = document.getElementById('userDetail');
  mb.addEventListener('click', getUserData);
};

// async function isLoggedIn() {
//   const token = store.get('token');
//   if (!token) return false;
// }

// async function autoRedirect() {
//   const validLogin = await isLoggedIn();
//   if (!validLogin && location.pathname !== '/login/') redirect('/login');
//   if (validLogin && location.pathname === '/login/') redirect('/');
// }

// function getUserData() {
//   console.log('Use info button clicked');
// }

// document.getElementById('userDetail').addEventListener(
//   'click',
//   function () {
//     console.log('Button clicked');
//     //xhr.send(data);
//   },
//   false
// );
