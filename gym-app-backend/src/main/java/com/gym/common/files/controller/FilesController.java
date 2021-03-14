package com.gym.common.files.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.gym.common.constant.AppConstant;
import com.gym.common.constant.AppUtils;
import com.gym.common.exception.exceptions.BusinessException;
import com.gym.common.files.model.FileInfo;
import com.gym.common.files.service.FilesStorageService;
import com.gym.common.response.ResponseMessage;
import com.gym.user.model.User;

@RestController()
@RequestMapping("/api/v1")
public class FilesController {

	 @Autowired
	 FilesStorageService storageService;

	  @PostMapping({"/upload/profile", "/upload/excercise"})
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
	    String message = "";
	    String filePath[] = getPath(request);
	    if (filePath == null) {
	    	throw new BusinessException("file path not found");
	    }
	    try {
	      storageService.save(file, filePath[0], filePath[1]);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }

	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	  
	  
	  private  String[] getPath(HttpServletRequest req) {
			String uri = req.getRequestURI();
			String uploadType = uri.substring(uri.lastIndexOf("/") + 1);
			switch (uploadType) {
			case "profile":
				Optional<User> loggedUser = AppUtils.getCurrentUser();
				String userId = null;
				if (loggedUser.isPresent()) {
					userId = loggedUser.get().getId().toString();
				}
				AppUtils.removeFileIfExist(AppConstant.UPLOAD_PROFILE_PATH, userId);
				return new String[]{AppConstant.UPLOAD_PROFILE_PATH, userId};
			case "excercise":
				return new String[]{AppConstant.UPLOAD_EXCERCISES_PATH, null};
			default:
				return null;
			}
		}
}
