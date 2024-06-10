/**
* Template Name: Yummy
* Template URL: https://bootstrapmade.com/yummy-bootstrap-restaurant-website-template/
* Updated: Mar 17 2024 with Bootstrap v5.3.3
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/

(function() {
  "use strict";

  /**
   * Preloader
   */
  const preloader = document.querySelector('#preloader');
  if (preloader) {
    window.addEventListener('load', () => {
      preloader.remove();
    });
  }


	

	
	
  /**
   * Sticky header on scroll
   */
  const selectHeader = document.querySelector('#header');
  if (selectHeader) {
    document.addEventListener('scroll', () => {
      window.scrollY > 100 ? selectHeader.classList.add('sticked') : selectHeader.classList.remove('sticked');
    });
  }

  /**
   * Navbar links active state on scroll
   */
  let navbarlinks = document.querySelectorAll('#navbar a');

  function navbarlinksActive() {
    navbarlinks.forEach(navbarlink => {

      if (!navbarlink.hash) return;

      let section = document.querySelector(navbarlink.hash);
      if (!section) return;

      let position = window.scrollY + 200;

      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        navbarlink.classList.add('active');
      } else {
        navbarlink.classList.remove('active');
      }
    })
  }
  window.addEventListener('load', navbarlinksActive);
  document.addEventListener('scroll', navbarlinksActive);

  /**
   * Mobile nav toggle
   */
  const mobileNavShow = document.querySelector('.mobile-nav-show');
  const mobileNavHide = document.querySelector('.mobile-nav-hide');

  document.querySelectorAll('.mobile-nav-toggle').forEach(el => {
    el.addEventListener('click', function(event) {
      event.preventDefault();
      mobileNavToogle();
    })
  });

  function mobileNavToogle() {
    document.querySelector('body').classList.toggle('mobile-nav-active');
    mobileNavShow.classList.toggle('d-none');
    mobileNavHide.classList.toggle('d-none');
  }

  /**
   * Hide mobile nav on same-page/hash links
   */
  document.querySelectorAll('#navbar a').forEach(navbarlink => {

    if (!navbarlink.hash) return;

    let section = document.querySelector(navbarlink.hash);
    if (!section) return;

    navbarlink.addEventListener('click', () => {
      if (document.querySelector('.mobile-nav-active')) {
        mobileNavToogle();
      }
    });

  });

  /**
   * Toggle mobile nav dropdowns
   */
  const navDropdowns = document.querySelectorAll('.navbar .dropdown > a');

  navDropdowns.forEach(el => {
    el.addEventListener('click', function(event) {
      if (document.querySelector('.mobile-nav-active')) {
        event.preventDefault();
        this.classList.toggle('active');
        this.nextElementSibling.classList.toggle('dropdown-active');

        let dropDownIndicator = this.querySelector('.dropdown-indicator');
        dropDownIndicator.classList.toggle('bi-chevron-up');
        dropDownIndicator.classList.toggle('bi-chevron-down');
      }
    })
  });

  /**
   * Scroll top button
   */
  const scrollTop = document.querySelector('.scroll-top');
  if (scrollTop) {
    const togglescrollTop = function() {
      window.scrollY > 100 ? scrollTop.classList.add('active') : scrollTop.classList.remove('active');
    }
    window.addEventListener('load', togglescrollTop);
    document.addEventListener('scroll', togglescrollTop);
    scrollTop.addEventListener('click', window.scrollTo({
      top: 0,
      behavior: 'smooth'
    }));
  }

  /**
   * Initiate glightbox
   */
  const glightbox = GLightbox({
    selector: '.glightbox'
  });

  /**
   * Initiate pURE cOUNTER
   */
  new PureCounter();

  /**
   * Init swiper slider with 1 slide at once in desktop view
   */
  new Swiper('.slides-1', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
      clickable: true
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    }
  });

  /**
   * Init swiper slider with 3 slides at once in desktop view
   */
  new Swiper('.slides-3', {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
      clickable: true
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 40
      },

      1200: {
        slidesPerView: 3,
      }
    }
  });

  /**
   * Gallery Slider
   */
  new Swiper('.gallery-slider', {
    speed: 400,
    loop: true,
    centeredSlides: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    slidesPerView: 'auto',
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
      clickable: true
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20
      },
      640: {
        slidesPerView: 3,
        spaceBetween: 20
      },
      992: {
        slidesPerView: 5,
        spaceBetween: 20
      }
    }
  });

  /**
   * Animation on scroll function and init
   */
  function aos_init() {
    AOS.init({
      duration: 1000,
      easing: 'ease-in-out',
      once: true,
      mirror: false
    });
  }
  window.addEventListener('load', () => {
    aos_init();
  });
  

  
  /*
 //book-a-table
 // Lấy tất cả các section trừ section "About"
  var sections = document.querySelectorAll('section:not(#about):not(#why-us):not(#contact):not(#book-a-table):not(#blog)');

  // Hiển thị nội dung của các section khác trừ section "About" khi trang web được tải lên
  for (var i = 0; i < sections.length; i++) {
    sections[i].style.display = 'block';
  }

  // Ẩn nội dung của section "About" khi trang web được tải lên
  document.getElementById('about').style.display = 'none';
  document.getElementById('why-us').style.display = 'none';
  document.getElementById('contact').style.display = 'none';
  document.getElementById('book-a-table').style.display = 'none';
  document.getElementById('blog').style.display = 'none';

var sectionLinks = document.querySelectorAll('#navbar a[href^="#"]');
for (var i = 0; i < sectionLinks.length; i++) {
  sectionLinks[i].addEventListener('click', function(event) {
    event.preventDefault(); // Ngăn chặn hành vi mặc định của liên kết

    // Lấy id của section từ href của liên kết
    var targetSectionId = this.getAttribute('href').slice(1);

    // Lấy phần tử section mục tiêu
    var targetSection = document.getElementById(targetSectionId);

    // Trượt đến phần tử section mục tiêu
    if (targetSection) {
      targetSection.scrollIntoView({ behavior: 'smooth' });

      // Ẩn nội dung của section "About" nếu liên kết "About" được nhấp vào
      if (targetSectionId === 'about') {
		 document.getElementById(targetSectionId).style.display = 'block';
		 document.getElementById('why-us').style.display = 'block';
        var otherSections = document.querySelectorAll('section:not(#about):not(#why-us):not(#book-a-table)');
        for (var k = 0; k < otherSections.length; k++) {
          otherSections[k].style.display = 'none';
        }
		document.getElementById('contact').style.display = 'none';
		document.getElementById('book-a-table').style.display = 'none';

      } else if (targetSectionId === 'contact') {
		 document.getElementById(targetSectionId).style.display = 'block';
		 document.getElementById('about').style.display = 'none';
		 document.getElementById('why-us').style.display = 'none';
		 document.getElementById('book-a-table').style.display = 'none';
        var otherSections = document.querySelectorAll('section:not(#about):not(#why-us):not(#contact)');
        for (var k = 0; k < otherSections.length; k++) {
          otherSections[k].style.display = 'none';
        }
		}  else if (targetSectionId === 'hero') {
		 document.getElementById(targetSectionId).style.display = 'block';
		 document.getElementById('menu').style.display = 'block';
		 document.getElementById('events').style.display = 'block';
		 document.getElementById('testimonials').style.display = 'block';
        var otherSections = document.querySelectorAll('section:not(#hero):not(#menu):not(#events):not(#testimonials)');
        for (var k = 0; k < otherSections.length; k++) {
          otherSections[k].style.display = 'none';
        }
		}
		else if (targetSectionId === 'blog') {
		 document.getElementById(targetSectionId).style.display = 'block';
		 document.getElementById('about').style.display = 'none';
		 document.getElementById('why-us').style.display = 'none';
		 document.getElementById('book-a-table').style.display = 'none';
        var otherSections = document.querySelectorAll('section:not(#about):not(#why-us):not(#blog)');
        for (var k = 0; k < otherSections.length; k++) {
          otherSections[k].style.display = 'none';
        }
		} 
		 else if (targetSectionId === 'book-a-table') {
		document.getElementById(targetSectionId).style.display = 'block';
		 document.getElementById('about').style.display = 'none';
		 document.getElementById('why-us').style.display = 'none';
		 document.getElementById('contact').style.display = 'none';
        var otherSections = document.querySelectorAll('section:not(#book-a-table)');
        for (var k = 0; k < otherSections.length; k++) {
          otherSections[k].style.display = 'none';
        }
		} 
		else if (targetSectionId === 'menu') {
		document.getElementById(targetSectionId).style.display = 'block';
		 document.getElementById('about').style.display = 'none';
		 document.getElementById('why-us').style.display = 'none';
		 document.getElementById('contact').style.display = 'none';
        var otherSections = document.querySelectorAll('section:not(#menu):not(#events):not(#contact):not(#book-a-table)');
        for (var k = 0; k < otherSections.length; k++) {
          otherSections[k].style.display = 'none';
        }
		} 

	  else {
        // Hiển thị nội dung của section mục tiêu và ẩn nội dung của section "About"
        var sections = document.querySelectorAll('section:not(#about):not(#contact):not(#book-a-table)');
		for (var i = 0; i < sections.length; i++) {
			sections[i].style.display = 'block';
		}
		document.getElementById('contact').style.display = 'none';
		 document.getElementById('about').style.display = 'none';
		document.getElementById('why-us').style.display = 'none';
		document.getElementById('book-a-table').style.display = 'none';

        /*for (var j = 0; j < sections.length; j++) {
          if (sections[j].id === targetSectionId) {
            sections[j].style.display = 'block';
          } else if (sections[j].id === 'about') {
            sections[j].style.display = 'none';
          } else {
            sections[j].style.display = 'none';
          }
        }*/
   /*   }
    }
  });
}*/

	document.addEventListener('DOMContentLoaded', function() {
    var modals = document.getElementsByClassName('product-details');
    var buttons = document.querySelectorAll('.card-link button');

    for (var i = 0; i < buttons.length; i++) {
      buttons[i].addEventListener('click', function() {
        var modalId = this.getAttribute('data-modal-id');
        openModal(modalId);
      });
    }

    var closeButtons = document.querySelectorAll('.product-details button');

    for (var j = 0; j < closeButtons.length; j++) {
      closeButtons[j].addEventListener('click', closeModal);
    }

    function openModal(id) {
      var modal = document.getElementById(id);
      modal.style.display = "block";
    }

    function closeModal() {
      var parentModal = this.closest('.product-details');
      parentModal.style.display = "none";
    }
  });
  
  
  
  
  

})();

// tất cả trong sản phẩm
document.addEventListener('DOMContentLoaded', function() {
  const filterLinks = document.querySelectorAll('.nav-link[data-filter]');
  const tabPanes = document.querySelectorAll('.tab-pane');

  filterLinks.forEach(link => {
      link.addEventListener('click', function(event) {
          event.preventDefault();
          const filter = this.getAttribute('data-filter');

          // Remove 'active' and 'show' classes from all links and tab panes
          filterLinks.forEach(l => l.classList.remove('active', 'show'));
          tabPanes.forEach(pane => pane.classList.remove('active', 'show'));

          // Add 'active' and 'show' classes to the clicked link and its corresponding tab pane(s)
          this.classList.add('active', 'show');
          if (filter === '*') {
              tabPanes.forEach(pane => pane.classList.add('active', 'show'));
          } else {
              document.getElementById(filter).classList.add('active', 'show');
          }
      });
  });
});

