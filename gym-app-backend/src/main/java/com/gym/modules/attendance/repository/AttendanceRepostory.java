package com.gym.modules.attendance.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gym.modules.attendance.model.Attendance;

@Repository
public interface AttendanceRepostory extends JpaRepository<Attendance, Long> {

	@Modifying
	@Query("update Attendance a set a.signOut = :signOut where a.id = :id")
	public void signOut(String signOut, Long id);
	
	@Query("select a from Attendance a join a.excerciseCategory ec where a.user.id = :userId")
	Page<Attendance> getUserAttendance(Long userId, Pageable page);
	
	boolean existsByUserIdAndDate(Long userId, Date date);
}
