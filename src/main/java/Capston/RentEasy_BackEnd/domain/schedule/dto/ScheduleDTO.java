package Capston.RentEasy_BackEnd.domain.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    private String task;
    private LocalDate startDate;
    private LocalDate endDate;
}
