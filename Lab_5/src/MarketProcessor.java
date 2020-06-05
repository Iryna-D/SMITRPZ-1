import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Iryna
 * To change this template use File | Settings | File Templates.
 */
public class MarketProcessor {
    
    private Map goods_list = new HashMap();
    
    public MarketProcessor() {
        
    }
    
    public void add(Good the_good) {
        if (!goods_list.containsKey(the_good)) {
            goods_list.put(the_good.getName(), the_good.getCount());
            return;
        }
        int value = (Integer)goods_list.get(the_good.getName());
        
        goods_list.put(the_good.getName(), value + the_good.getCount());
        
    }

    public Map getList() {
        return goods_list;
    }

//    private List<Good> goodsList;
//    
//    public MarketProcessor() {
//        goodsList = new ArrayList<Good>();
//    }
//    
//    public void add(Good currentGood) {
//        if (currentGood == null) {
//            return;
//        }
//        
//        if (!goodsList.isEmpty()) {
//            int numOfGoods = goodsList.size();
//            int i = 0;
//            
//            while (i < numOfGoods) {
//                Good goodFromList = goodsList.get(i);
//                if (goodFromList.getName() == currentGood.getName()) {
//                    int cnt = goodFromList.getCount();
//                    int currCnt = currentGood.getCount();
//
//                    goodFromList.setCount(cnt+currCnt);
//                    return;
//                }
//                i++;
//            }
//        }
//
//        goodsList.add(currentGood);
//    }
//    
//    public List<Good> getGoodsList () {
//        return goodsList;
//    }
//    
//    public Good getGood(String good_name) {
//        for (int i = 0; i < goodsList.size(); i++) {
//            if (goodsList.get(i).getName() == good_name) {
//                return goodsList.get(i);
//            }
//        }
//
//        return null;
//    }
}
