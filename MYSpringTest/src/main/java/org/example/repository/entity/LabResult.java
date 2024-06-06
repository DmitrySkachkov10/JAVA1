package org.example.repository.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "lab_results", schema = "5sem")
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "labwork_id", nullable = false)
    private LabWork labwork;

    @Column(name = "is_passed")
    private boolean passed;

    @Column(name = "grade", length = 10)
    private String grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LabWork getLabwork() {
        return labwork;
    }

    public void setLabwork(LabWork labwork) {
        this.labwork = labwork;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
