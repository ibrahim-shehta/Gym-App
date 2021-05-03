package com.gym.modules.exercises.excercises.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.gym.common.service.impl.BaseServiceWithSepecificationImpl;
import com.gym.modules.exercises.excercises.dao.ExerciseRepository;
import com.gym.modules.exercises.excercises.dao.specification.ExerciseSpecification;
import com.gym.modules.exercises.excercises.model.Exercise;
import com.gym.modules.exercises.excercises.service.ExerciseService;

@Service
public class ExerciseServiceImpl extends BaseServiceWithSepecificationImpl<Exercise, Long> implements ExerciseService {

	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Override
	public ExerciseRepository getRepository() {
		return exerciseRepository;
	}

	@Override
	public ExerciseRepository getSpecificationRepository() {
		return exerciseRepository;
	}

	@Override
	public Specification<Exercise> getSpecifications(Map<String, Object> filterDataMap) {
		return ExerciseSpecification.filterExercises(filterDataMap);
	}
	


}
