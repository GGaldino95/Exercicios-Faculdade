function validarcpf (cpf) {
  var numeros, digitos, soma, i, resultado, digitos_iguais;
  digitos_iguais = 1;
  
  if (cpf.length < 11)
        return false;
	
  for (i = 0; i < cpf.length - 1; i++)
        if (cpf.charAt(i) != cpf.charAt(i + 1))
              {
              digitos_iguais = 0;
              break;
              }
			  
  if (!digitos_iguais) {
        numeros = cpf.substring(0,9);
        digitos = cpf.substring(9);
        soma = 0;
        
		for (i = 10; i > 1; i--)
              soma += numeros.charAt(10 - i) * i;
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
		
        if (resultado != digitos.charAt(0))
              return false;
        numeros = cpf.substring(0,10);
        soma = 0;
		
        for (i = 11; i > 1; i--)
              soma += numeros.charAt(11 - i) * i;
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        
		if (resultado != digitos.charAt(1))
              return false;
        return true;
        } else {
        return false;
		}
}

function mensagem()
{
  document.getElementById('valido').style.display = 'none'; 
  document.getElementById('invalido').style.display = 'none'; 
  var cpf = document.getElementById('cpf').value;
  
  if(validarcpf(cpf)) {
	document.getElementById('cpf').style.border ="1px solid green";
	document.getElementById('button').className = 'aprova';
	document.getElementById('button').value = "CPF Válido ✓";
  } else {
	document.getElementById('cpf').style.border ="1px solid red";
	document.getElementById('button').className = 'desaprova';
	document.getElementById('button').value = "CPF Inválido X"
  }
}
