let navVisible = true;
let colourScale = "hex";
var canShowColour = false;
let colorsArray = [];

// Function to fetch colors asynchronously
function fetchColorsAsync() {
  return new Promise((resolve, reject) => {
    // Simulated asynchronous operation (replace with actual asynchronous code - limited in time)
    setTimeout(() => {
      // Retrieve colors from DOM elements with class "colour"
      const fetchedColors = [];

      // ----------------------------------------------------------------- //
      // Comment out the following 3 lines to perform the reject operation //

      $(".colour").each(function (index) {
        fetchedColors.push($(this).css("background-color"));
      });
      
      // ----------------------------------------------------------------- //

      if (fetchedColors.length > 0) {
        resolve(fetchedColors); // Resolve with the fetched colors
      } else {
        reject("No colors found"); // Reject if no colors are found
      }
    }, 2000); // Simulated delay of 2 seconds
  });
}

// Second action executed when the Promise is rejected
function secondAction() {
  console.log('Second action executed because Promise was rejected.');
}

// Function to add colors to the array using Promises
function addColors() {
  // Call fetchColorsAsync and handle Promises
  fetchColorsAsync()
    .then((fetchedColors) => {
      // Add the fetched colors to the array
      colorsArray.push(...fetchedColors);
      console.log('Colors added:', colorsArray);
    })
    .catch((error) => {
      // Handle any errors that occurred during fetching
      console.error('Error fetching colors:', error);
      // Perform the second action when the Promise is rejected
      secondAction();
    });
}

// Call the addColors function to initiate the asynchronous operation
addColors();

