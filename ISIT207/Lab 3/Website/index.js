let navVisible = true;
let colourScale = "hex";
var canShowColour = false;

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
      if (canShowColour){
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
    var text = $(".colourCode:eq("+index+")").text();
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

    if ($(this).scrollTop() > ($(".section").height() / 3) && navVisible) {
      $(".showcase:first-of-type").animate({
        opacity: 1
      }, 400);
    }
  });

  changeText("hex");
});

function generateColours(option) {
  switch (option) {
    case "Random":
      generateRandomColours();
      break;

    case "Monochromatic":
      generateMonochromatic();
      break;

    case "Analogous":
      generateAnalogous();
      break;

    case "Complementary":
      generateComplementary();
      break;

    case "Triadic":
      generateTriadic();
      break;

    case "Compound":
      generateCompound();
      break;

    default:
      generateRandomColours();
  }
}

function initialSetup() {
  $(".colour").each(function (index) {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    random = "#" + ("000000" + random).slice(-6);

    $(this).css("background-color", random);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq("+index+")" + " a");
    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq("+index+") > div").css("filter", "grayscale(1) invert(1)");
    }
    else{
      $(".smallColour:eq("+index+") > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find("a:first-of-type").text(rgbToHex(colour));

    updateColours();
  });
}

function generateRandomColours() {
  
  $(".colour").each(function (index) {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    random = "#" + ("000000" + random).slice(-6);

    $(this).css("background-color", random);
    var colour = $(this).css("background-color");
    var anchor = $(".colour:eq("+index+")" + " a");
    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq("+index+") > div").css("filter", "grayscale(1) invert(1)");
    }
    else{
      $(".smallColour:eq("+index+") > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find("a:first-of-type").text(rgbToHex(colour));

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
    var anchor = $(".colour:eq("+index+")" + " a");
    anchor.removeClass("is-light");
    if (isLight(colour)) {
      anchor.addClass("is-light");
      $(".smallColour:eq("+index+") > div").css("filter", "grayscale(1) invert(1)");
    }
    else{
      $(".smallColour:eq("+index+") > div").css("filter", "none");
    }
    anchor.css("color", colour);

    $(this).find("a:first-of-type").text(rgbToHex(colour));

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
      var anchor = $(".colour:eq("+index+")" + " a");
      anchor.removeClass("is-light");
      if (isLight(colour)) {
        anchor.addClass("is-light");
        $(".smallColour:eq("+index+") > div").css("filter", "grayscale(1) invert(1)");
      }
      else{
        $(".smallColour:eq("+index+") > div").css("filter", "none");
      }
      anchor.css("color", colour);
  
      $(this).find("a:first-of-type").text(rgbToHex(colour));

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
      var anchor = $(".colour:eq("+index+")" + " a");
      anchor.removeClass("is-light");
      if (isLight(colour)) {
        anchor.addClass("is-light");
        $(".smallColour:eq("+index+") > div").css("filter", "grayscale(1) invert(1)");
      }
      else{
        $(".smallColour:eq("+index+") > div").css("filter", "none");
      }
      anchor.css("color", colour);
  
      $(this).find("a:first-of-type").text(rgbToHex(colour));

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
      var anchor = $(".colour:eq("+index+")" + " a");
      anchor.removeClass("is-light");
      if (isLight(colour)) {
        anchor.addClass("is-light");
        $(".smallColour:eq("+index+") > div").css("filter", "grayscale(1) invert(1)");
      }
      else{
        $(".smallColour:eq("+index+") > div").css("filter", "none");
      }
      anchor.css("color", colour);
  
      $(this).find("a:first-of-type").text(rgbToHex(colour));

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
    $(".nextScale:eq("+index+")").text(option.toUpperCase());
    
    var colour = $(this).css("color");

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