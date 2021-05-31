package com.gym.modules.exercises.excercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gym.common.controller.BaseAuditController;
import com.gym.common.response.BaseResponse;
import com.gym.common.response.EntityResponse;
import com.gym.modules.exercises.excercises.dto.ExerciseDto;
import com.gym.modules.exercises.excercises.dto.ExerciseListDto;
import com.gym.modules.exercises.excercises.dto.mapper.ExerciseDtoMapper;
import com.gym.modules.exercises.excercises.dto.mapper.ExerciseListDtoMapper;
import com.gym.modules.exercises.excercises.model.Exercise;
import com.gym.modules.exercises.excercises.service.ExerciseService;


@Controller
@RequestMapping("/api/v1/excercises/exersise")
public class ExerciseController extends BaseAuditController<Exercise, Long, ExerciseDto, ExerciseListDto> {

	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private ExerciseDtoMapper exerciseDtoMapper;
	
	@Autowired
	private ExerciseListDtoMapper exerciseListDtoMapper;

	@Override
	protected ExerciseService getService() {
		return exerciseService;
	}
	

	@Override
	protected ExerciseDtoMapper getEntityDtoMapper() {
		return exerciseDtoMapper;
	}

	@Override
	protected ExerciseListDtoMapper getListDtoMapper() {
		return exerciseListDtoMapper;
	}
	
	
	@PostMapping("/upload/{id}")
	public ResponseEntity<BaseResponse<ExerciseDto>> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable() Long id) {
		Exercise entity = exerciseService.saveFile(file, id);
		ExerciseDto dto = getEntityDtoMapper().mapEntityToDto(entity);
		return ResponseEntity.ok(new EntityResponse<ExerciseDto>(dto));
	} 
	
}
