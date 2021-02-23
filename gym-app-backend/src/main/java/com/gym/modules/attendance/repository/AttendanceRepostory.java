package com.gym.modules.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.modules.attendance.model.Attendance;

@Repository
public interface AttendanceRepostory extends JpaRepository<Attendance, Long> {

}
