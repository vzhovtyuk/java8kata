package net.myrts.codingkata8;

/**
 * @author <a href="mailto:vzhovtiuk@gmail.com">Vitaliy Zhovtyuk</a>
 *         Date: 4/29/16
 *         Time: 12:33 PM
 */
public class Stats {
    // amount of persons
    private int size;
    // sum for age
    private long sum;
    // smallest age
    private  int min;
    // biggest age
    private int max;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "max=" + max +
                ", size=" + size +
                ", sum=" + sum +
                ", min=" + min +
                '}';
    }
}
