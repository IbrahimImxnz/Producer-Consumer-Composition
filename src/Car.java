public class Car {
    private final String model;

    public Car(String model){
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    @Override
    public String toString() {
        return "DummyCar{" +
                "model='" + model + '\'' +
                 "}";
    }
}
