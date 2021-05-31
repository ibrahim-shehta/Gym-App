package com.gym.modules.exercises.excercises.service.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gym.common.constant.AppConstant;
import com.gym.common.constant.AppUtils;
import com.gym.common.files.service.FilesStorageService;
import com.gym.common.service.impl.BaseAuditServiceImpl;
import com.gym.modules.exercises.excercises.dao.ExerciseRepository;
import com.gym.modules.exercises.excercises.dao.specification.ExerciseSpecification;
import com.gym.modules.exercises.excercises.model.Exercise;
import com.gym.modules.exercises.excercises.service.ExerciseService;
import com.gym.modules.settings.model.Settings;
import com.gym.modules.settings.model.enums.SettingsCode;
import com.gym.modules.settings.service.SettingsService;

@Service
@Transactional
public class ExerciseServiceImpl extends BaseAuditServiceImpl<Exercise, Long> implements ExerciseService {

	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private SettingsService settingsService;
	
	@Autowired
	private FilesStorageService filesStorageService;
	
	@Override
	public ExerciseRepository getRepository() {
		return exerciseRepository;
	}

	@Override
	public Specification<Exercise> getSpecifications(Map<String, Object> filterDataMap) {
		return ExerciseSpecification.filterExercises(filterDataMap);
	}

	@Override
	public Exercise saveFile(MultipartFile file, Long id) {
		Exercise exercise = exerciseRepository.findById(id).get();
		String fileType = file.getContentType();
		if (fileType.startsWith(AppConstant.VEDIO)) {
			Settings settings = settingsService.findByCode(SettingsCode.EXERCISE_VEDIOS_PATH);
			if (exercise.getVideoName() != null && exercise.getVideoName().trim().length() > 0)
				AppUtils.deleteFileByFullPath(settings.getValue() + exercise.getVideoName());
			String videoName = exercise.getId() + AppConstant.UNIQE_SEPERATOR  + System.currentTimeMillis() + AppConstant.MP4_FILE;
			filesStorageService.save(file, settings.getValue(), videoName);
			exerciseRepository.updateVideoName(videoName, exercise.getId());
			exercise.setVideoName(videoName);
			return exercise; 
		} else {
			Settings settings = settingsService.findByCode(SettingsCode.EXERCISE_IMAGES_PATH);
			if (exercise.getImageName() != null && exercise.getImageName().trim().length() > 0)
				AppUtils.deleteFileByFullPath(settings.getValue() + exercise.getImageName());
			String imageName = exercise.getId() + AppConstant.UNIQE_SEPERATOR  + System.currentTimeMillis() + AppConstant.GIF_FILE;
			filesStorageService.save(file, settings.getValue(), imageName);
			exerciseRepository.updateImageName(imageName, exercise.getId());
			exercise.setImageName(imageName);
			return exercise;
		}

	}
	


}
