var audioPlayer = document.getElementById('audioPlayer');
var playButton = document.getElementById('playButton');
var prevButton = document.getElementById('prevButton');
var nextButton = document.getElementById('nextButton');
var progress = document.getElementById('progress');
var songTitle = document.getElementById('songTitle');
var artist = document.getElementById('artist');
var currentTimeStamp = document.getElementById('currentTime');
var durationTimeStamp = document.getElementById('duration');

var playlist = [
  {
    title: 'Song 1',
    artist: 'Artist 1',
    source: './02 Main Dhoondne Ko Zamaane Mein (Heartless) - Arijit Singh.mp3'
  },
  {
    title: 'Song 2',
    artist: 'Artist 2',
    source: './06 - Rockstar (2011) - Hawaa Hawaa [www.DJMaza.Com].mp3'
  },
  {
    title: 'Song 3',
    artist: 'Artist 3',
    source: './06 Tere Binaa (Mustafa Zahid) - Heropanti [PagalWorld.com].mp3'
  }
];
var currentSongIndex = 0;

function loadSong() {
  var currentSong = playlist[currentSongIndex];
  audioPlayer.src = currentSong.source;
  songTitle.textContent = currentSong.title;
  artist.textContent = currentSong.artist;
}

function playSong() {
  audioPlayer.play();
  playButton.innerHTML = '<i class="fas fa-pause"></i>';
}

function pauseSong() {
  audioPlayer.pause();
  playButton.innerHTML = '<i class="fas fa-play"></i>';
}

function prevSong() {
  currentSongIndex = (currentSongIndex - 1 + playlist.length) % playlist.length;
  loadSong();
  playSong();
}

function nextSong() {
  currentSongIndex = (currentSongIndex + 1) % playlist.length;
  loadSong();
  playSong();
}

function updateProgress() {
  var progressPercentage = (audioPlayer.currentTime / audioPlayer.duration) * 100;
  progress.style.width = progressPercentage + '%';

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

audioPlayer.addEventListener('ended', function() {
  nextSong();
});

playButton.addEventListener('click', function() {
  if (audioPlayer.paused) {
    playSong();
  } else {
    pauseSong();
  }
});

prevButton.addEventListener('click', prevSong);

nextButton.addEventListener('click', nextSong);

loadSong();

// Seek through the song using the progress bar
progress.addEventListener('click', function(e) {
  var seekTime = (e.offsetX / progress.offsetWidth) * audioPlayer.duration;
  audioPlayer.currentTime = seekTime;
});