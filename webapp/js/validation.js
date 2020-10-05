let y = "";
let r = "";

let sendingButton = document.getElementById('sendingButton')
const informationText = document.getElementById('informationText')
sendingButton.setAttribute('disabled', 'disabled')

const dotCanvas = document.getElementById("canvasDots")
dotCanvas.onclick = function(mouse) {
	if (r != "") {
		let cDotCAnvas = getCDotCAnvas();
		let centerX = cDotCAnvas.width / 2;
		let centerY = cDotCAnvas.height / 2;

		let mouseX = mouse.offsetX;
		let mouseY = mouse.offsetY;

		let currentX = (mouseX - centerX) / (centerX - centerX * 0.2) * +r;
		let currentY = (centerY - mouseY) / (centerY - centerY * 0.2) * +r;

		document.getElementById("xField").setAttribute("value", currentX);
		document.getElementById("yValue").setAttribute("value", currentY);
		$('#form').submit();

	}else {
		alert("R value should be declared!");
	}
}
sendingButton.onclick = function() {
	// $('[name="Y"]').value = y;
	// $('[name="R"]').value = r;
	// console.log($('[name="Y"]').value[0]);
	// $('#form').submit()
 	formRequest()
}

function validate() {
	let xFormValue = document.getElementById('xField').value;

	if (r == "") {
		informationText.innerText = '"R" value should not be empty!'
		sendingButton.setAttribute('disabled', 'disabled')
		return
	}
	markUp(r);
	if (xFormValue === "") {
		informationText.innerText = '"X" value should not be empty!'
		sendingButton.setAttribute('disabled', 'disabled')
		return
	}
	else if (y == "") {
		informationText.innerText = '"Y" value should not be empty!'
		sendingButton.setAttribute('disabled', 'disabled')
		return	
	}

	else {
		informationText.innerText = ''
	}
	xFormValue = xFormValue.replace(',', '.')
	if (!checkValue('X', +xFormValue)) {
		return
	}
	sendingButton.removeAttribute('disabled')
}
//if "value" satisfies the condition - return it
function checkValue(target, value) {
	if (isNaN(value)) {
		informationText.innerText = `${target} value should be a number!`
		sendingButton.setAttribute('disabled', 'disabled')
		return false
	}
	switch(target) {
		case 'X': 
			if (value < -5 || value > 3) {
				informationText.innerText = '"X" value should be [-5;3]!'
				sendingButton.setAttribute('disabled', 'disabled')
				return false
			}
			break
	}
	return true
}

function saveY(yValue) {
	$(".yButton").removeClass("selected");
	yValue.classList.add("class", "selected");
	y = yValue.value;
	document.getElementById("yValue").setAttribute("value", y);
	// document.getElementById("yValue").innerText = y.value;
	validate();
}
function saveR(rValue) {
	$(".rButton").removeClass("selected");
	rValue.classList.add("class", "selected");
	r = rValue.value;
	document.getElementById("rValue").setAttribute("value", r);
	// document.getElementById("rValue").innerText = r.value;
	drawPoints(+r);
	validate();
}

