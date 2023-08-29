// On document ready change the background color of 4 divs with class "colour" to random complimentary hex values storing in the individual elements, add a box shadow of the same colour, and add a class called "is-light" if the background-colour is light using jquery

$(document).ready(function() {
  $(".colour").each(function() {
    $(this).css("background-color", randomColour());
    var colour = $(this).css("background-color");
    $(this).css("box-shadow", colour);
    $(this).toggleClass("is-light", isLight(colour));
  });
});

function randomColour() {
    var random = Math.floor(Math.random() * 16777215).toString(16);
    return "#" + ("000000" + random).slice(-6);
}

// Check if the background colour is light or dark using the YIQ formula with rgb values

function isLight(colour) {
    var rgb = colour.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
    var yiq = ((rgb[1]*299)+(rgb[2]*587)+(rgb[3]*114))/1000;
    console.log(yiq);
    return (yiq >= 128);
}


// Add an anchor tag to each of the 4 divs with class "colour" and change the text to show the background colour while converting from rgb to hex

$(document).ready(function() {
  $(".colour").each(function() {
    var colour = $(this).css("background-color");
    colour = rgbToHex(colour);
    $(this).append("<a href='#" + colour + "'>" + colour + "</a>");
  });
});

// Add a function to convert rgb to hex

function rgbToHex(r, g, b) {
    return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);
}