$(document).ready(function () {
  initialSetup();
  $(".colourList").fadeOut(0);

  $(".colourOption").click(function () {
    colourOption = $(this).text();
    generateColours(colourOption);
  });

  $("[src$='.png'").click(function () {
    if (!navVisible) {
      $(this).fadeOut(400, function () {
        $(this).attr("src", "images/uparrow.png");

        $(this).fadeIn(400);
      });

      $(".colourType").fadeIn(400);
      if (canShowColour) {
        $(".colourList").fadeIn(400);
      }
      navVisible = true;
    } else {
      $(this).fadeOut(400, function () {
        $(this).attr("src", "images/downarrow.png");

        $(this).fadeIn(400);
      });

      $(".colourType").toggle(200);
      $(".colourList").fadeOut(400);
      navVisible = !navVisible;
    }
  });

  $(".colourCode").click(function () {
    var text = $(this).text();
    navigator.clipboard.writeText(text);
  });

  $(".smallColour").click(function () {
    var index = $(this).index();
    var text = $(".colourCode:eq(" + index + ")").text();
    navigator.clipboard.writeText(text);
  });

  // $(".colour").hover(function (){
  //   var index = $(this).index();
  //   // $(".colour:eq("+index-1)
  //   $(".colour:eq("+(index)+")").css({boxShadow: "inset 0px 0px 8px 2px rgba(0, 0, 0, 0.25)"});
  // }, function () {
  //   var index = $(this).index();
  //   $(".colour:eq("+(index)+")").css({boxShadow: "none"});
  // });

  $(".smallColour").hover(function () {
    // $(this).find("div").css("display", "inline-block");

    $('#pop-up').show();
    // $(this).find("a").css("color", isLight($(this).css("background-color"))? "#000000" : "#ffffff");
  }, function () {
    $('#pop-up').hide();
    // $(this).find("div").css("display", "none");
  });

  $(".colourCode").hover(function () {
    $('#pop-up').show();
  }, function () {
    $('#pop-up').hide();
  });

  $(function () {
    var moveLeft = 65;
    var moveUp = 50;

    $('.smallColour').mousemove(function (e) {
      $("#pop-up").css('top', e.pageY + moveUp - 20).css('left', e.pageX - moveLeft + 5);
    });

    $('.colourCode').mousemove(function (e) {
      $("#pop-up").css('top', e.pageY - moveUp).css('left', e.pageX - moveLeft);
    });

    // Colour Picker
    function hexFromRGB(r, g, b) {
      var hex = [
        r.toString(16),
        g.toString(16),
        b.toString(16)
      ];
      $.each(hex, function (nr, val) {
        if (val.length === 1) {
          hex[nr] = "0" + val;
        }
      });
      return hex.join("").toUpperCase();
    }

    function refreshSwatch() {
      var red = $("#red").slider("value"),
        green = $("#green").slider("value"),
        blue = $("#blue").slider("value"),
        hex = hexFromRGB(red, green, blue);
      $("#swatch").css("background-color", "#" + hex);
    }

    $("#red, #green, #blue").slider({
      orientation: "horizontal",
      range: "min",
      max: 255,
      value: 127,
      slide: refreshSwatch,
      change: refreshSwatch
    });
  });

  $(".nextScale").click(function () {
    switch (colourScale) {
      case "hex":
        changeText("rgb");
        colourScale = "rgb";
        break;
      case "rgb":
        changeText("hsl");
        colourScale = "hsl";
        break;
      case "hsl":
        changeText("hex");
        colourScale = "hex";
        break;

      default:
        changeText("hex");
        colourScale = "hex";
        break;
    }
  })

  $(window).scroll(function () {
    if ($(this).scrollTop() > $(".section").height() - 140 && navVisible) {
      $(".colourList").fadeIn(400);
      canShowColour = true;
    } else {
      $(".colourList").fadeOut(400);
      canShowColour = false;
    }

    if ($(this).scrollTop() > ($(".section").height() / 3)) {
      $(".section:nth-of-type(3) > .showcase").animate({
        opacity: 1
      }, 400);
    }

    if ($(this).scrollTop() > (($(".section").height() / 3) + $(".section").height())) {
      $(".section:nth-of-type(4) > .showcase").animate({
        opacity: 1
      }, 400);
    }
  });

  // JQuery UI

  // Accordion Widget
  $("#accordion").accordion({
    heightStyle: "content"
  });

  // Dialog
  $("#colourPickerDialog").dialog({
    autoOpen: false,
    resizable: false,
    width: "420px",
    show: {
      effect: "fadeIn",
      duration: 200
    },
    hide: {
      effect: "fadeOut",
      duration: 200
    }
  });

  var activeColourIndex = 0;

  $(".colourPicker").on("click", function () {
    activeColourIndex = $(".colourPicker").index(this);
    $("#colourPickerDialog").dialog("open");

    var colour = $(this).css("color");
    // console.log($(".colour:eq("+index+")").css("background-color"));

    // Get array of RGB values
    var rgb = colour.replace(/[^\d,]/g, '').split(',');

    var r = rgb[0],
      g = rgb[1],
      b = rgb[2];

    $("#colourPickerDialog > p > span:nth-of-type(2)").text("Changing Colour #" + (activeColourIndex + 1));

    $("#red").slider("option", "value", r);
    $("#red span").text(r);

    $("#green").slider("option", "value", g);
    $("#green span").text(g);

    $("#blue").slider("option", "value", b);
    $("#blue span").text(b);
  })

  //


  $("#red").mousemove(function () {
    var colour = $(".colour").eq(activeColourIndex).css("background-color");

    // Get array of RGB values
    var rgb = colour.replace(/[^\d,]/g, '').split(',');

    var g = rgb[1],
      b = rgb[2];


    // var r = Math.round(100 * $("#red div").width() / $("#red div").offsetParent().width());
    // r = (r / 100) * 255;

    var r = $("#red").slider("option", "value");

    $(".colour").eq(activeColourIndex).css("background-color", "rgb(" + r + ", " + g + ", " + b + ")");
    // console.log("rgb(" + r + ", " + g + ", " + b + ")");
    $("#red span").text(Math.floor(r));

    var anchor = $(".colour:eq(" + activeColourIndex + ")" + " a");
    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + activeColourIndex + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + activeColourIndex + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + activeColourIndex + ") > div").css("filter", "none");
      $(".colour:eq(" + activeColourIndex + ") .colourPicker > div").css("filter", "none");
    }

    updateColours();
  });

  $("#green").mousemove(function () {
    var colour = $(".colour").eq(activeColourIndex).css("background-color");

    // Get array of RGB values
    var rgb = colour.replace(/[^\d,]/g, '').split(',');

    var r = rgb[0],
      b = rgb[2];

    // var g = Math.round(100 * $("#green div").width() / $("#green div").offsetParent().width());
    // g = (g / 100) * 255;

    var g = $("#green").slider("option", "value");

    $(".colour").eq(activeColourIndex).css("background-color", "rgb(" + r + ", " + g + ", " + b + ")");
    // console.log("rgb(" + r + ", " + g + ", " + b + ")");
    $("#green span").text(Math.floor(g));

    var anchor = $(".colour:eq(" + activeColourIndex + ")" + " a");
    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + activeColourIndex + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + activeColourIndex + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + activeColourIndex + ") > div").css("filter", "none");
      $(".colour:eq(" + activeColourIndex + ") .colourPicker > div").css("filter", "none");
    }

    updateColours();
  });

  $("#blue").mousemove(function () {
    var colour = $(".colour").eq(activeColourIndex).css("background-color");

    // Get array of RGB values
    var rgb = colour.replace(/[^\d,]/g, '').split(',');

    var r = rgb[0],
      g = rgb[1];

    // var b = Math.round(100 * $("#blue div").width() / $("#blue div").offsetParent().width());
    // b = (b / 100) * 255;

    var b = $("#blue").slider("option", "value");

    $(".colour").eq(activeColourIndex).css("background-color", "rgb(" + r + ", " + g + ", " + b + ")");
    // console.log("rgb(" + r + ", " + g + ", " + b + ")");
    $("#blue span").text(Math.floor(b));

    var anchor = $(".colour:eq(" + activeColourIndex + ")" + " a");
    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + activeColourIndex + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + activeColourIndex + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + activeColourIndex + ") > div").css("filter", "none");
      $(".colour:eq(" + activeColourIndex + ") .colourPicker > div").css("filter", "none");
    }

    updateColours();
  });

  // Custom Widget

  // Define the CourseCarousel widget using the Widget Factory
  $.widget("custom.courseCarousel", {
    options: {
      courses: [], // An array of course objects with details
    },

    _create: function () {
      // Initialize the widget
      console.log("Widget created");
      this._renderCarousel();
    },

    _renderCarousel: function () {
      console.log("Rendering carousel");
      const $carouselContainer = $("<div>").addClass("course-carousel");

      const widget = this;

      let $focusedItem = null;

      // Iterate through the provided courses and create carousel items
      this.options.courses.forEach((course) => {
        const $courseItem = $("<div>").addClass("course-item").click(function () {
          // Remove the "course-item-focused" class from all items
          $(".course-item").removeClass("course-item-focused");

          // Add the "course-item-focused" class to the clicked item
          $(this).addClass("course-item-focused");
          
          // Update the currently focused item
          $focusedItem = $(this);
        });

        const $courseTitle = $("<h2>").text(course.title);
        const $courseDescription = $("<p>").text(course.description);
        const $courseCode = $("<p>").text("Course Code: " + course.coursecode);

        $courseItem.append($courseTitle, $courseDescription, $courseCode);
        $carouselContainer.append($courseItem);
      });

      // Append the carousel to the "courseCarousel" section
      this.element.append($carouselContainer);
    },
  });

  const courseList = [{
      title: "Web Development Fundamentals",
      description: "Explore the core concepts of web development, including HTML, CSS, and JavaScript.",
      coursecode: "188273",
    },
    {
      title: "Python Programming Masterclass",
      description: "Become a Python expert with hands-on exercises and real-world projects.",
      coursecode: "128374",
    },
    {
      title: "Data Science for Beginners",
      description: "Learn the basics of data science, data analysis, and data visualization.",
      coursecode: "164879",
    },
    {
      title: "Machine Learning Essentials",
      description: "Dive into the world of machine learning and build predictive models.",
      coursecode: "168445",
    },
    {
      title: "Digital Marketing Strategies",
      description: "Master digital marketing techniques to promote products and services online.",
      coursecode: "176845",
    },
    {
      title: "Graphic Design Fundamentals",
      description: "Unlock your creative potential with graphic design principles and tools.",
      coursecode: "293028",
    },
    {
      title: "Financial Planning for Everyone",
      description: "Manage your finances wisely and plan for a secure financial future.",
      coursecode: "198277",
    },
    {
      title: "Photography Techniques and Tips",
      description: "Capture stunning photos with professional photography techniques and tips.",
      coursecode: "128473",
    },
  ];

  // Initialize the CourseCarousel widget with the courses data
  $("#courseCarousel").courseCarousel({
    courses: courseList
  });
});

