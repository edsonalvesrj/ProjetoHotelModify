function formatar(mascara, documento) {

    var i = documento.value.length;
    var saida = mascara.substring(0, 1);
    var texto = mascara.substring(i)

    if (texto.substring(0, 1) != saida) {
        documento.value += texto.substring(0, 1);
    }
}

function validacpf(value){
    
   var cpf = value.replace(/[^\d]+/g, '');
    if (cpf == '')
        return false;

    if (cpf.length != 11)
        return false;

    // testa se os 11 digitos são iguais, que não pode.
    var valido = 0;
    for (i = 1; i < 11; i++) {
        if (cpf.charAt(0) != cpf.charAt(i))
            valido = 1;
    }
    if (valido == 0)
        return false;


    var  aux = 0;
    for (i = 0; i < 9; i ++)
         aux += parseInt(cpf.charAt(i)) * (10 - i);
    var check = 11 - (aux % 11);
    if (check == 10 || check == 11)
        check = 0;
    if (check != parseInt(cpf.charAt(9)))
        return false;

    aux = 0;
    for (i = 0; i < 10; i ++)
        aux += parseInt(cpf.charAt(i)) * (11 - i);
    check = 11 - (aux % 11);
    if (check == 10 || check == 11)
        check = 0;
    if (check != parseInt(cpf.charAt(10)))
        return false;
    return true;

}
