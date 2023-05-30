package net.Spotify.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.Spotify.model.AudioFile;
import net.Spotify.payload.Response;
import net.Spotify.service.AudioFileService;

@RestController
public class AudioFileUploadController {

	@Autowired
	private AudioFileService audioFileService;

	@PostMapping("/uploadFile")
	public Response uploadFile(@RequestParam("file") MultipartFile file) {
		AudioFile audioFile = audioFileService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(audioFile.getFileName()).toUriString();

		return new Response(audioFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}
	
	@PostMapping("/uploadMultipleFile")
	public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files)
	{
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}
}
