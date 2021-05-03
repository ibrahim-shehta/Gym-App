package com.gym.modules.exercises.excercises.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.common.controller.BaseController;
import com.gym.common.dto.mapper.BaseMapper;
import com.gym.common.service.BaseService;
import com.gym.common.service.BaseServiceWithSepecification;
import com.gym.modules.exercises.excercises.dto.ExerciseDto;
import com.gym.modules.exercises.excercises.dto.ExerciseListDto;
import com.gym.modules.exercises.excercises.dto.mapper.ExerciseDtoMapper;
import com.gym.modules.exercises.excercises.dto.mapper.ExerciseListDtoMapper;
import com.gym.modules.exercises.excercises.model.Exercise;
import com.gym.modules.exercises.excercises.service.ExerciseService;


@Controller
@RequestMapping("/api/v1/excercises/exersise")
public class ExerciseController extends BaseController<Exercise, Long, ExerciseDto, ExerciseListDto> {

	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private ExerciseDtoMapper exerciseDtoMapper;
	
	@Autowired
	private ExerciseListDtoMapper exerciseListDtoMapper;

	@Override
	protected BaseService<Exercise, Long> getService() {
		return exerciseService;
	}
	
	@Override
	protected BaseServiceWithSepecification<Exercise, Long> getServiceWithSepecification() {
		return exerciseService;
	}

	@Override
	protected BaseMapper<Exercise, ExerciseDto> getEntityDtoMapper() {
		return exerciseDtoMapper;
	}

	@Override
	protected BaseMapper<Exercise, ExerciseListDto> getListDtoMapper() {
		return exerciseListDtoMapper;
	}
	
}