package deque;

import java.util.Comparator;

public class MaxArrayDeque<Item> extends ArrayDeque<Item> {
    private Comparator<Item> cmp;
    public MaxArrayDeque(Comparator<Item> c){
        super();
        cmp = c;
    }

    public Item max(Comparator<Item> c){
        if(isEmpty()){
            return null;
        }
        Item maxItem = this.get(0);
        for(Item i : this){
            if(c.compare(i, maxItem) > 0){
                maxItem = i;
            }
        }
        return maxItem;
    }

    public Item max(){
        return max(cmp);
    }


}




