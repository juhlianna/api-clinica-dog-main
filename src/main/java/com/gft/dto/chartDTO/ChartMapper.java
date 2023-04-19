package com.gft.dto.chartDTO;

import com.gft.entities.Chart;

public class ChartMapper {
	
	public static Chart fromDTO(RegistryChartDTO dto) {
		
		return new Chart(null, dto.getAttendance(), dto.getExams(), dto.getMedicaments(), dto.getDiagnostic(), dto.getDescription());
	}
	
	public static ConsultationChartDTO fromEntity(Chart chart) {
		
		return new ConsultationChartDTO(chart.getId(), chart.getAttendance(), chart.getExams(), chart.getMedicaments(), 
				chart.getDiagnostic(), chart.getDescription());
	}

}
