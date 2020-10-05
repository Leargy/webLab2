function formRequest() {
// 	let xParams = document.getElementById('xField').value
// 	let yParams = document.querySelector('input[name="Y"]:checked').value;
// 	let rParams = document.getElementById('rField').value
// 	console.log("X = " + xParams + " Y = " + yParams + " R = " + rParams)
// 	console.log(typeof $('[serialize="true"]').serialize())
	// $.get({
	// 	url: "php/process.php",
	// 	data: $('[serialize="true"]').serialize(),
	// 	headers: {
	// 	'Content-Type': 'application/x-www-form-urlencoded' // header
	// 	},
	// 	success: result=>{
	// 		    if(result) {
	// 		        let data = Cookies.get("data")
	// 		        console.log(data)
	// 	            // fillTable(data)
	// 		    }else {
	// 		        alert("Currupted data")
	// 		    }
	// 		}
	// });
	$('#xField')[0].value =$('#xField')[0].value.replace(',','.');
	let x = document.getElementById("xField").value
	let data = {X:`${x}`, Y:`${y}`, R:`${r}`};
	// let y = document.getElementById("yValue").innerText
	// let r = document.getElementById("rValue").innerText
	// console.log(x + y + r);
	// $.post("/webLab2-1.0-SNAPSHOT/scope", {X:`${x}`, Y:`${y}`, R:`${r}`}, 'same-origin').then(
	// 		result=>{
	// 			    if(result) {
	// 			    	// document.cookie = "suck"
	// 			        // let data = Cookies.get("data")
	// 			    	// console.log(data)
	// 		            // addLastData(JSON.parse("[" + data + "]"))
	// 			    }else {
	//
	// 			    }
	// 			});

	// fetch("/webLab2-1.0-SNAPSHOT/scope",{
	// 	method: "POST",
	// 	body: JSON.stringify(data),
	// 	headers: {
	// 		'Content-Type': 'application/json'
	// 	}
	// });
	// $('submitButton').on("click",() => {
	// 	// $('button[name="Y"]').value = window.y;
	// 	// $('button[name="R"]').value = window.r;
	// 	// $('#form').submit()
	// })
}