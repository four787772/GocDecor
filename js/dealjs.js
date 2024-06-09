// Tạo một hàm để khởi tạo hiệu ứng preloader cho trang chi tiết mới
function initDetailPagePreloader() {
    // Kiểm tra nếu trang hiện tại là trang chi tiết mới
    var isNewDetailPage = document.getElementById("blog-page-content"); // Thay "#new-detail-page" bằng id của trang chi tiết mới

    if (isNewDetailPage) {
        // Hiệu ứng preloader khi trang đang tải
        document.addEventListener("DOMContentLoaded", function() {
            // Hiển thị preloader
            var preloader = document.getElementById("preloader");
            preloader.style.display = "flex"; // Hiển thị preloader

            // Ẩn preloader khi trang được tải hoàn toàn
            window.addEventListener('load', function(){
                preloader.style.display = "none"; // Ẩn preloader
            });
        });
    }
}

// Gọi hàm để khởi tạo hiệu ứng preloader cho trang chi tiết mới
initDetailPagePreloader();
