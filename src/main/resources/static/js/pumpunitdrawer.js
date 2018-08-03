
var cvs = document.getElementById("canvas");
var ctx = cvs.getContext("2d");

var tsUnit = new Image();
var hsUnit = new Image();

tsUnit.src = "images/TS.jpg";
hsUnit.src = "images/HS.jpg";

function draw(){
    var unit_type_selected = document.getElementById("unit_type").value;
    var u_type = unit_type_selected.valueOf();
    var image_to_draw;

    switch (u_type) {
        case "ts":
            image_to_draw = tsUnit;
            break;
        case "hs":
            image_to_draw = hsUnit;
            break;
        default:alert("Нет картинки выбранного узла")
    }
    ctx.clearRect(0, 0, cvs.width, cvs.height);
    ctx.drawImage(image_to_draw, 0,0);
}

// start drawing when last image is loaded
hsUnit.onload = draw;
