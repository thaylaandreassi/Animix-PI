var menuList = document.getElementById("menulist");

menuList.style.maxHeight = "0px"

function togglemenu() {
    if (menuList.style.maxHeight) 
        menuList.style.maxHeight = "130px"
        else 
        menuList.style.maxHeight = "0px"

}