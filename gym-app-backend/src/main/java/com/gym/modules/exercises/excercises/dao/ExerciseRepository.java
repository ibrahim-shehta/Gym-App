package com.gym.modules.exercises.excercises.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.modules.exercises.excercises.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>, JpaSpecificationExecutor<Exercise> {

	@Modifying
	@Query("update Exercise set vedioPath = :fileName where id = :id")
	void updateVedeoName(String fileName, Long id);
	
	@Modifying
	@Query("update Exercise set imagePath = :fileName where id = :id")
	void updateImageName(String fileName, Long id);

}
