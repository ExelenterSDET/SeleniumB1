package Class08;

public abstract class Cars {
    String fuelType;

    public Cars(String fuelType) {
        this.fuelType = fuelType;
    }

    abstract void fuelType();

}

class Toyota extends Cars {

    public Toyota(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Toyota drives using " + fuelType);
    }
}

class Honda extends Cars {

    public Honda(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Honda drives using " + fuelType);
    }
}

class Tesla extends Cars {
    public Tesla(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Tesla drives using " + fuelType);
    }
}