function generateColours(option) {
  switch (option) {
    case "Random":
      generateRandomColours();
      $("#colourPickerDialog").dialog("close");
      break;

    case "Monochromatic":
      generateMonochromatic();
      $("#colourPickerDialog").dialog("close");
      break;

    case "Analogous":
      generateAnalogous();
      $("#colourPickerDialog").dialog("close");
      break;

    case "Complementary":
      generateComplementary();
      $("#colourPickerDialog").dialog("close");
      break;

    case "Triadic":
      generateTriadic();
      $("#colourPickerDialog").dialog("close");
      break;

    case "Compound":
      generateCompound();
      $("#colourPickerDialog").dialog("close");
      break;

    default:
      generateRandomColours();
      $("#colourPickerDialog").dialog("close");
  }
}

function initialSetup() {
  $(".colour").each(function (index) {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    random = "#" + ("000000" + random).slice(-6);

    $(this).css("background-color", random);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq(" + index + ")" + " a");
    anchor.css("color", colour);

    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + index + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + index + ") > div").css("filter", "none");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find(".colourCode").text(rgbToHex(colour));

    updateColours();
  });

  changeText("hex");
}

function generateRandomColours() {

  $(".colour").each(function (index) {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    random = "#" + ("000000" + random).slice(-6);

    $(this).css("background-color", random);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq(" + index + ")" + " a");
    anchor.css("color", colour);

    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + index + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + index + ") > div").css("filter", "none");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find(".colourCode").text(rgbToHex(colour));

    updateColours();
  });
}

