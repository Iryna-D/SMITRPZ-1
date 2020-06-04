package com.model;

import com.model.enums.*;

import java.time.LocalDateTime;

import static com.model.enums.CardKind.CARD_UNLIMITED;

public class CardUnlimited extends AbstractCard {

    public CardUnlimited(CardDaytime cardDaytime, int validPeriod, CardType cardType) {
        id++;
        this.activationDate = LocalDateTime.now();
        this.cardKind = CARD_UNLIMITED;
        this.cardLock = false;

        this.validPeriod = validPeriod;
        this.cardDaytime = cardDaytime;
        this.cardType = cardType;
        setExpiryDate(activationDate, validPeriod);
    }

    public CardUnlimited(CardDaytime cardDaytime, Season season, CardType cardType) {
        id++;
        this.activationDate = LocalDateTime.now();
        this.cardKind = CARD_UNLIMITED;
        this.cardLock = false;

        this.season = season;
        this.cardDaytime = cardDaytime;
        this.cardType = cardType;
        setExpiryDate(activationDate, validPeriod);
    }

    LocalDateTime activationDate;
    LocalDateTime expiryDate;
    CardDaytime cardDaytime;
    int validPeriod;
    Season season;

    public LocalDateTime getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDateTime activationDate) {
        this.activationDate = activationDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(LocalDateTime activationDate, int validPeriod) {
        this.expiryDate = activationDate.plusDays(validPeriod);
    }

    public CardDaytime getCardDaytime() {
        return cardDaytime;
    }

    public void setCardDaytime(CardDaytime cardDaytime) {
        this.cardDaytime = cardDaytime;
    }

    public int getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(int validPeriod) {
        this.validPeriod = validPeriod;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "CardUnlimited{" +
                "activationDate=" + activationDate +
                ", expiryDate=" + expiryDate +
                ", cardDaytime=" + cardDaytime +
                ", validPeriod=" + validPeriod +
                ", season=" + season +
                ", cardType=" + cardType +
                ", cardKind=" + cardKind +
                ", cardLock=" + cardLock +
                ", cardActivationDate=" + cardActivationDate +
                ", deniedPasses=" + deniedPasses +
                ", allowedPasses=" + allowedPasses +
                '}';
    }
}
