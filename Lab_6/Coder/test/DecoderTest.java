import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Iryna
 */
public class DecoderTest extends Assert {
    
    private StringReader string_reader = null;
    private Decoder decoder = null;
    private String the_string = null;
    
    
    @Before
    public void setUp() {
        the_string = "A";
        string_reader = new StringReader(the_string);
        decoder = new Decoder(string_reader);
    }
    
    @Test
    public void testDecodeChar() {
        int actual = decoder.decodeChar((int)'A');
        int expected = ((int)'A')/2;

        assertEquals(expected, actual);
    }
    
    @Test
    public void testRead() {
        int actual = decoder.read();
        int expected = ((int)'A')/2;

        assertEquals(expected, actual);

    }
}
