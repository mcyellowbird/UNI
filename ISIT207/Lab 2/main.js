var carList = ["discountRed.gif", "discountOrange.gif", "discountBlue.gif"];
var colourList = ["rgba(5, 22, 154, 0.7)", "red", "orange"];
var shadowList = ["rgba(11, 0, 75, 0.7)", "rgba(82, 0, 19, 0.7)", "rgba(212, 0, 0, 0.7)"];
var currentCar = 1;

function changeDiscountText() {
    document.getElementById("discountCar").src = "images/" + carList[currentCar];
    var discountText = document.getElementById("discountText");
    discountText.style.color = colourList[currentCar];
    discountText.style.textShadow = shadowList[currentCar] + " 0px 1px 1px";
    
    if (currentCar + 1 < carList.length) { 
        currentCar += 1; 
    }
    else { 
        currentCar = 0; 
    }
}

window.onload = () => {
    setInterval(changeDiscountText, 5200)
}