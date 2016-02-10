
$(document).ready(function () {
	  
	/** ******  collapse panel  *********************** **/
	// Close ibox function
	$('.close-link').click(function () {
	    var content = $(this).closest('div.x_panel');
	    content.remove();
	});

	// Collapse ibox function
	$('.collapse-link').click(function () {
	    var x_panel = $(this).closest('div.x_panel');
	    var button = $(this).find('i');
	    var content = x_panel.find('div.x_content');
	    content.slideToggle(200);
	    (x_panel.hasClass('fixed_height_390') ? x_panel.toggleClass('').toggleClass('fixed_height_390') : '');
	    (x_panel.hasClass('fixed_height_320') ? x_panel.toggleClass('').toggleClass('fixed_height_320') : '');
	    button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
	    setTimeout(function () {
	        x_panel.resize();
	    }, 50);
	});
	/** ******  /collapse panel  *********************** **/

});