function generateComplementary() {
  var colours = [];
  var h = Math.floor(Math.random() * 360),
    s = Math.floor(Math.random() * (60 - 41) + 41) + '%',
    l = Math.floor(Math.random() * (75 - 25) + 25);

  colours[0] = "hsl(" + h + ", " + s + ", " + l + "%)";
  colours[1] = "hsl(" + h + ", " + s + ", " + (l + (Math.random() * (10 - 2) + 2)) + "%)";

  // Flip 'h' value
  h += 180;
  if (h > 360) {
    h -= 360;
  }

  colours[2] = "hsl(" + h + ", " + s + ", " + l + "%)";
  colours[3] = "hsl(" + h + ", " + s + ", " + (l + (Math.random() * (10 - 2) + 2)) + "%)";
  colours[4] = "hsl(" + h + ", " + s + ", " + (l + (Math.random() * (20 - 12) + 12)) + "%)";

  $(".colour").each(function (index) {
    $(this).css("background-color", colours[index]);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq(" + index + ")" + " a");
    anchor.css("color", colour);

    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + index + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + index + ") > div").css("filter", "none");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find(".colourCode").text(rgbToHex(colour));

    updateColours();
  });
}

function generateMonochromatic() {
  var colours = [];
  var h = Math.floor(Math.random() * 360),
    s = Math.floor(Math.random() * 100) + '%',
    l = Math.floor(Math.random() * (75 - 25) + 25);

  colours[0] = "hsl(" + h + ", " + s + ", " + (l - (Math.random() * (20 - 12) + 12)) + "%)";
  colours[1] = "hsl(" + h + ", " + s + ", " + (l - (Math.random() * (10 - 2) + 2)) + "%)";
  colours[2] = "hsl(" + h + ", " + s + ", " + l + "%)";
  colours[3] = "hsl(" + h + ", " + s + ", " + (l + (Math.random() * (10 - 2) + 2)) + "%)";
  colours[4] = "hsl(" + h + ", " + s + ", " + (l + (Math.random() * (20 - 12) + 12)) + "%)";

  $(".colour").each(function (index) {
    $(this).css("background-color", colours[index]);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq(" + index + ")" + " a");
    anchor.css("color", colour);

    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + index + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + index + ") > div").css("filter", "none");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find(".colourCode").text(rgbToHex(colour));

    updateColours();
  });
}

