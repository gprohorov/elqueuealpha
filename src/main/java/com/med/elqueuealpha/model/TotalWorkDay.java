package com.med.elqueuealpha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class TotalWorkDay {
    @Id
    private String id;
    private LocalDate date;     // дата
    private int procedureCV;    // процедуры  Черновцы
    private int procedureKL;    // процедуры  Клишковцы
    private int procedureMG;    // процедуры  Мигово
    private int totalCV;        // сума Черновцы
    private int totalKL;        // сума Клишковцы
    private int totalMG;        // сума Мигово

    public TotalWorkDay() { }

    public TotalWorkDay(LocalDate date, int procedureCV, int procedureKL, int procedureMG, int totalCV, int totalKL, int totalMG) {
        this.date = date;
        this.procedureCV = procedureCV;
        this.procedureKL = procedureKL;
        this.procedureMG = procedureMG;
        this.totalCV = totalCV;
        this.totalKL = totalKL;
        this.totalMG = totalMG;
    }

    public TotalWorkDay(String id, LocalDate date, int procedureCV, int procedureKL, int procedureMG, int totalCV, int totalKL, int totalMG) {
        this.id = id;
        this.date = date;
        this.procedureCV = procedureCV;
        this.procedureKL = procedureKL;
        this.procedureMG = procedureMG;
        this.totalCV = totalCV;
        this.totalKL = totalKL;
        this.totalMG = totalMG;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getProcedureCV() {
        return procedureCV;
    }

    public void setProcedureCV(int procedureCV) {
        this.procedureCV = procedureCV;
    }

    public int getProcedureKL() {
        return procedureKL;
    }

    public void setProcedureKL(int procedureKL) {
        this.procedureKL = procedureKL;
    }

    public int getProcedureMG() {
        return procedureMG;
    }

    public void setProcedureMG(int procedureMG) {
        this.procedureMG = procedureMG;
    }

    public int getTotalCV() {
        return totalCV;
    }

    public void setTotalCV(int totalCV) {
        this.totalCV = totalCV;
    }

    public int getTotalKL() {
        return totalKL;
    }

    public void setTotalKL(int totalKL) {
        this.totalKL = totalKL;
    }

    public int getTotalMG() {
        return totalMG;
    }

    public void setTotalMG(int totalMG) {
        this.totalMG = totalMG;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalWorkDay that = (TotalWorkDay) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TotalWorkDay{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", procedureCV=" + procedureCV +
                ", procedureKL=" + procedureKL +
                ", procedureMG=" + procedureMG +
                ", totalCV=" + totalCV +
                ", totalKL=" + totalKL +
                ", totalMG=" + totalMG +
                '}';
    }
}
