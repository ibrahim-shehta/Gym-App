package com.gym.modules.attendance.repository;

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
}
