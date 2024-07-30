public class test {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder("Intel Core i7", "16GB")
                .setStorage("1TB HDD")
                .build();

        Computer gamingComputer = new Computer.Builder("Intel Core i5", "16GB")
                .setStorage("1TB SSD")
                .build();

        System.out.println("Gaming Computer: ");
        basicComputer.show();
        System.out.println("Normal Computer: ");
        gamingComputer.show();
    }
}
