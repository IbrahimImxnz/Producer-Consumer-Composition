import java.util.ArrayList;
import java.util.List;

public class FPTCarsAG {
    public static void main(String[] args){
        List<Car> parking = new ArrayList<>(10);
        Thread producer1 = new Thread(new Producer("Variant1", parking, 10));
        Thread producer2 = new Thread(new Producer("Variant2", parking, 10));
        producer1.start();
        producer2.start();

        Thread consumer1 = new Thread(new Consumer(parking));
        Thread consumer2 = new Thread(new Consumer(parking));
        consumer1.start();
        consumer2.start();
    }
}
