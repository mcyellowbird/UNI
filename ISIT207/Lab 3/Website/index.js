let navVisible = true;

$(document).ready(function () {
  initialSetup();

  $(".colourOption").click(function () {
    colourOption = $(this).text();
    console.log(colourOption);
    generateColours(colourOption);
  });

  $("#navArrow").click(function () {
    if (!navVisible) {
      $(this).fadeOut(400, function() {
        $(this).attr("src", "images/uparrow.png");

        $(this).fadeIn(400);
      });

      $(".colourType").fadeIn(400);
      navVisible = true;
    }
    else {
      $(this).fadeOut(400, function() {
        $(this).attr("src", "images/downarrow.png");

        $(this).fadeIn(400);
      });

      $(".colourType").fadeOut(400);
      navVisible = false;
    }
  });
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
      generateComplimentary();
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
  $(".colour").each(function () {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    random = "#" + ("000000" + random).slice(-6);

    $(this).css("background-color", random);
    var colour = $(this).css("background-color");
    var anchor = $(this).find("a");
    anchor.toggleClass("is-light", isLight(colour));
    anchor.css("color", colour);
    anchor.text(rgbToHex(colour));
  });
}

function generateRandomColours() {
  console.log("generateRandomColours");
  $(".colour").each(function () {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    random = "#" + ("000000" + random).slice(-6);
    
    $(this).animate({backgroundColor: random}, 200);
    var colour = $(this).css("background-color");
    var anchor = $(this).find("a");
    anchor.toggleClass("is-light", isLight(colour));
    anchor.css("color", random);
    anchor.text(rgbToHex(colour));
  });
}

function generateComplimentary() {
  console.log("generateComplimentary");
  // clearData();
  // $(".colour").each(function () {



  //   var colour = $(this).css("background-color");
  //   $(this).css("box-shadow", colour);
  //   $(this).toggleClass("is-light", isLight(colour));
  //   $(this).append("<a href='#" + colour + "'>" + colour + "</a>");
  // });
}

function generateMonochromatic() {
  console.log("generateMonochromatic");
}

function generateAnalogous() {
  console.log("generateAnalogous");
}

function generateTriadic() {
  console.log("generateTriadic");
}

function generateCompound() {
  console.log("generateCompound");
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

function hexToComplimentary(hex) {

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