public class Main {
    public static void main(String[] args) {
        Appliance appliance1 = new AirConditioner("LG");
        Appliance appliance2 = new WashingMachine("Panasonic");

        appliance1.displayBrand();
        appliance1.turnOn();
        appliance1.operate();
        appliance1.turnOff();

        System.out.println();

        appliance2.displayBrand();
        appliance2.turnOn();
        appliance2.operate();
        appliance2.turnOff();
    }
}
