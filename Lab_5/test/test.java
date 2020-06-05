import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Iryna
 */
public class test extends Assert {
    
    @Test
    public void someTest() {
        MarketProcessor mp = new MarketProcessor();
        Good good1 = new Good("A", 2);
        Good good2 = new Good("A", 4);
        
        mp.add(good1);
        
        mp.add(good2);
        
        System.out.print(mp.getList().toString());
    }
    
}
