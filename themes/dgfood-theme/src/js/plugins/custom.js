// toggle-btn 

$(document).ready(function(){
	$('#nav-icon2').click(function(){
		$(this).toggleClass('open');
	});
});

// current time js start

$(document).ready(function() {
    var monthNames = ["Janu","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec"];
    var dayNames= ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    var newDate = new Date();
    newDate.setDate(newDate.getDate()); 
    $('#Date').html(dayNames[newDate.getDay()] + ",  " + monthNames[newDate.getMonth()] + ' ' + newDate.getDate() + ',  ' + newDate.getFullYear());
    
    setInterval( function() {
        var seconds = new Date().getSeconds();
        $("#sec").html(( seconds < 10 ? "0" : "" ) + seconds);
    },1000);
        
    setInterval( function() {
        var minutes = new Date().getMinutes();
        $("#min").html(( minutes < 10 ? "0" : "" ) + minutes);
    },1000);
    setInterval( function() {
        var hours = new Date().getHours();
        $("#hours").html(( hours < 10 ? "0" : "" ) + hours);
    }, 1000);
  }); 
  // current time js end

//font size incre decre js start
            
var $affectedElements = $("p, h1, h2, h3, h4, h5, h6, a, label, span, li"); // Can be extended, ex. $("div, p, span.someClass")

// Storing the original size in a data attribute so size can be reset
$affectedElements.each( function(){
  var $this = $(this);
  $this.data("orig-size", $this.css("font-size") );
});

$("#btn-increase").click(function(){
  changeFontSize(1);
})

$("#btn-decrease").click(function(){
  changeFontSize(-1); 
}) 

$("#btn-orig").click(function(){
  $affectedElements.each( function(){
        var $this = $(this);
        $this.css( "font-size" , $this.data("orig-size") );
   });
})

function changeFontSize(direction){
    $affectedElements.each( function(){
        var $this = $(this);
        $this.css( "font-size" , parseInt($this.css("font-size"))+direction );
    });
}

//font size incre decre js end

// search header

// $(function () {
//   $(".search-btn").on("click", function (e) {
//       $(this).parent().children('input').addClass("active").focus;
//       $(this).addClass("animate");
//       e.stopPropagation()
//   });
//   $(document).on("click", function (e) {
//       if ($(e.target).is(".input") === false) {
//           $(".input").removeClass("active");
//           $(".search-btn").removeClass("animate");
//       }
//   });
// });

// -------- password
$(".toggle-password").click(function () {
  $(this).toggleClass("bi bi-eye");
  $(this).toggleClass("bi bi-eye-slash");
  input = $(this).parent().find("input");
  if (input.attr("type") == "password") {
      input.attr("type", "text");
  } else {
      input.attr("type", "password");
  }
});

// datepicker

$(function () {
  $(".datepicker").datepicker({
      beforeShow: function (input, inst) {
      setTimeout(function() {
      inst.dpDiv.find('a.ui-state-highlight').removeClass('ui-state-highlight');
      }, 100);
      }
  });
});

// header fixed


$(window).scroll(function () {
  var window_top = $(window).scrollTop() + 1;
  if (window_top > 100) {
    $('header').addClass('menu-fixed animated fadeInDown');
  } else {
    $('header').removeClass('menu-fixed animated fadeInDown');
  }
});

// deshbord toggle js start

$(document).ready(function () {
  $(".hamburger").click(function () {
    $(this).toggleClass("is-active");
    $('.deshbordMain').toggleClass('closed-sidebar');
    $('.submenuList.open').slideToggle(500);
  });
});

// submenuDropdown js start

(function ($) {
  $(document).ready(function () {
    $('.submenuDropdown.active').addClass('active').children('.submenuList').addClass('open').show();
    $('.submenuDropdown #submenuClick').on('click', function () {
      var element = $(this).parent('li');
      if (element.hasClass('active')) {
        element.removeClass('active');
        element.find('li').removeClass('active');
        element.find('.submenuList.open').removeClass('open').slideUp(200);
      }
      else {
        element.addClass('active');
        element.children('.submenuList').addClass('open').slideDown(200);
        element.siblings('li').children('.submenuList').removeClass('open').slideUp(200);
        element.siblings('li').removeClass('active');
        element.siblings('li').find('li').removeClass('active');
        element.siblings('li').find('.submenuList').slideUp(200);
      }
    });

  });
})(jQuery);


// dropdown-

// $(document).ready(function(){
//   $(".noti-click").click(function(){
//     $(".dash-notify-drop").toggleClass("open-noti");
//   });
// });

