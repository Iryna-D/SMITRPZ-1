import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Iryna
 */
public class Testing {
    
    public static void main(String[] args) {
        
        String string = "Здравствуй Мир!";
        StringWriter out = new StringWriter(128);
        
        Coder coder = new Coder(out);

        coder.write(string);

        coder.close();

        StringReader in = new StringReader(coder.getString());
        Decoder decoder = new Decoder(in);


        System.out.println(out);

        int i = 0;

        while (i < out.getBuffer().length()) {
            System.out.print((char)decoder.read());
            i++;
        }

        decoder.close();

    }
}
