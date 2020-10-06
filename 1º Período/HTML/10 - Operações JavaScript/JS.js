function fatorial(par) {
	var fatt = 1;
	for(var i=1;i<=par;i++){
	   fatt *=i;
	}
	document.getElementById("fatres").innerHTML = fatt;
}

function fibonacci(par){
	var num1 = 1;
	var num2 = 1;
	var fib = [1,1];
	for(var i=2;i<par;i++){
	   fib[i] = (num1 + num2);
	   num1 = num2;
	   num2 = fib[i];
	}
	document.getElementById("fibres").innerHTML = fib; 
}

function base2(par){
	var num = [];
    var j=0;
	for(var i=0;par >=2;i++){
		num[i]= par%2;
		par = parseInt(par/2);
		j=i;
	}
	num[j+1]=par;
	
	i="";
	j = num.length-1;
	for(j;j>=0;j--){
		i+=num[j];
	}	
	document.getElementById("binres").innerHTML = i; 
}
