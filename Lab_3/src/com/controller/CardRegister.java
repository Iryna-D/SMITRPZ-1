package com.controller;

//● випустити картку; createCard
//● отримати дані за карткою по унікальному ідентифікатору; getCard(int index)
//● заблокувати картку через порушення правил; lockCard
//● видавати по запиту дані про проходи та відмови для всіх карток, для карток певного типу або для конкретної картки.

import com.model.AbstractCard;
import com.model.CardPerPass;
import com.model.CardUnlimited;
import com.model.enums.CardKind;

import java.time.LocalDateTime;
import java.util.*;

public class CardRegister {

    private List<AbstractCard> cardList = new ArrayList<>();

    public void createCard(AbstractCard card) {
        if (card instanceof CardPerPass) {
            cardList.add(card);
        } else if (card instanceof CardUnlimited) {
            cardList.add(card);
        } else throw new Error("provide the right card");
    }

    public AbstractCard getCard(int id) {
        if (id < 0) {
            return null;
        } else {
            return cardList.get(id);
        }
    }

    public void lockCard(AbstractCard card) {
        card.setCardLock(true);
    }


    public List<int[]> getAllowedAndForbiddenPasses(List<AbstractCard> cardList) {
        List<int[]> allowedAndForbiddenPassesList = new ArrayList<>();
        for (AbstractCard card : cardList) {
            int[] elementOfList = {card.getId(), card.getDeniedPasses(), card.getAllowedPasses()};
            allowedAndForbiddenPassesList.add(elementOfList);
        }
        return allowedAndForbiddenPassesList;
    }

    public List<int[]> getAllowedAndForbiddenPassesForSpecificCardKind(List<AbstractCard> cardList, CardKind cardKind) {
        List<int[]> AllowedAndForbiddenPassesForSpecificCardKindList = new ArrayList<>();
        for (AbstractCard card : cardList) {
            if (card.getCardKind() == cardKind) {
                int[] elementOfList = {card.getId(), card.getDeniedPasses(), card.getAllowedPasses()};
                AllowedAndForbiddenPassesForSpecificCardKindList.add(elementOfList);
            }
        }
        return AllowedAndForbiddenPassesForSpecificCardKindList;
    }

    public int[] getAllowedAndForbiddenPassesForOneCard(AbstractCard card) {
        return new int[]{card.getId(), card.getDeniedPasses(), card.getAllowedPasses()};
    }

    public boolean isCardUnlimitedExpired(CardUnlimited card) {
        return LocalDateTime.now().isAfter(card.getExpiryDate());
    }

    public boolean isCardUnlimitedDaytimeValid(CardUnlimited card) {
        int nowHour = LocalDateTime.now().getHour();
        switch (card.getCardDaytime()) {
            case MORNING:
                return nowHour >= 9 && nowHour < 14;
            case EVENING:
                return nowHour >= 14 && nowHour < 19;
            case NIGHT:
                return nowHour >= 19;
            case FULL_DAY:
                return true;
        }
        return false;
    }

    public boolean isCardUnlimitedSeasonValid(CardUnlimited card) {
        int nowMonth = LocalDateTime.now().getMonthValue();
        switch (card.getSeason()) {
            case FIRST:
                return nowMonth <= 3;
            case SECOND:
                return nowMonth >= 4 && nowMonth <= 6;
            case THIRD:
                return nowMonth >= 7 && nowMonth <= 9;
            case FOURTH:
                return nowMonth >= 10;
        }
        return false;
    }
}
