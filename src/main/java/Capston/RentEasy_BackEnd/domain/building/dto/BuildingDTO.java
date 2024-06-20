package Capston.RentEasy_BackEnd.domain.building.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingDTO {
    private String buildingName;
    private String address;
}
