package com.employeemanagement.manage_employee.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="work_info")
public class WorkDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String work_id;
    private String work_name;
    private String work_description;
    private Timestamp alloted_time;
    private Timestamp completion_time;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="mng_id")
    private ManagerDetails managerDetails;

    public String getWork_description() {
        return work_description;
    }

    public void setWork_description(String work_description) {
        this.work_description = work_description;
    }

    public String getWork_id() {
        return work_id;
    }

    public void setWork_id(String work_id) {
        this.work_id = work_id;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public Timestamp getAlloted_time() {
        return alloted_time;
    }

    public void setAlloted_time(Timestamp alloted_time) {
        this.alloted_time = alloted_time;
    }

    public Timestamp getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Timestamp completion_time) {
        this.completion_time = completion_time;
    }

    public ManagerDetails getManagerDetails() {
        return managerDetails;
    }

    public void setManagerDetails(ManagerDetails managerDetails) {
        this.managerDetails = managerDetails;
    }
}
