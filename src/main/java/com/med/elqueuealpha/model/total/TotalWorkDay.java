package com.med.elqueuealpha.model.total;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document
public class TotalWorkDay {
    @Id
    private String id;
    private LocalDate date;     // дата
    private long procedureCV;    // процедуры  Черновцы
    private long procedureKL;    // процедуры  Клишковцы
    private long procedureMG;    // процедуры  Мигово
    private long cashCV;         // наличные Черновцы
    private long cashKL;         // наличные Клишковцы
    private long cashMG;         // наличные Мигово
    private long cardCV;         // электронные Черновцы
    private long cardKL;         // электронные Клишковцы
    private long cardMG;         // электронные Мигово
    private long totalProcedure; // сумма процедур
    private long totalCashCard;  // сумма наличных и электронных

    public TotalWorkDay() { }

    public TotalWorkDay(LocalDate date, long procedureCV, long procedureKL,
                        long procedureMG, long cashCV, long cashKL, long cashMG,
                        long cardCV, long cardKL, long cardMG, long totalProcedure,
                        long totalCashCard) {
        this.date = date;
        this.procedureCV = procedureCV;
        this.procedureKL = procedureKL;
        this.procedureMG = procedureMG;
        this.cashCV = cashCV;
        this.cashKL = cashKL;
        this.cashMG = cashMG;
        this.cardCV = cardCV;
        this.cardKL = cardKL;
        this.cardMG = cardMG;
        this.totalProcedure = totalProcedure;
        this.totalCashCard = totalCashCard;
    }

    public TotalWorkDay(String id, LocalDate date, long procedureCV,
                        long procedureKL, long procedureMG, long cashCV,
                        long cashKL, long cashMG, long cardCV, long cardKL,
                        long cardMG, long totalProcedure, long totalCashCard) {
        this.id = id;
        this.date = date;
        this.procedureCV = procedureCV;
        this.procedureKL = procedureKL;
        this.procedureMG = procedureMG;
        this.cashCV = cashCV;
        this.cashKL = cashKL;
        this.cashMG = cashMG;
        this.cardCV = cardCV;
        this.cardKL = cardKL;
        this.cardMG = cardMG;
        this.totalProcedure = totalProcedure;
        this.totalCashCard = totalCashCard;
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

    public long getProcedureCV() {
        return procedureCV;
    }

    public void setProcedureCV(int procedureCV) {
        this.procedureCV = procedureCV;
    }

    public long getProcedureKL() {
        return procedureKL;
    }

    public void setProcedureKL(int procedureKL) {
        this.procedureKL = procedureKL;
    }

    public long getProcedureMG() {
        return procedureMG;
    }

    public void setProcedureMG(int procedureMG) {
        this.procedureMG = procedureMG;
    }

    public long getCashCV() {
        return cashCV;
    }

    public void setCashCV(int cashCV) {
        this.cashCV = cashCV;
    }

    public long getCashKL() {
        return cashKL;
    }

    public void setCashKL(int cashKL) {
        this.cashKL = cashKL;
    }

    public long getCashMG() {
        return cashMG;
    }

    public void setCashMG(int cashMG) {
        this.cashMG = cashMG;
    }

    public long getCardCV() {
        return cardCV;
    }

    public void setCardCV(int cardCV) {
        this.cardCV = cardCV;
    }

    public long getCardKL() {
        return cardKL;
    }

    public void setCardKL(int cardKL) {
        this.cardKL = cardKL;
    }

    public long getCardMG() {
        return cardMG;
    }

    public void setCardMG(int cardMG) {
        this.cardMG = cardMG;
    }

    public long getTotalProcedure() {
        return totalProcedure;
    }

    public void setTotalProcedure(int totalProcedure) {
        this.totalProcedure = totalProcedure;
    }

    public long getTotalCashCard() {
        return totalCashCard;
    }

    public void setTotalCashCard(int totalCashCard) {
        this.totalCashCard = totalCashCard;
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
                ", cardCV=" + cardCV +
                ", cardKL=" + cardKL +
                ", cardMG=" + cardMG +
                ", totalProcedure=" + totalProcedure +
                ", totalCash=" + totalCashCard +
                '}';
    }
}