function generateAnalogous() {
  var colours = [];
  var h = Math.floor(Math.random() * (270 - 90) + 90),
    s = Math.floor(Math.random() * (70 - 40) + 40) + '%',
    l = Math.floor(Math.random() * (70 - 40) + 40) + '%';

  colours[0] = "hsl(" + (h - 90) + ", " + s + ", " + l + ")";
  colours[1] = "hsl(" + (h - 45) + ", " + s + ", " + l + ")";
  colours[2] = "hsl(" + h + ", " + s + ", " + l + ")";
  colours[3] = "hsl(" + (h + 45) + ", " + s + ", " + l + ")";
  colours[4] = "hsl(" + (h + 90) + ", " + s + ", " + l + ")";

  $(".colour").each(function (index) {
    $(this).css("background-color", colours[index]);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq(" + index + ")" + " a");
    anchor.css("color", colour);

    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq(" + index + ") > div").css("filter", "grayscale(1) invert(1)");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "grayscale(1) invert(1)");
    } else {
      $(".smallColour:eq(" + index + ") > div").css("filter", "none");
      $(".colour:eq(" + index + ") .colourPicker > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find(".colourCode").text(rgbToHex(colour));

    updateColours();
  });
}

function generateTriadic() {
  var colours = [];
  var h = Math.floor(Math.random() * (240 - 120) + 120),
    s = Math.floor(Math.random() * (80 - 30) + 30) + '%';
  // l = Math.floor(Math.random() * (70 - 21) + 21) + '%';

  colours[0] = "hsl(" + (h - 120) + ", " + s + ", " + (Math.floor(Math.random() * (70 - 21) + 21)) + "%)";
  colours[1] = "hsl(" + (h - 60) + ", " + s + ", " + (Math.floor(Math.random() * (70 - 21) + 21)) + "%)";
  colours[2] = "hsl(" + h + ", " + s + ", " + (Math.floor(Math.random() * (70 - 21) + 21)) + "%)";
  colours[3] = "hsl(" + (h + 60) + ", " + s + ", " + (Math.floor(Math.random() * (70 - 21) + 21)) + "%)";
  colours[4] = "hsl(" + (h + 120) + ", " + s + ", " + (Math.floor(Math.random() * (70 - 21) + 21)) + "%)";

  $(".colour").each(function (index) {
    $(this).css("background-color", colours[index]);
    var colour = $(this).css("background-color");

    $(this).find(".colourCode").text(rgbToHex(colour));

    updateColours();
  });
}

function isLight(colour) {
  var rgb = colour.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
  var yiq = ((rgb[1] * 299) + (rgb[2] * 587) + (rgb[3] * 114)) / 1000;
  return (yiq >= 128);
}

function rgbToHex(rgb) {
  rgb = rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);

  function hex(x) {
    return ("0" + parseInt(x).toString(16)).slice(-2);
  }
  return "#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
}

