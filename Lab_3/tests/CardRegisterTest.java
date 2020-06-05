import com.controller.CardRegister;
import com.model.AbstractCard;
import com.model.CardPerPass;
import com.model.CardUnlimited;
import com.model.enums.CardKind;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.model.enums.CardDaytime.EVENING;
import static com.model.enums.CardDaytime.FULL_DAY;
import static com.model.enums.CardType.*;
import static com.model.enums.Season.SECOND;
import static org.junit.Assert.*;

public class CardRegisterTest {

    static CardRegister cardRegister = new CardRegister();
    static List<AbstractCard> cardList = new ArrayList<>();
    AbstractCard cardUnlimitedSeason1 = new CardUnlimited(EVENING, SECOND, VIP);
    AbstractCard cardUnlimitedDays2 = new CardUnlimited(EVENING, 10, USUAL);
    AbstractCard cardPerPass3 = new CardPerPass(10, WITH_BENEFIT);

    @Before
    public void setUpTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            CardPerPass testID = new CardPerPass(10, USUAL);
            cardRegister.createCard(testID);
            //System.out.println(testID.getId());
        }
        cardList.add(cardUnlimitedSeason1);
        cardList.add(cardUnlimitedDays2);
        cardList.add(cardPerPass3);
    }

    @Test
    public void createCardAndGetCardTest() {
        for (int i = 0; i < 10; i++) {
            CardPerPass testID = new CardPerPass(10, USUAL);
            cardRegister.createCard(testID);
            //System.out.println(testID.getId());
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertNotNull(cardRegister.getCard(i));
        }
    }

    @Test
    public void getCardTest() {
        Assert.assertNotNull(cardRegister.getCard(1));
    }

    @Test
    public void lockCardTest() {
        AbstractCard card = cardRegister.getCard(1);
        cardRegister.lockCard(card);
        Assert.assertTrue(card.isCardLocked());
    }

    @Test
    public void getAllowedAndForbiddenPassesTest() {
        List<int[]> allowedAndForbiddenPassesList = cardRegister.getAllowedAndForbiddenPasses(cardList);
        //allowedAndForbiddenPassesList.forEach((int [] elements) -> System.out.println(Arrays.toString(elements)));
        allowedAndForbiddenPassesList.forEach(Assert::assertNotNull);
    }

    @Test
    public void getAllowedAndForbiddenPassesForSpecificCardKindTest() {
        List<int[]> allowedAndForbiddenPassesForSpecificCardKind = cardRegister.getAllowedAndForbiddenPassesForSpecificCardKind(cardList, CardKind.CARD_PER_PASS);
        //allowedAndForbiddenPassesForSpecificCardKind.forEach((int [] elements) -> System.out.println(Arrays.toString(elements)));
        allowedAndForbiddenPassesForSpecificCardKind.forEach(Assert::assertNotNull);
    }

    @Test
    public void getAllowedAndForbiddenPassesForOneCardTest() {
        int[] allowedAndForbiddenPassesForOneCard = cardRegister.getAllowedAndForbiddenPassesForOneCard(cardUnlimitedSeason1);
        //System.out.println(Arrays.toString(allowedAndForbiddenPassesForOneCard));
        Assert.assertNotNull(allowedAndForbiddenPassesForOneCard);
    }

    @Test
    public void isCardUnlimitedExpiredTest() {
        assertFalse(cardRegister.isCardUnlimitedExpired((CardUnlimited) cardUnlimitedSeason1));
    }

    @Test
    public void isCardUnlimitedDaytimeValidTest() {
        assertTrue(cardRegister.isCardUnlimitedDaytimeValid(new CardUnlimited(FULL_DAY, SECOND, VIP)));
    }

    @Test
    public void isCardUnlimitedSeasonValidTest() {
        assertTrue(cardRegister.isCardUnlimitedSeasonValid((CardUnlimited) cardUnlimitedSeason1));
    }
}