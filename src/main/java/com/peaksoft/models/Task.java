package com.peaksoft.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.TemporalType.DATE;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @SequenceGenerator(name = "task_seq", sequenceName = "task_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    private Long id;

    @Column(length = 100000,name = "task_name")
    private String taskName;

    @Column(length = 100000,name = "task_text")
    private String taskText;

    @Temporal(DATE)
    @Column(length = 100000,name = "deadline")
    private Date deadline;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {PERSIST,MERGE,REFRESH,DETACH})
    private Lesson lesson;

    public Task(String taskName, String taskText, Date deadline) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadline = deadline;
    }
}