function hexToComplementary(hex) {

  // Convert hex to rgb
  var rgb = 'rgb(' + (hex = hex.replace('#', '')).match(new RegExp('(.{' + hex.length / 3 + '})', 'g')).map(function (l) {
    return parseInt(hex.length % 2 ? l + l : l, 16);
  }).join(',') + ')';

  // Get array of RGB values
  rgb = rgb.replace(/[^\d,]/g, '').split(',');

  var r = rgb[0],
    g = rgb[1],
    b = rgb[2];

  // Convert RGB to HSL
  r /= 255.0;
  g /= 255.0;
  b /= 255.0;
  var max = Math.max(r, g, b);
  var min = Math.min(r, g, b);
  var h, s, l = (max + min) / 2.0;

  if (max == min) {
    h = s = 0; //achromatic
  } else {
    var d = max - min;
    s = (l > 0.5 ? d / (2.0 - max - min) : d / (max + min));

    if (max == r && g >= b) {
      h = 1.0472 * (g - b) / d;
    } else if (max == r && g < b) {
      h = 1.0472 * (g - b) / d + 6.2832;
    } else if (max == g) {
      h = 1.0472 * (b - r) / d + 2.0944;
    } else if (max == b) {
      h = 1.0472 * (r - g) / d + 4.1888;
    }
  }

  h = h / 6.2832 * 360.0 + 0;

  // Shift hue to opposite side of wheel and convert to [0-1] value
  h += 180;
  if (h > 360) {
    h -= 360;
  }
  h /= 360;

  // Convert h s and l values into r g and b values
  if (s === 0) {
    r = g = b = l; // achromatic
  } else {
    var hue2rgb = function hue2rgb(p, q, t) {
      if (t < 0) t += 1;
      if (t > 1) t -= 1;
      if (t < 1 / 6) return p + (q - p) * 6 * t;
      if (t < 1 / 2) return q;
      if (t < 2 / 3) return p + (q - p) * (2 / 3 - t) * 6;
      return p;
    };

    var q = l < 0.5 ? l * (1 + s) : l + s - l * s;
    var p = 2 * l - q;

    r = hue2rgb(p, q, h + 1 / 3);
    g = hue2rgb(p, q, h);
    b = hue2rgb(p, q, h - 1 / 3);
  }

  r = Math.round(r * 255);
  g = Math.round(g * 255);
  b = Math.round(b * 255);

  // Convert r b and g values to hex
  rgb = b | (g << 8) | (r << 16);
  return "#" + (0x1000000 | rgb).toString(16).substring(1);
}

function updateColours() {
  var colours = $(".colour");

  colours.each(function (index) {
    // document.documentElement.style.setProperty('--col' + (index + 1), colours[index].style.backgroundColor);
    $(":root").css('--col' + (index + 1), colours[index].style.backgroundColor);

    var colour = colours[index].style.backgroundColor;
    var anchor = $(".colour:eq(" + index + ")" + " a");
    anchor.css("color", colour);
  });

  changeText(colourScale);
}

function rgbToHsl(r, g, b) {
  r /= 255, g /= 255, b /= 255;

  var max = Math.max(r, g, b),
    min = Math.min(r, g, b);
  var h, s, l = (max + min) / 2;

  if (max == min) {
    h = s = 0; // achromatic
  } else {
    var d = max - min;
    s = l > 0.5 ? d / (2 - max - min) : d / (max + min);

    switch (max) {
      case r:
        h = (g - b) / d + (g < b ? 6 : 0);
        break;
      case g:
        h = (b - r) / d + 2;
        break;
      case b:
        h = (r - g) / d + 4;
        break;
    }

    h /= 6;
  }

  return [(Math.round((h + Number.EPSILON) * 100) / 100), (Math.round((s + Number.EPSILON) * 100) / 100), (Math.round((l + Number.EPSILON) * 100) / 100)];
}

function changeText(option) {
  $(".colourCode").each(function (index) {
    $(".nextScale:eq(" + index + ")").text(option.toUpperCase());

    var colour = $(this).css("color");
    // var colour = $(":root").css('--col' + (index + 1));


    if (option == "hex") {
      $(this).text(rgbToHex(colour));
      // $(".smallColour").eq(index).text(rgbToHex(colour));
    } else if (option == "rgb") {
      $(this).text(colour);
      // $(".smallColour").eq(index).text(colour);
    } else if (option == "hsl") {
      // Get array of RGB values
      var rgb = colour.replace(/[^\d,]/g, '').split(',');

      var r = rgb[0],
        g = rgb[1],
        b = rgb[2];

      var hsl = rgbToHsl(r, g, b);

      $(this).text("hsl(" + Math.round(hsl[0] * 360) + "deg " + Math.round(hsl[1] * 100) + "% " + Math.round(hsl[2] * 100) + "%)");
      // $(".smallColour").eq(index).text("hsl(" + Math.round(hsl[0] * 360) + "deg " + Math.round(hsl[1] * 100) + "% " + Math.round(hsl[2] * 100) + "%)");
    }
  });
}