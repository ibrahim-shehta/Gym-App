package com.gym.common.constant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.gym.security.model.MyUserDetails;
import com.gym.user.model.User;

public abstract class AppUtils {

	public static String getCurrentTime() {
		return LocalTime.now().toString().substring(0, 5);
	}

	public static String getCurrentDate() {
		return LocalDate.now().toString();
	}

	public static LocalDate convertDateToLocalDate(Date dateToConvert) {
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateToConvert));

	}

	public static Long getDurationInDays(LocalDate date1, LocalDate date2) {
		return Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays();
	}

	public static boolean isInteger(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static Optional<User> getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) { // if user logged in return current
																				// logged user
			UsernamePasswordAuthenticationToken myUsernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) auth;
			MyUserDetails myUserDetails = (MyUserDetails) myUsernamePasswordAuthenticationToken.getPrincipal();
			return Optional.of(myUserDetails.getUser());
		}

		return Optional.ofNullable(null);
	}

//	public static boolean removeFileIfExist(String path, String fileName) {
//		Optional<Path> op = null;
//		try (Stream<Path> stream = Files.list(Paths.get(path))) {
//			op = stream.filter(i -> {
//				String fName = i.getFileName().toString();
//				String fileNameOnly = fName.substring(0, fName.lastIndexOf("."));
//				if (fileName.equals(fileNameOnly)) {
//					try {
//						Files.delete(i);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return true;
//				} else 				
//					return false;
//			}).findFirst();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return op.isPresent();
//	}

	public static void removeFileIfExist(String path, String fileName) {
		try (Stream<Path> stream = Files.list(Paths.get(path))) {
			stream.forEach(i -> {
				String fName = i.getFileName().toString();
				if (fName.startsWith(fileName)) {
					try {
						Files.delete(i);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void deleteFileByFullPath(String fullPath) {
		Path path = Paths.get(fullPath);
		try {
			Files.delete(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
