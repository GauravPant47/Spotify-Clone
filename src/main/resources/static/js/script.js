var audioPlayer = document.getElementById('audioPlayer');
var playBtn = document.getElementById('playBtn');
var prevBtn = document.getElementById('prevButton');
var nextBtn = document.getElementById('nextButton');
var songTitle = document.getElementById('songTitle');
var songArtist = document.getElementById('songArtist');
var currentTimeStamp = document.getElementById('currentTime');
var durationTimeStamp = document.getElementById('duration');
var progressBar = document.getElementById('myProgressBar');

let isPlaying = false;
let currentSongIndex = 0;

function togglePlay(id) {
	var songUrl = '/audio/' + id;
	if (isPlaying) {
		audioPlayer.src = songUrl + '/pause';
		audioPlayer.pause();
		playBtn.innerHTML = '<i class="fa fa-play"></i>';
		currentSongIndex = id;
	}
	else {
		audioPlayer.src = songUrl + '/play';
		audioPlayer.play();
		playBtn.innerHTML = '<i class="fa fa-pause"></i>';
	}
	isPlaying = !isPlaying;
}
document.getElementById('playBtn').addEventListener('click', togglePlay);

function playNext(id) {
	id = currentSongIndex;
	var songUrl = '/audio/' + id;
	if (isPlaying) {
		audioPlayer.src = songUrl + '/play';
		audioPlayer.play();
		currentSongIndex++;
	}
}
document.getElementById('nextBtn').addEventListener('click', playNext);

function playPrevious(id) {
	id = currentSongIndex;
	var songUrl = '/audio/' + id;
	if (isPlaying) {
		audioPlayer.src = songUrl + '/play';
		audioPlayer.play();
		currentSongIndex--;
	}
}
document.getElementById('prevBtn').addEventListener('click', playPrevious);


function updateProgress() {
	var progressPercentage = (audioPlayer.currentTime / audioPlayer.duration) * 100;
	progressBar.style.width = progressPercentage + '%';

	// Update current time stamp
	var currentTime = formatTime(audioPlayer.currentTime);
	currentTimeStamp.textContent = currentTime;
}

function formatTime(time) {
	var minutes = Math.floor(time / 60);
	var seconds = Math.floor(time % 60);
	seconds = seconds < 10 ? '0' + seconds : seconds;
	return minutes + ':' + seconds;
}

audioPlayer.addEventListener('timeupdate', updateProgress);

audioPlayer.addEventListener('ended', function () { playNext(id) });

progressBar.addEventListener('click', function (e) {
	var seekTime = (e.offsetX / progress.offsetWidth) * audioPlayer.duration;
	audioPlayer.currentTime = seekTime;
});





