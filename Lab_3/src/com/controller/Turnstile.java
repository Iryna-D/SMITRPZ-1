//Турнікет зчитує картку та отримує дані по ній з реєстру, виконує її перевірку та фіксацію проходів чи відмов:
//● якщо картка не знайдена в реєстрі / прострочена / заблокована, чи на ній не залишилося кредитів для проходження, то прохід заборонено;
//● інакше з картки знімається один прохід / його вартість (якщо для картки передбачається контроль проходів) і прохід дозволяється;
//● при спрацюванні картки пільгового типу турнікет має засвітити контрольну лампу (викликати метод warn), щоб контролер мав змогу перевірити документи, що дають право на пільгу;
//● проходи та відмови фіксуються до реєстру.

package com.controller;

import com.model.AbstractCard;
import com.model.CardPerPass;
import com.model.CardUnlimited;
import com.model.enums.*;

public class Turnstile {

    public void checkCard(CardRegister cardRegister, AbstractCard card) {
        if (card instanceof CardPerPass) {
            checkCardPerPass(cardRegister, (CardPerPass) card);
        } else if (card instanceof CardUnlimited) {
            checkCardUnlimited(cardRegister, (CardUnlimited) card);
        }
    }

    public void checkCardPerPass(CardRegister cardRegister, CardPerPass card) {
        if (cardRegister.getCard(AbstractCard.id) != null && !card.cardLock && card.numberOfVisits > 0) {
            card.setNumberOfVisits(card.getNumberOfVisits() - 1);
            card.setAllowedPasses(card.getAllowedPasses() + 1);
            if (card.getCardType() == CardType.WITH_BENEFIT) {
                warn();
            }
            System.out.println("Visit allowed!!!");
        } else {
            card.setDeniedPasses(card.getDeniedPasses() + 1);
            System.out.println("Visit denied!!!");
        }
    }

    public void checkCardUnlimited(CardRegister cardRegister, CardUnlimited card) {
        if (cardRegister.getCard(AbstractCard.id) != null && !card.cardLock && !cardRegister.isCardUnlimitedExpired(card) && (cardRegister.isCardUnlimitedDaytimeValid(card) || cardRegister.isCardUnlimitedSeasonValid(card))) {
            card.setAllowedPasses(card.getAllowedPasses() + 1);
            if (card.getCardType() == CardType.WITH_BENEFIT) {
                warn();
            }
            System.out.println("Visit allowed!!!");
        } else {
            card.setDeniedPasses(card.getDeniedPasses() + 1);
            System.out.println("Visit denied!!!");
        }
    }

    private void warn() {
        System.out.println("CHECK DOCUMENTS");
    }

}
