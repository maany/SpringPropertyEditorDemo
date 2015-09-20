/**
 * Created by Mayank on 9/13/2015.
 */
function loadScript(url, callback)
{
    // Adding the script tag to the head as suggested before
    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = url;

    // Then bind the event to the callback function.
    // There are several events for cross browser compatibility.
    script.onreadystatechange = callback;
    script.onload = callback;

    // Fire the loading
    head.appendChild(script);
}

var myPrettyCode = function() {

    // Here, do what ever you want
}
/*jQuery(document).ready(function($) {

    $('#msg').html("This is updated by jQuery")

});*/
function init(){
$(document).ready(function(){
    $('#msg').html("This is updated by jQuery from the js file")
});
}
function testAlert(){
alert("this is a test message");
}
function processForm(){
    alert('submitting form yoyo');
    $(client).fadeIn(1000);
}