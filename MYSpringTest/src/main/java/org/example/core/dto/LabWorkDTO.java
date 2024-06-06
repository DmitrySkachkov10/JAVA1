package org.example.core.dto;

import java.util.Objects;

public class LabWorkDTO {
    private String grade;

    private boolean passed;

    private String name;

    private Integer labworkId;

    private Integer resultId;

    public LabWorkDTO(String grade, boolean passed, String name, Integer labworkId, Integer resultId) {
        this.grade = grade;
        this.passed = passed;
        this.name = name;
        this.labworkId = labworkId;
        this.resultId = resultId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLabworkId() {
        return labworkId;
    }

    public void setLabworkId(Integer labworkId) {
        this.labworkId = labworkId;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }
}
