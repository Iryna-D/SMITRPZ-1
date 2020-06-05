import java.io.*;

public class Coder extends FilterWriter{

    private String string_to_code = "";

    protected Coder(Writer out){
        super(out);
    }

    public void write(String the_string){
        if (the_string == null) {
            return;
        }

        if (the_string == "") {
            return;
        }

        string_to_code = the_string;
        int str_len = string_to_code.length();
        int i = 0;
        char current_char;
        String coded_string = "";
        
        while (i < str_len) {
            current_char = string_to_code.charAt(i);
            coded_string += codeChar(current_char);
            
            i++;
        }
        string_to_code = coded_string;

        try {
            super.write(string_to_code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char codeChar(char the_char) {
        char tmp_char;
        int int_of_char = (int)the_char;

        tmp_char =(char)(int_of_char + int_of_char);
        
        return tmp_char; 
    }

    public void close() {
        try {
            super.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getString() {
        return string_to_code;
    }
}
