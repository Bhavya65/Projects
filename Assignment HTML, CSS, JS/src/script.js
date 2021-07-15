//adding data to table when clicked button

document.getElementById('btnAddData').onclick = function() {
    $("#Outer").fadeIn(1000)
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var website = document.getElementById("website").value;
    var imageLink = document.getElementById("imageLink").value;
    var gender = document.querySelector('input[name="gender"]:checked').value;
    var markedCheckbox = document.getElementsByName('skill');
    var res = "";
    var rows = "";
    var error = document.getElementById("error") 
    var patt = new RegExp("@");
    if (patt.test(document.getElementById("email").value))
    {
        
    }
    else{
        alert("You have entered an invalid email address!")
        return (false)
    }

    var patt = new RegExp("http");
    if (patt.test(document.getElementById("website").value))
    {
        
    }
    else{
        alert("You have entered an invalid website!")
        return (false)
    }

    var patt = new RegExp("http");
    if (patt.test(document.getElementById("imageLink").value))
    {
        
    }
    else{
        alert("You have entered an invalid Image Link!")
        return (false)
    }

    if (name.length>0)
    {
        
    }
    else{
        alert("You have entered an invalid name!")
        return (false)
    }

    for (var checkbox of markedCheckbox) {  
      if (checkbox.checked)
        res += checkbox.value + ",";
    }
    res = res.substring(0,res.length-1);

    var img = document.createElement("img")
    img.source = imageLink;

    var website = website.link(website);

    rows += "<tr><td>" + name.bold()  +  "<br />" + email + "<br />" + website + "<br/>" + gender +  "<br />" +  res + "</td><td>" + 
    '<img src="'+ imageLink +'"  height="'+100+'" width="'+100+'" />' + "</td></tr>";
    $(rows).appendTo("#list tbody");


  }  

//for reset button

function ResetForm(){
    document.getElementById("InputEntries").reset();
}