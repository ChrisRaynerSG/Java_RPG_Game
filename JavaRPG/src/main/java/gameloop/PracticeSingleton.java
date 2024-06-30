package gameloop;

public class PracticeSingleton {
    private static PracticeSingleton practiceSingleton;
    private int singletonNumber;

    private PracticeSingleton(int singletonNumber){
        this.singletonNumber = singletonNumber;
    }

    public static PracticeSingleton getPracticeSingleton(int thingToPutIn){
        if(practiceSingleton == null){
            practiceSingleton = new PracticeSingleton(thingToPutIn);
        }
        return practiceSingleton;
    }
}
