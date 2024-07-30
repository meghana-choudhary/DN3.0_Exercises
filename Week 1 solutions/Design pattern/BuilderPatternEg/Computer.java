public class Computer {
    String cpu, ram, storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public void show(){
        System.out.println("CPU: "+cpu+"  RAM: "+ram+"  Storage: "+storage);
    }
    public static class Builder{
        private String cpu;
        private String ram;
        private String storage;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}