package Class08;

public abstract class _03_Cars {
    String fuelType;

    public _03_Cars(String fuelType) {
        this.fuelType = fuelType;
    }

    abstract void fuelType();

}

class Toyota extends _03_Cars {

    public Toyota(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Toyota drives using " + fuelType);
    }
}

class Honda extends _03_Cars {

    public Honda(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Honda drives using " + fuelType);
    }
}

class Tesla extends _03_Cars {
    public Tesla(String fuelType) {
        super(fuelType);
    }

    @Override
    void fuelType() {
        System.out.println("Tesla drives using " + fuelType);
    }
}