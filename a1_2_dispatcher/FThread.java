package a1_2_dispatcher;

public class FThread extends Thread{
    
    private F f;
    private int x;
    private Result result;

    public FThread(F f, int x, Result result){
        this.x = x;
        this.result = result;
        this.f = f;
    }

    public void run() {
        int y = f.f(x);
        result.writeResult(x, y);
    }
}