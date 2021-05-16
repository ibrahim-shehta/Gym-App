package com.gym.modules.exercises.excercises.service;


import org.springframework.web.multipart.MultipartFile;

import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.exercises.excercises.model.Exercise;

public interface ExerciseService extends BaseServiceWithSepecification<Exercise, Long> {

	Exercise saveFile(MultipartFile file, Long id);

}
