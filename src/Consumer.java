import java.util.List;

public class Consumer implements Runnable{
    private final List<Car> parking;

    public Consumer(List<Car> parking){
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true){
            synchronized (parking){
                while(parking.isEmpty()){
                    try {
                        parking.wait();
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                Car car = parking.remove(0);

                try {
                    System.out.println("Consumed car: " + car);
                    parking.notifyAll();
                    Thread.sleep(2000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
