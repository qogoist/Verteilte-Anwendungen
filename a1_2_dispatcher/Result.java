package a1_2_dispatcher;

public class Result {
    private int[] results;
    private int capacity;
    private int c;

    public Result(int n) {
        this.results = new int[n];
        this.capacity = n;
        this.c = 0;
    }

    public synchronized void writeResult(int n, int y) {
        results[n] = y;
        
        c++;

        if (c == capacity){
            notify();
        }
    }

    public synchronized int[] getResults() {
        try {
            wait();
        } catch (InterruptedException e) {
        }
        return results;
    }
}