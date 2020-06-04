package com.model;

import com.model.enums.CardType;

import java.time.LocalDateTime;

import static com.model.enums.CardKind.CARD_PER_PASS;

public class CardPerPass extends AbstractCard {

    public CardPerPass(int numberOfVisits, CardType cardType) {
        id++;
        this.cardActivationDate = LocalDateTime.now();
        this.cardKind = CARD_PER_PASS;
        this.cardLock = false;
        this.cardType = cardType;
        this.numberOfVisits = numberOfVisits;
    }

    public int numberOfVisits;

    public int getNumberOfVisits() {
        return numberOfVisits;
    }

    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }

    @Override
    public String toString() {
        return "CardPerPass{" +
                "numberOfVisits=" + numberOfVisits +
                ", cardType=" + cardType +
                ", cardKind=" + cardKind +
                ", cardLock=" + cardLock +
                ", cardActivationDate=" + cardActivationDate +
                ", deniedPasses=" + deniedPasses +
                ", allowedPasses=" + allowedPasses +
                '}';
    }
}
