package Capston.RentEasy_BackEnd.domain.document.domain;

import Capston.RentEasy_BackEnd.domain.building.domain.Building;
import Capston.RentEasy_BackEnd.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "document")
public class Document extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "attachment", nullable = false)
    private String fileContent;

    @JoinColumn(columnDefinition = "varchar(20)", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;
}
