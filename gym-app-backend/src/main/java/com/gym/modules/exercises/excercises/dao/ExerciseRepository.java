package com.gym.modules.exercises.excercises.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.common.dao.BaseRepository;
import com.gym.modules.exercises.excercises.model.Exercise;

@Repository
public interface ExerciseRepository extends BaseRepository<Exercise, Long>, JpaSpecificationExecutor<Exercise> {

	@Modifying
	@Query("update Exercise set videoName = :videoName where id = :id")
	void updateVideoName(String videoName, Long id);
	
	@Modifying
	@Query("update Exercise set imageName = :imageName where id = :id")
	void updateImageName(String imageName, Long id);

}
