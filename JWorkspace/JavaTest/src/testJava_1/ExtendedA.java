package testJava_1;

class ClassA {
    public int numberOfInstances;

    protected ClassA(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }
}

class ExtendedA extends ClassA {
    private ExtendedA(int numberOfInstances) {
        super(numberOfInstances); //super()必定執行，若父類無可以執行建構式時，定錯，除非用super(XX)來改寫調用
    }

    public static void main(String[] args) {
        ExtendedA ext = new ExtendedA(420);
        System.out.print(ext.numberOfInstances);

    }
}