package net.Spotify.controller;

import java.io.File;

//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import net.Spotify.payload.Response;
//import net.Spotify.service.FileDatabasesService;



@Controller
public class FileUploadController {
//	@Autowired
//	private FileDatabasesService databasesService;

//	@PostMapping("/uploadFile")
//	public Response uploadFile(@RequestParam("file") MultipartFile file) {
//		FilesInDatabases fileName = databasesService.storeFile(file);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile")
//				.path(fileName.getFileName()).toUriString();
//
//		return new Response(fileName.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
//	}
//
//	@PostMapping("/uploadMultipleFiles")
//	public List<Response> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
//	}
	
	
	 @PostMapping("/upload")
	    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
	        // Check if the uploaded file is not empty
	        if (!file.isEmpty()) {
	            try {
	                // Save the file to a specific location
	                String filePath = "/path/to/save/file/" + file.getOriginalFilename();
	                file.transferTo(new File(filePath));
	                return "File uploaded successfully!";
	            } catch (Exception e) {
	                return "Failed to upload the file!";
	            }
	        } else {
	            return "You must select a file to upload!";
	        }
	    }
}