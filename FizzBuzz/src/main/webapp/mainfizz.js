
function validate() {
	var num1 = document.getElementById("num1").value;
	var num2 = document.getElementById("num2").value;
	if (num1 == num2 || num1 <= 0 || num2 <= 0 || num1 > 100 || num2 > 100 || isNaN(num1) || isNaN(num2)) {
		document.getElementById("error").innerHTML = "<h2>Enter positive numbers up to 100, Preferably integers!</h2>";
		return;
	}
	var x = parseInt(num1);
	var y = parseInt(num2);
	document.getElementById("error").innerHTML = "<h1>FIZZBUZZ!!!!</h1>";
	document.getElementById("inputs").innerHTML = "<h1>WOAH!!! FIZZBUZZ!!!!</h1>";
	var bText = document.createTextNode("AGAIN??");
	var f = document.createElement('form'); //<form></form>
	f.setAttribute('action', '/FizzBuzz/index.html'); //<form action="/index.html"></form>
	var b = document.createElement('button'); //<button></button>
	b.appendChild(bText); //<button>AGAIN??</button>
	f.appendChild(b);
	document.getElementById("inputs").appendChild(f);
	fizzbuzz(x,y);
}

function fizzbuzz(x,y) {
	var max;
	var min;
	var fizzBuzz;
	if (x > y) {
		max = x;
		min = y;
	} else {
		max = y;
		min = x;
	}
	
	//fizzbuzz!!!!
	for (var i = min; i <= max; i++) { 
	    if (i%15 == 0) fizzBuzz = "FizzBuzz!!!";
	    else if (i%3 == 0) fizzBuzz = "Fizz!!!";
	    else if(i%5 == 0) fizzBuzz = "Buzz!!!";
	    else fizzBuzz = i;
	    var number = document.createTextNode(i); //Input
		var fb = document.createTextNode(fizzBuzz); //Input
	    var td1 = document.createElement('td'); 
		var td2 = document.createElement('td');
		td1.appendChild(number);
		td2.appendChild(fb);
		var row = document.createElement('tr');
		row.appendChild(td1);
		row.appendChild(td2);
		document.getElementById("buzz").appendChild(row);
	}
}