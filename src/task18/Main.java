package task18;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game simulations = new Game(20, 15);
        simulations.live(1, 4);
        simulations.live(2, 5);
        simulations.live(2, 6);
        simulations.live(3, 4);
        simulations.live(3, 5);
        for (int i = 0; i < 25; i++) {
            simulations.printPlank();
            simulations.operate();
        }
    }
}