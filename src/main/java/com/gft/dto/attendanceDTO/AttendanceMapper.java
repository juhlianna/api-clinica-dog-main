package com.gft.dto.attendanceDTO;

import com.gft.entities.Attendance;

public class AttendanceMapper {
	
	public static Attendance fromDTO(RegistryAttendanceDTO dto) {
		
		return new Attendance(null, dto.getDate(), dto.getHour(), dto.getCost(), dto.getDog(), dto.getVeterinarian(), dto.getTypeOfService());
	}
	
	public static ConsultationAttendanceDTO fromEntity(Attendance attendance) {
		
		return new ConsultationAttendanceDTO(attendance.getId(), attendance.getDate(), attendance.getHour(), 
				attendance.getCost(), attendance.getDog(), attendance.getVeterinarian(), attendance.getTypeOfService());
	}

}
