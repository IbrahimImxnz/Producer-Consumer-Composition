import java.util.List;

public class Producer implements Runnable {
    private final String variant;
    private final List<Car> parking;
    private final int capacity;

    public Producer(String variant, List<Car> parking, int capacity){
        this.variant = variant;
        this.parking = parking;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while(true){
            synchronized (parking){
                while (parking.size() >= capacity){
                    try{
                        parking.wait();
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
                Car car = produceCar();
                parking.add(car);
                try{
                    System.out.println("Produced car: " + car);
                    parking.notifyAll();
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private Car produceCar(){
        return new Car(variant);
    }
}
