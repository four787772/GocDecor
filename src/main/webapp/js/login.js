document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');

    // Ẩn form đăng ký mặc định
    registerForm.style.display = 'none';

    // Lắng nghe sự kiện click trên liên kết "Create an account"
    const showRegisterLink = document.querySelector('#show-register');
    showRegisterLink.addEventListener('click', function(event) {
        event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a
        registerForm.style.display = 'block'; // Hiển thị form đăng ký
        loginForm.style.display = 'none'; // Ẩn form đăng nhập
    });

    // Lắng nghe sự kiện click trên liên kết "Log in"
    const showLoginLink = document.querySelector('#show-login');
    showLoginLink.addEventListener('click', function(event) {
        event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a
        registerForm.style.display = 'none'; // Ẩn form đăng ký
        loginForm.style.display = 'block'; // Hiển thị form đăng nhập
    });
});
