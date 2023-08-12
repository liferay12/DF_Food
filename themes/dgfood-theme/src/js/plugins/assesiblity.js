// big-cursor

$('.cursor').on('click',function () {
    $('#body').toggleClass('clicked');
});
    
// dropdown menu

$(document).ready(function(){
  $(".panel-btn").click(function(){
  $(".side-panel").slideToggle();
  });
  $('body').on('click', function (e) {
      if (!$('.panel-btn').is(e.target)
          && $('.panel-btn').has(e.target).length === 0
          && $('.open').has(e.target).length === 0
      ) {
          $('.side-panel').slideUp();
      }
  });
});

$(document).ready(function(){
    $(".filter-btn").click(function(){
    $(".filter-info").slideToggle();
    });
    $('body').on('click', function (e) {
        if (!$('.filter-btn').is(e.target)
            && $('.filter-btn').has(e.target).length === 0
            && $('.open').has(e.target).length === 0
        ) {
            $('.filter-info').slideUp();
        }
    });
  });

// menu dropdown

$(document).ready(function(){
  $(".main-menu").click(function(){
  $(".menu-dropdown").slideToggle();
  });
  $('body').on('click', function (e) {
      if (!$('.main-menu').is(e.target)
          && $('.main-menu').has(e.target).length === 0
          && $('.open').has(e.target).length === 0
      ) {
          $('.menu-dropdown').slideUp();
      }
  });
});


// login dropdown

$(document).ready(function(){
    $(".login-drop").click(function(){
    $(".login-dropdown").slideToggle();
    });
    $('body').on('click', function (e) {
        if (!$('.login-drop').is(e.target)
            && $('.login-drop').has(e.target).length === 0
            && $('.open').has(e.target).length === 0
        ) {
            $('.login-dropdown').slideUp();
        }
    });
  });


// seach dropdown

$('#search_button').on("click", function(e) {
 $('#search_open').slideToggle();
 e.stopPropagation(); 
});

$(document).on("click", function(e){
 if(!(e.target.closest('#search_open'))){  
    $("#search_open").slideUp();        
 }
});


// invert-color
$(document).ready(function(){
    $(".invert").click(function(){
        $("#body").toggleClass("invert-color");
    });
});

// link-high

$('.link-high').on('click',function () {
  $('#body').toggleClass('link-back');
}); 


// heading-high

$('.heading-high').on('click',function () {
  $('#body').toggleClass('head-back');
}); 

// reader-guid

$('.reader-guide').on('click',function () {
    $('#body').toggleClass('reader');
  }); 



  // monochrom

function toggleDarkLight() {
    var body = document.getElementById("body");
    var currentClass = body.className;
    body.className = currentClass == "dark-mode" ? "light-mode" : "dark-mode";
    $(this).toggleClass('active');
}
// remove css

    $('.reset').on('click',function () {
    $('#body').removeClass('clicked');
    $('#body').removeClass('link-back');
    $('#body').removeClass('head-back');
    $('#body').removeClass('reader');
    $(".side-panel").removeClass("show-panel");
    $("#body").removeClass("invert-color");
    $("#body").removeClass("dark-mode");
});


$(document).ready(function(){
    $(".test1").click(function(){
    $(".notification-box-wrapper").slideToggle();
    });
    $('body').on('click', function (e) {
        if (!$('.notify-drop').is(e.target)
            && $('.notify-drop').has(e.target).length === 0
            && $('.open').has(e.target).length === 0
        ) {
            $('.notification-box-wrapper').slideUp();
        }
    });
});


// read guid

const mouse = { x: undefined, y: undefined };
        document.addEventListener("pointermove", event => {
        mouse.x = event.clientX;
        mouse.y = event.clientY;
        console.log("ousem", mouse.x, mouse.y);
        
        gsap.to(".simultaneous > *", {
            x: mouse.x,
            y: mouse.y,
            duration: 0.1 });

        });