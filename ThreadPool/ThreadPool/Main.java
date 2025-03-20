

public class Main {

    public static void main(String[] args) {
        
        MyThreadPool tp = new MyThreadPool(5); //maxSize
        tp.runTask(() -> {
            System.out.println("d");    
        });


    }
}