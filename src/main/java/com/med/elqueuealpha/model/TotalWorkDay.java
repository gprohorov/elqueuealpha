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
    private int cashCV;         // сума Черновцы
    private int cashKL;         // сума Клишковцы
    private int cashMG;         // сума Мигово
    private int totalProcedure; // общая процедуры
    private int totalCash;      //

    public TotalWorkDay() { }

    public TotalWorkDay(LocalDate date, int procedureCV, int procedureKL,
                        int procedureMG, int cashCV, int cashKL, int cashMG,
                        int totalProcedure, int totalCash) {
        this.date = date;
        this.procedureCV = procedureCV;
        this.procedureKL = procedureKL;
        this.procedureMG = procedureMG;
        this.cashCV = cashCV;
        this.cashKL = cashKL;
        this.cashMG = cashMG;
        this.totalProcedure = totalProcedure;
        this.totalCash = totalCash;
    }

    public TotalWorkDay(String id, LocalDate date, int procedureCV,
                        int procedureKL, int procedureMG, int cashCV,
                        int cashKL, int cashMG, int totalProcedure,
                        int totalCash) {
        this.id = id;
        this.date = date;
        this.procedureCV = procedureCV;
        this.procedureKL = procedureKL;
        this.procedureMG = procedureMG;
        this.cashCV = cashCV;
        this.cashKL = cashKL;
        this.cashMG = cashMG;
        this.totalProcedure = totalProcedure;
        this.totalCash = totalCash;
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

    public int getCashCV() {
        return cashCV;
    }

    public void setCashCV(int cashCV) {
        this.cashCV = cashCV;
    }

    public int getCashKL() {
        return cashKL;
    }

    public void setCashKL(int cashKL) {
        this.cashKL = cashKL;
    }

    public int getCashMG() {
        return cashMG;
    }

    public void setCashMG(int cashMG) {
        this.cashMG = cashMG;
    }

    public int getTotalProcedure() {
        return totalProcedure;
    }

    public void setTotalProcedure(int totalProcedure) {
        this.totalProcedure = totalProcedure;
    }

    public int getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
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
                ", cashCV=" + cashCV +
                ", cashKL=" + cashKL +
                ", cashMG=" + cashMG +
                ", totalProcedure=" + totalProcedure +
                ", totalCash=" + totalCash +
                '}';
    }
}
