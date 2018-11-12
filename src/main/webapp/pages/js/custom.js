(function ($) {
    "use strict";
    var landingpage = {
        initialised: false,
        version: 1.0,
        mobile: false,
        init: function () {

            if (!this.initialised) {
                this.initialised = true;
            } else {
                return;
            }

            /*-------------- App Landing  Functions Calling ---------------------------------------------------
            ------------------------------------------------------------------------------------------------*/
            this.Mob_menu();
            this.Screen_slider();
            this.MailFunction();
            this.Wow();


        },

        /*-------------- App La html definition ---------------------------------------------------
        ---------------------------------------------------------------------------------------------------*/
        //Mobile menu
        Mob_menu: function () {
            $(".ap_menu_btn").click(function () {
                $(".ap_menu").addClass('open_menu');
            });
            $(".ap_menu_close").click(function () {
                $(".ap_menu").removeClass('open_menu');
            });
        },

        // Screen Slider		
        Screen_slider: function () {
            var swiper = new Swiper('.ap_screen_slider .swiper-container', {
                pagination: '.swiper-pagination',
                effect: 'coverflow',
                grabCursor: false,
                centeredSlides: true,
                touchRatio: 0,
                slidesPerView: '3',
                loop: true,
                autoplay: 5000,
                paginationClickable: true,
                slideToClickedSlide: true,
                coverflow: {
                    rotate: 0,
                    stretch: 0,
                    depth: 200,
                    modifier: 2,
                    slideShadows: false
                },
                breakpoints: {
                    1024: {
                        slidesPerView: 3,
                    },
                    768: {
                        slidesPerView: 2,
                        spaceBetween: 10,
                    },
                    640: {
                        slidesPerView: 2,
                        spaceBetween: 15,
                    },
                    480: {
                        slidesPerView: 2,
                    },
                    375: {
                        slidesPerView: 1,
                    }
                }
            });


        },

        Particales: function () {
            // var count_particles, stats, update;
            // stats = new Stats;
            // stats.setMode(0);
            // stats.domElement.style.position = 'relative';
            // document.body.appendChild(stats.domElement);
            // count_particles = document.querySelector('.js-count-particles');
            // update = function() {
            // stats.begin();
            // stats.end();
            // if (window.pJSDom[0].pJS.particles && window.pJSDom[0].pJS.particles.array) {
            // count_particles.innerText = window.pJSDom[0].pJS.particles.array.length;
            // }
            // requestAnimationFrame(update);
            // };
            // requestAnimationFrame(update);	

        },

        //Help mail function	
        MailFunction: function () {
            $("#contactForm").validator().on("submit", function (event) {
                if (event.isDefaultPrevented()) {
                    // handle the invalid form...
                    formError();
                    submitMSG(false, "Did you fill in the form properly?");
                } else {
                    // everything looks good!
                    event.preventDefault();
                    submitForm();
                }
            });


            function submitForm() {
                // Initiate Variables With Form Content
                var name = $("#name").val();
                var email = $("#email").val();
                var message = $("#message").val();

                $.ajax({
                    type: "POST",
                    url: "contactmail.php",
                    data: "name=" + name + "&email=" + email + "&message=" + message,
                    success: function (text) {
                        if (text == "success") {
                            formSuccess();
                        } else {
                            formError();
                            submitMSG(false, text);
                        }
                    }
                });
            }

            function formSuccess() {
                $("#contactForm")[0].reset();
                submitMSG(true, "Message Submitted!")
            }

            function formSuccess() {
                $("#contactForm")[0].reset();
                submitMSG(true, "Message Submitted!")
            }

            function formError() {
                $("#contactForm").removeClass().addClass('animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
                    $(this).removeClass();
                });
            }

            function submitMSG(valid, msg) {
                if (valid) {
                    var msgClasses = "h3 text-center tada animated text-success";
                } else {
                    var msgClasses = "h3 text-center text-danger";
                }
                $("#msgSubmit").removeClass().addClass(msgClasses).text(msg);
            }
        },


        //Wow js
        Wow: function () {
            new WOW().init();


        },
    };


    $(document).ready(function () {
        landingpage.init();
    });

    // Load Event

    $(window).on('load', function () {
        jQuery(".loader").fadeOut();
        jQuery(".loader").delay(600).fadeOut("slow");


    });


    //On scroll fixed menu
    $(window).scroll(function () {
        var wh = window.innerWidth;
        if (wh > 767) {
            var h = window.innerHeight;
            var window_top = $(window).scrollTop() + 1;
            if (window_top > 100) {
                $('.ap_menu_wrap ').addClass('ap_fixed');
            } else {
                $('.ap_menu_wrap ').removeClass('ap_fixed');
            }
        }

    });

})(jQuery);