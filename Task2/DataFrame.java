package Task2;

/**
 *
 * @author Daniel
 */
import java.util.*;

public class DataFrame extends Observable{
    public static final int SIZE = 4;
    private int[] num;
    
    public DataFrame() {
        this.num = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            this.num[i] = i;
        }
    }
    
    public void setValue(int idx, int n) {
        this.num[idx] = n;
        setChanged();
        notifyObservers();
    }
    
    public int getValue(int idx) {
        return this.num[idx];
    }
    
    public int getSize() {
        return this.num.length;
    }
}
