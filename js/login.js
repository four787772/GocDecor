 document.getElementById("signin-link").addEventListener("click", function(event) {
	event.preventDefault();
	document.querySelector(".form-container.sign-in").classList.add("active");
	document.querySelector(".form-container.sign-up").classList.remove("active");
});

document.getElementById("signup-link").addEventListener("click", function(event) {
	event.preventDefault();
	document.querySelector(".form-container.sign-up").classList.add("active");
	document.querySelector(".form-container.sign-in").classList.remove("active");
});




