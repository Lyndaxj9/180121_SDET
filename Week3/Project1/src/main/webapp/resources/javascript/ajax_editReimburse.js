window.onload = function() {
	setUrl();
}

function goBack() {
	window.history.back();
}

function denyRe() {
	var r = document.getElementById("response").value;
	
	if(r == 0){
		var rd = document.getElementById("resdiv");
		
		var input = document.createElement("input");
		input.type = 'text';
		input.id = 'denyres';
		input.required = true;
		rd.appendChild(input);
	} else {
		var i = document.getElementById("denyres");
		if(i != null) {
			i.remove();
		}
	}
}

function setUrl() {
	var downloadButton = document.getElementById("getFiles");
	
	if(downloadButton != null) {
		var rid = document.getElementById("rid").innerHTML;
		var link = "/TRMS/user/editpersonalreimburse.jsp/download?rid=" + rid;
		downloadButton.onclick = function() {
			window.location.href = link;
		}
	}
}

function readPageChanges() {
	var grade = document.getElementById("grade").value;
	var r = document.getElementById("response");
	var ai = document.getElementById("reqinfo");
	var addinfo = document.getElementById("addinfo");
	var pr = document.getElementById("projreimb");
	var award = document.getElementById("award");
	var fileUp = document.getElementById("inputFile");
	
	if(grade != "") {
		aPostGradeUpdate();
	}
	if(r != null && r.value != -1) {
		var dr = document.getElementById('denyres');
		console.log(dr);
		if(dr == null) {
			appResponse();
		} else if(r.value == 0 && dr.value == ""){
			document.getElementById('denyres').value = "MUST ENTER A REASON!";
		} else if(r.value == 0 && dr.value != "") {
			insertAddInfo();
		}
		appResponse();
	}	
	if(ai != null && ai != "") {
		insertAddInfo();
		updateInfoReq();
	}
	if(addinfo != null) {
		insertAddInfo();
	}
	if(pr != null) {
		updateProjReimb();
	}
	if(award != null) {
		awardAmount();
	}
	if(fileUp != null) {
		uploadFiles();
	}
	
}

function appResponse() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "../ApproveReimburse");
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("update approval info");
		}
	}
	
	var id = document.getElementById("rid").innerHTML;
	var r = document.getElementById("response").value;
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.send("rid=" + id + "&response=" + r); //app response & emp id
	
	// TODO not back but like redirect
	window.history.back();
}

function aPostGradeUpdate() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "../UpdateGradeServlet");
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("update grade");
		}
	}
	
	var r = document.getElementById("rid").innerHTML;
	var g = document.getElementById("grade").value;
	g = parseInt(g);
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.send("rid=" + r + "&grade=" + g);
}

// TODO parameterize function maybe
// TODO send subject to servlet and modify infoadd servlet to take parameter
function insertAddInfo() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "../InsertNewAddedInfoServlet");
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("info added/req");
		}
	}
	
	var r = document.getElementById("response");
	var ai = document.getElementById("reqinfo");
	var addinfo = document.getElementById("addinfo");
	
	var rid = document.getElementById("rid").innerHTML;
	parseInt(rid);
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	if(r != null && r.value == 0) {
		// TODO BUG message posting twice when denied
		var dr = document.getElementById("denyres").value;
		dr = "DENIED: " + dr;
		xhr.send("rid=" + rid + "&info=" + dr + "&subject=" + "DENIED");
	} else if(ai != null && ai.value != ""){
		var ai = ai.value;
		xhr.send("rid=" + rid + "&info=" + ai + "&subject=" + "REQUEST");
	} else if(addinfo != null && addinfo.value != "") {
		xhr.send("rid=" + rid + "&info=" + addinfo.value + "&subject=" + "RESPONSE");
	}
}

function updateInfoReq() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "../UpdateInfoReqServlet");
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("update info req empid");
		}
	}
	
	var r = document.getElementById("rid").innerHTML;
	var rei = document.getElementById("reqinfoemp").value;
	r = parseInt(r);
	rei = parseInt(rei);
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.send("rid=" + r + "&info_empid=" + rei);
}

function updateProjReimb() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "../UpdateProjReimb");
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("update projReimb");
		}
	}
	
	var r = document.getElementById("rid").innerHTML;
	var pr = document.getElementById("projreimb").value;
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	if(pr != "") {
		xhr.send("rid=" + r + "&projreimb=" + pr); 
		sendEmail();
	}	
}

function sendEmail() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "../SendEmailServlet");
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("send an email");
		}
	}	
	
	xhr.send();
}

function awardAmount() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "../AwardAmountServlet");  // TODO servlet to award amount also change what approve does in terms of money
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("Award reimburse amount");
		}
	}
	
	var id = document.getElementById("rid").innerHTML;
	var a = document.getElementById("award").value;
	var pr = document.getElementById("projreimb").value;
	var ar = document.getElementById("availreimb").innerHTML;
	
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	if(a != -1) {
		console.log(pr);
		xhr.send("rid=" + id + "&award=" + a + "&projreimb=" + pr + "&availreimb=" + ar);
	}
}

function uploadFiles() {
	var inFiles = document.getElementById("inputFile");
	var files = inFiles.files;
	var formattype = document.getElementsByName("formattype");
	var formatVal = -1;
	var canUpload = false;
	
	for(var j = 0; j < formattype.length; j++) {
		if(formattype[j].checked) {
			formatVal = formattype[j].value;
			canUpload = true;
			break;
		}
	}
	
	if(canUpload) {
		var formData = new FormData();
		
		var rid = document.getElementById("rid").innerHTML;
		formData.append("rid", rid);
		formData.append("format", formatVal);
		//var data = "rid=" + encodeURIComponent(rid);
		
		for(var i = 0; i < files.length; i++) {
			var file = files[i];
			
			// TODO file type matching 
			var input = "input" + i;
			formData.append('inputs[]', file, file.name);
			//data = data + "&" + input + "=" + encodeURIComponent(file);
		}
		

		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "../UserAddAttachServlet");
		
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				console.log("Files uploaded");
			}
		}
		
		//xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		xhr.send(formData);
	} else if(files.length > 0) {
		alert("Must select attachment type to submit attachments!")
	}
	
}