package org.example.core.dto;

public class LabWorkDTOBuilder {
    private String grade;
    private boolean passed;
    private String name;
    private Integer labworkId;
    private Integer resultId;

    public LabWorkDTOBuilder setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public LabWorkDTOBuilder setPassed(boolean passed) {
        this.passed = passed;
        return this;
    }

    public LabWorkDTOBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public LabWorkDTOBuilder setLabworkId(Integer labworkId) {
        this.labworkId = labworkId;
        return this;
    }

    public LabWorkDTOBuilder setResultId(Integer resultId) {
        this.resultId = resultId;
        return this;
    }

    public LabWorkDTO build() {
        return new LabWorkDTO(grade, passed, name, labworkId, resultId);
    }
}