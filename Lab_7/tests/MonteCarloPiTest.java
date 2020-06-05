import com.MonteCarloPi;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonteCarloPiTest {

    @Test
    public void getPi() throws InterruptedException {
        double receivedPi = new MonteCarloPi().getPi(8);
        double expectedPiMin = 3.14;
        double expectedPiMax = 3.15;
        assertTrue(receivedPi > expectedPiMin && receivedPi < expectedPiMax);
    }
}