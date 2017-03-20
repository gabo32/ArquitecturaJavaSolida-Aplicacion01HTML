/**
 * 
 */
function validacion() {
	// uso de DOM standard a nivel de javascript 
	var isbn= document.getElementById("isbn");
	var miformulario=document.getElementById("formularioInsercion");
	
	if(isbn.value==""){
		alert("datos no validos");
		return false;
	}else{
		miformulario.submit();
	}
}