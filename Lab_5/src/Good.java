/**
 * Created by IntelliJ IDEA.
 * User: Iryna
 * To change this template use File | Settings | File Templates.
 */
public class Good {
    
    private String itsName;
    private int itsCnt;
    
    public Good(String name, int cnt) {
        itsName = name;
        itsCnt = cnt;
    }

    public void setName(String name) {
        itsName = name;
    }

    public void setCount(int cnt) {
        itsCnt = cnt;
    }

    public String getName() {
        return itsName;
    }

    public int getCount() {
        return itsCnt;
    }
}
