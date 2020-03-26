package com.med.elqueuealpha.model.total;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class TotalWorkMonth {
    @Id
    private String id;
    private String month;           // числа недели
    private int year;               // год
    private int monthNumber;        // неделя в году
    private long billCV;            // насчитано по процедурам Черновцы
    private long billKL;            // насчитано по процедурам Клишковцы
    private long billMG;            // насчитано по процедурам Мигово
    private long cashCV;            // наличные Черновцы
    private long cashKL;            // наличные Клишковцы
    private long cashMG;            // наличные Мигово
    private long cardCV;            // электронные Черновцы
    private long cardKL;            // электронные Клишковцы
    private long cardMG;            // электронные Мигово
    private long totalProcedure;    // сумма процедур
    private long totalCashCard;         // сумма наличных и электронных

    public TotalWorkMonth() { }

    public TotalWorkMonth(String month, int year, int monthNumber, long billCV,
                          long billKL, long billMG, long cashCV, long cashKL,
                          long cashMG, long cardCV, long cardKL, long cardMG,
                          long totalProcedure, long totalCashCard) {
        this.month = month;
        this.year = year;
        this.monthNumber = monthNumber;
        this.billCV = billCV;
        this.billKL = billKL;
        this.billMG = billMG;
        this.cashCV = cashCV;
        this.cashKL = cashKL;
        this.cashMG = cashMG;
        this.cardCV = cardCV;
        this.cardKL = cardKL;
        this.cardMG = cardMG;
        this.totalProcedure = totalProcedure;
        this.totalCashCard = totalCashCard;
    }

    public TotalWorkMonth(String id, String month, int year, int monthNumber,
                          long billCV, long billKL, long billMG, long cashCV,
                          long cashKL, long cashMG, long cardCV, long cardKL,
                          long cardMG, long totalProcedure, long totalCashCard) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.monthNumber = monthNumber;
        this.billCV = billCV;
        this.billKL = billKL;
        this.billMG = billMG;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public long getBillCV() {
        return billCV;
    }

    public void setBillCV(long billCV) {
        this.billCV = billCV;
    }

    public long getBillKL() {
        return billKL;
    }

    public void setBillKL(long billKL) {
        this.billKL = billKL;
    }

    public long getBillMG() {
        return billMG;
    }

    public void setBillMG(long billMG) {
        this.billMG = billMG;
    }

    public long getCashCV() {
        return cashCV;
    }

    public void setCashCV(long cashCV) {
        this.cashCV = cashCV;
    }

    public long getCashKL() {
        return cashKL;
    }

    public void setCashKL(long cashKL) {
        this.cashKL = cashKL;
    }

    public long getCashMG() {
        return cashMG;
    }

    public void setCashMG(long cashMG) {
        this.cashMG = cashMG;
    }

    public long getCardCV() {
        return cardCV;
    }

    public void setCardCV(long cardCV) {
        this.cardCV = cardCV;
    }

    public long getCardKL() {
        return cardKL;
    }

    public void setCardKL(long cardKL) {
        this.cardKL = cardKL;
    }

    public long getCardMG() {
        return cardMG;
    }

    public void setCardMG(long cardMG) {
        this.cardMG = cardMG;
    }

    public long getTotalProcedure() {
        return totalProcedure;
    }

    public void setTotalProcedure(long totalProcedure) {
        this.totalProcedure = totalProcedure;
    }

    public long getTotalCashCard() {
        return totalCashCard;
    }

    public void setTotalCashCard(long totalCashCard) {
        this.totalCashCard = totalCashCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalWorkMonth that = (TotalWorkMonth) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TotalWorkMonth{" +
                "id='" + id + '\'' +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", monthNumber=" + monthNumber +
                ", billCV=" + billCV +
                ", billKL=" + billKL +
                ", billMG=" + billMG +
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
