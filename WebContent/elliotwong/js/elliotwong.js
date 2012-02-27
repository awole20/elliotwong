function navigatePage(showdiv){
	var divs = ['gallery','about','contact','news'];
	
	for(var i = 0; i < divs.length; i++){
		document.getElementById(divs[i]).style.display = 'none';
	}
	document.getElementById(showdiv).style.display = '';
}