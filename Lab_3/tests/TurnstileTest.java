import com.controller.CardRegister;
import com.controller.Turnstile;
import com.model.AbstractCard;
import com.model.CardPerPass;
import com.model.CardUnlimited;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.model.enums.CardDaytime.EVENING;
import static com.model.enums.CardType.*;
import static com.model.enums.Season.SECOND;
import static org.junit.Assert.*;

public class TurnstileTest {

    static CardRegister cardRegister = new CardRegister();
    static Turnstile turnstile = new Turnstile();
    AbstractCard cardUnlimitedSeason1 = new CardUnlimited(EVENING, SECOND, VIP);
    AbstractCard cardUnlimitedDays2 = new CardUnlimited(EVENING, 10, USUAL);
    AbstractCard cardPerPass3 = new CardPerPass(10, WITH_BENEFIT);

    @Before
    public void setUpTest() throws Exception {
        cardRegister.createCard(cardUnlimitedSeason1);
        cardRegister.createCard(cardUnlimitedDays2);
        cardRegister.createCard(cardPerPass3);
    }

    @Test
    public void checkCardPerPassTest() {
        turnstile.checkCardPerPass(cardRegister, (CardPerPass) cardPerPass3);
        if (cardPerPass3.allowedPasses > 0 || cardPerPass3.deniedPasses > 0) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }

    @Test
    public void checkCardUnlimitedTest() {
        turnstile.checkCardUnlimited(cardRegister, (CardUnlimited) cardUnlimitedSeason1);
        if (cardUnlimitedSeason1.allowedPasses > 0 || cardUnlimitedSeason1.deniedPasses > 0) {
            Assert.assertTrue(true);
        } else {
            fail();
        }
    }
}