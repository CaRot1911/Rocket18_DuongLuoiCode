package InnerClass.Questions2;

public class Car {
    private String name;
    private String type;

    Car(String name,String type){
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static class Engine{
        private String engineType;

        Engine(String engineType){
            this.engineType = engineType;
        }

        public String getEngineType() {
            return engineType;
        }

        public void setEngineType(String engineType) {
            this.engineType = engineType;
        }
    }

    public static void main(String[] args) {

        Car car = new Car("Mazda","8WD");
        Car.Engine engine = new Car.Engine("Crysler");

        System.out.println(engine.getEngineType());
    }
}
