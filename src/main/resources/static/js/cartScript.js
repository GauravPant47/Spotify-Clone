var backwardHistory = [];
var forwardHistory = [];

function updateHistory(stateObj) {
    var url = stateObj.url;

    // Perform actions based on the URL (e.g., update page content)

    backwardHistory.push(stateObj);

    // Clear the forward history
    forwardHistory = [];

    // Enable/disable buttons based on history
    updateButtons();
}

function goBack() {
    if (backwardHistory.length > 1) {
        var currentState = backwardHistory.pop();
        forwardHistory.push(currentState);
        var previousState = backwardHistory[backwardHistory.length - 1];

        // Perform actions based on the previous state (e.g., update page content)

        history.pushState(previousState, '', previousState.url);

        // Enable/disable buttons based on history
        updateButtons();
    }
}

function goForward() {
    if (forwardHistory.length > 0) {
        var currentState = forwardHistory.pop();
        backwardHistory.push(currentState);

        // Perform actions based on the current state (e.g., update page content)

        history.pushState(currentState, '', currentState.url);

        // Enable/disable buttons based on history
        updateButtons();
    }
}

function updateButtons() {
    var backButton = document.getElementById('backButton');
    var forwardButton = document.getElementById('forwardButton');

    if (backwardHistory.length > 1) {
        backButton.disabled = false;
    } else {
        backButton.disabled = true;
    }

    if (forwardHistory.length > 0) {
        forwardButton.disabled = false;
    } else {
        forwardButton.disabled = true;
    }
}

// Add event listeners to the buttons
var backButton = document.getElementById('backButton');
backButton.addEventListener('click', goBack);

var forwardButton = document.getElementById('forwardButton');
forwardButton.addEventListener('click', goForward);

// Example usage
var initialState = { url: '/audio' };
updateHistory(initialState);

// Simulate navigation
var newState = { url: '/listSong' };
updateHistory(newState);