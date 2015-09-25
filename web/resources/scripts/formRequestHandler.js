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

function init(){
$(document).ready(function(){
    $('#msg').html("This is updated by jQuery from the js file")
});
}
function testAlert(){
alert("this is a test message");
}
function processForm(form, that){
    alert('submitting form yoyo');
    //$(client).fadeIn(1000);
    processOutGoingData(form,that);
}

function processOutGoingData(form, checkBoxNames){
    for(var i=0;i<checkBoxNames.length;i++)
        formProcessor(form,checkBoxNames[i]);
}
function formProcessor(form,checkBoxName){

    var csv = getCSV(checkBoxName);
    window.alert(csv);
    var checkBoxArray = document.getElementsByName(checkBoxName);
    for(var i=0;i<checkBoxArray.length;i++) {
        var checkBox = checkBoxArray[i];
        document.getElementById(checkBox.id);
        checkBox.checked = false;
    }
    var addressNode = document.createElement("input");
    addressNode.setAttribute('type','hidden');
    addressNode.setAttribute('name',checkBoxName);
    addressNode.setAttribute('value',csv);
    form.appendChild(addressNode);
}
function getCSV(checkboxName){
    var csv = "";
    var checkboxArray = document.getElementsByName(checkboxName);
    for(var i=0;i<checkboxArray.length;i++){
        if(checkboxArray[i].checked){
            //alert(checkboxArray[i].value);
            csv = csv + checkboxArray[i].value + " , ";
        }
    }
    return csv;
}

function selectCheckBoxes(checkboxName, csvValue) {
    var checkboxes = document.getElementsByName(checkboxName);
    var refValues = csvValue.split(" , ");
    for (var i = 0; i < checkboxes.length; i++) {
        var checkbox = checkboxes[i];
        var value = checkbox.value;
        for (var j = 0; j < refValues.length; j++) {
            if (refValues[j].localeCompare(value) == 0)
                checkbox.checked = true;
            break;
        }
    }
}