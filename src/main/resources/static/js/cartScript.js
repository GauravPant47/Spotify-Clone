function adjustCartLayout() {
    var items = document.getElementsByClassName("item");
    var itemsPerLine = 6; // Change this value if you want a different number of items per line

    for (var i = 0; i < items.length; i += itemsPerLine) {
        var lineItems = Array.from(items).slice(i, i + itemsPerLine);
        var lineHeight = Math.max(...lineItems.map(item => item.offsetHeight));
        lineItems.forEach(item => item.style.height = lineHeight + "px");
    }
}

window.addEventListener("resize", adjustCartLayout);
window.addEventListener("DOMContentLoaded", adjustCartLayout);