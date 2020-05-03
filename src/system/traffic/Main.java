package system.traffic;

public class Main {

    public static void main(String[] args) {
        TimeRegulator regulator = new TimeRegulator(new LightManager(null));

        try {
            regulator.execute();
        } catch (InterruptedException ex) {
            System.out.println("The Traffic system control has gone offline.");
        }
    }
}
