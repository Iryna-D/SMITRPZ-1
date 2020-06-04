package com.model;

import com.model.enums.CardKind;
import com.model.enums.CardType;

import java.time.LocalDateTime;

public abstract class AbstractCard {

    public static int id = -1;
    public CardType cardType;
    public CardKind cardKind;
    public boolean cardLock = true;
    public LocalDateTime cardActivationDate;

    public int deniedPasses = 0;
    public int allowedPasses = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public boolean isCardLocked() {
        return cardLock;
    }

    public void setCardLock(boolean cardLock) {
        this.cardLock = cardLock;
    }

    public int getDeniedPasses() {
        return deniedPasses;
    }

    public void setDeniedPasses(int forbiddenPasses) {
        this.deniedPasses = forbiddenPasses;
    }

    public int getAllowedPasses() {
        return allowedPasses;
    }

    public void setAllowedPasses(int allowedPasses) {
        this.allowedPasses = allowedPasses;
    }

    public CardKind getCardKind() {
        return cardKind;
    }

    public LocalDateTime getCardActivationDate() {
        return cardActivationDate;
    }

    public void setCardActivationDate(LocalDateTime cardActivationDate) {
        this.cardActivationDate = cardActivationDate;
    }

    @Override
    public String toString() {
        return "AbstractCard{" +
                "cardType=" + cardType +
                ", cardKind=" + cardKind +
                ", cardLock=" + cardLock +
                ", cardActivationDate=" + cardActivationDate +
                ", deniedPasses=" + deniedPasses +
                ", allowedPasses=" + allowedPasses +
                '}';
    }
}
