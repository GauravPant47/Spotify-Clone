window.addEventListener('DOMContentLoaded', adjustCards);

function adjustCards() {
    const cardContainer = document.getElementById('card-container');
    const list = cardContainer.getElementsByClassName('list');

    const containerWidth = cardContainer.offsetWidth;
    const cardWidth = list[0].offsetWidth;

    const cardsPerRow = Math.floor(containerWidth / cardWidth);
    const marginSpace = (containerWidth % cardWidth) / (cardsPerRow - 1);

    for (let i = 0; i < list.length; i++) {
        list[i].style.marginRight = marginSpace + 'px';
    }
}
