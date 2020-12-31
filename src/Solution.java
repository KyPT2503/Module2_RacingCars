public class Solution {
    public static void main(String[] args) {
        (new Thread(new Car("A", 2))).start();
        (new Thread(new Car("B", 1))).start();
        (new Thread(new Car("C", 5))).start();
    }
}

class Car implements Runnable {
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void run() {
        int carDistance = 0;
        int pathDistance = 20;
        long startTime = System.currentTimeMillis();
        try {
            while (carDistance < pathDistance) {
                System.out.println("Car " + this.name + " has distance: " + carDistance);
                carDistance += this.speed;
                Thread.sleep(1000);
            }
            System.out.println("Car "+this.name+" has completed tracing.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}