// $(document).ready(function(){
//   $(".panel-btn").click(function(){
//   $(".side-panel").slideToggle();
//   });
//   $('body').on('click', function (e) {
//       if (!$('.noti-click').is(e.target)
//           && $('.noti-click').has(e.target).length === 0
//           && $('.open').has(e.target).length === 0
//       ) {
//           $('.dash-notify-drop').slideUp();
//       }
//   });
// });





$(document).ready(function(){
  $(".noti-click").click(function(){
  $(".dash-notification-box-wrapper").slideToggle();
  });
  $('body').on('click', function (e) {
      if (!$('.dash-notify-drop').is(e.target)
          && $('.dash-notify-drop').has(e.target).length === 0
          && $('.open').has(e.target).length === 0
      ) {
          $('.dash-notification-box-wrapper').slideUp();
      }
  });
});





$(document).ready(function(){
  $(".profile-click").click(function(){
  $(".profile-drop").slideToggle();
  });
  $('body').on('click', function (e) {
      if (!$('.profile-dropdown').is(e.target)
          && $('.profile-dropdown').has(e.target).length === 0
          && $('.open').has(e.target).length === 0
      ) {
          $('.profile-drop').slideUp();
      }
  });
});


//  fullScreen js start

function toggleFullScreen() {
  if ((document.fullScreenElement && document.fullScreenElement !== null) ||
    (!document.mozFullScreen && !document.webkitIsFullScreen)) {
    if (document.documentElement.requestFullScreen) {
      document.documentElement.requestFullScreen();
    } else if (document.documentElement.mozRequestFullScreen) {
      document.documentElement.mozRequestFullScreen();
    } else if (document.documentElement.webkitRequestFullScreen) {
      document.documentElement.webkitRequestFullScreen(Element.ALLOW_KEYBOARD_INPUT);
    }
  } else {
    if (document.cancelFullScreen) {
      document.cancelFullScreen();
    } else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    } else if (document.webkitCancelFullScreen) {
      document.webkitCancelFullScreen();
    }
  }
}



// fix deshbord on scroll js 

$(window).scroll(function () {
  if ($(this).scrollTop() > 46.36) {
    $('.deshbordMain').addClass('deshbordmainFixed');
  } else {
    $('.deshbordMain').removeClass('deshbordmainFixed');
  }
});


$('.home-slider .owl-carousel').owlCarousel({
  loop:true,
  margin: 5,
  dots: false,
  nav:true,
  navText: ['<i class="fa fa-angle-left"></i>', '<i class="fa fa-angle-right"></i>'],
  autoplay: true,
  smartSpeed: 1200,
  responsive:{
      0:{
          items:1
      },
      600:{
          items:1
      },
      911:{
          items:1
      },
      1300:{
          items:1
      }
  }
})

$('.category-slider .owl-carousel').owlCarousel({
  loop:true,
  margin: 20,
  dots: false,
  nav:true,
  autoplay: true,
  smartSpeed: 1200,
  responsive:{
      0:{
          items:1
      },
      600:{
          items:2
      },
      911:{
          items:3
      },
      1300:{
          items:5
      }
  }
})

$('.dg-service-slider .owl-carousel').owlCarousel({
  loop:true,
  margin: 20,
  dots: false,
  nav:true,
  autoplay: false,
  smartSpeed: 1200,
  responsive:{
      0:{
        items:1.5
      },
      480:{
          items:2
      },
      600:{
          items:3
      },
      911:{
          items:4
      },
      1300:{
          items:7
      }
  }
})






$('.focus-main-slder .owl-carousel').owlCarousel({
  loop:true,
  margin: 40,
  dots: false,
  nav:true,
  autoplay: false,
  smartSpeed: 1200,
  responsive:{
      0:{
          items:1
      },
      480:{
          items:1.5
      },
      911:{
          items:2
      },
      1300:{
          items:3
      }
  }
})


$('.what-slider .owl-carousel').owlCarousel({
  loop:true,
  margin: 20,
  dots: false,
  nav:true,
  autoplay: false,
  smartSpeed: 1200,
  responsive:{
      0:{
          items:1
      },
      600:{
          items:1
      },
      911:{
          items:2
      },
      1300:{
          items:3
      }
  }
})

// light box js
    		
$('.what-item').magnificPopup({
  delegate: '.img-link',
  type: 'image',
  tLoading: 'Loading image #%curr%...',
  mainClass: 'mfp-img-mobile',
  gallery: {
    enabled: true,
    navigateByImgClick: true,
    preload: [0,1]
  },
  image: {
    tError: '<a href="%url%">The image #%curr%</a> could not be loaded.',
    titleSrc: function(item) {
      return item.el.attr('title') + '<small></small>';
    }
  }
});

