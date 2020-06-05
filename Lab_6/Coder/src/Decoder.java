import java.io.FilterReader;
import java.io.IOError;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by IntelliJ IDEA.
 * User: Iryna
 */
public class Decoder extends FilterReader {
                                                 
    protected Decoder(Reader in) {
        super(in);
    }

    public int read(){
        try {
            return decodeChar(super.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int decodeChar(int char_code) {
        return (char_code/2);
    }

    public void close() {
        try {
            super.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
