package com.project.employeeperformence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(generator ="UUID")
    @GenericGenerator(name ="UUID", strategy ="org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    @JsonIgnore
    private UUID uuid;

    private String empName;

    private String profile;

    @Column(name="empNo", unique = true)
    private String empNo;

    private String teamWork;

    private String goalSettings;

    private String timeManagement;

    @JsonIgnore
    private String attendance;

    private String overAllPerformance;

    private String typeOfBand;

    private String skills;

    private String languages;

    public Employee(){

    }

    public Employee(String empName , String empNo, String profile,
                    String teamWork, String goalSettings, String timeManagement, String attendance,
                    String overAllPerformance, String skills,
                    String languages, String typeOfBand){
        this.empName = empName;
        this.empNo = empNo;
        this.profile = profile;
        this.teamWork = teamWork;
        this.goalSettings = goalSettings;
        this.timeManagement = timeManagement;
        this.attendance = attendance;
        this.overAllPerformance = overAllPerformance;
        this.skills = skills;
        this.languages = languages;
        this.typeOfBand = typeOfBand;
    }


}
