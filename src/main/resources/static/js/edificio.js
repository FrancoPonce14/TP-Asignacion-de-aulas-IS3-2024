const icon = document.querySelector('.icon');
var search = document.querySelector('.search');
search.onmouseenter = function(){
    search.classList.toggle('active')
} 
function reset(){
    document.getElementById('mysearch').value = '';
}
 	search.onmouseleave = function(){
     search.classList.toggle('reset');
}


var welcome;  
    var date = new Date();  
    var hour = date.getHours();  
    var minute = date.getMinutes();  
    var second = date.getSeconds();  
    if (minute < 10) {  
      minute = "0" + minute;  
    }  
    if (second < 10) {  
      second = "0" + second;  
    }  
    if (hour < 12) {  
      welcome = "good morning";  
    } else if (hour < 17) {  
      welcome = "good afternoon";  
    } else {  
      welcome = "good evening";  
    } 
$(document).ready(function(){
	const body = document.querySelector('body');
	const toggled = document.getElementById('toggle');
toggled.onclick = function(){
		body.classList.toggle('light');
	toggled.classList.toggle('active')
}
	$('#dashboard').mouseenter(function(){
		this.innerHTML = `${welcome}`;
	});
	$('#dashboard').mouseleave(function(){
		this.innerHTML = "DASHBOARD";
	});
	$('#grupo23').mouseenter(function(){
		this.innerHTML = "Bienvenido";
	});
	$('#grupo23').mouseleave(function(){
		this.innerHTML = "UNLa";
	});
});
$('#df-contact').click(function() {
  $('.df-modal').css('z-index', '999');
  $('html').addClass('df-modal-active');
});

$('.df-modal-overlay').click(function() {
  $('html').removeClass('df-modal-active');
  setTimeout(function() {
    $('.df-modal').css('z-index', '-999')
  }, 500);
});