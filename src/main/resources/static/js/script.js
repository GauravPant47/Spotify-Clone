const audioPlayer = document.getElementById('audioPlayer');
const playBtn = document.getElementById('playBtn');
const prevBtn = document.getElementById('prevButton');
const nextBtn = document.getElementById('nextButton');
const songTitle = document.getElementById('songTitle');
const songArtist = document.getElementById('songArtist');
const currentTimeStamp = document.getElementById('currentTime');
const durationTimeStamp = document.getElementById('duration');
const progressBar = document.getElementById('myProgressBar');
const volumeSlider = document.getElementById('volume-slider');


let isPlaying = false;
let currentSongIndex = 0;

function togglePlay(id) {
	const songUrl = '/audio/' + id;
	if (isPlaying) {
		audioPlayer.src = songUrl + '/pause';
		audioPlayer.pause();
		playBtn.innerHTML = '<i class="fa fa-play" aria-hidden="true"></i>';
	}
	else {
		audioPlayer.src = songUrl + '/play';
		audioPlayer.play();
		playBtn.innerHTML = '<i class="fa fa-pause" aria-hidden="true"></i>';
	}
	currentSongIndex = id;
	isPlaying = !isPlaying;
}
document.getElementById('playBtn').addEventListener('click', togglePlay);



volumeSlider.addEventListener('input', () => {
	audioPlayer.volume = volumeSlider.value;
});

function playNext() {
	let id = currentSongIndex;
	const songUrl = '/audio/' + id;
	if (isPlaying) {
		audioPlayer.src = songUrl + '/play';
		audioPlayer.play();
		currentSongIndex++;
	}
}
document.getElementById('nextBtn').addEventListener('click', playNext);

function playPrevious() {
	let id = currentSongIndex;
	const songUrl = '/audio/' + id;
	if (isPlaying) {
		audioPlayer.src = songUrl + '/play';
		audioPlayer.play();
		currentSongIndex--;
	}
}
document.getElementById('prevBtn').addEventListener('click', playPrevious);


function updateProgress() {
	const progressPercentage = (audioPlayer.currentTime / audioPlayer.duration) * 100;
	progressBar.style.width = progressPercentage + '%';

	// Update current time stamp
	const currentTime = formatTime(audioPlayer.currentTime);
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

