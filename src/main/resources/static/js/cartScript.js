window.addEventListener('DOMContentLoaded', adjustCards);

function adjustCards() {
    const cardContainer = document.getElementById('card-container');
    const item = cardContainer.getElementsByClassName('item');

    const containerWidth = cardContainer.offsetWidth;
    const cardWidth = item[0].offsetWidth;

    const cardsPerRow = Math.floor(containerWidth / cardWidth);
    const marginSpace = (containerWidth % cardWidth) / (cardsPerRow - 1);

    for (let i = 0; i < item.length; i++) {
        item[i].style.marginRight = marginSpace + 'px';
    }
}
