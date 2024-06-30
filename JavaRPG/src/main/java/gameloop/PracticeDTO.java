package gameloop;

import java.util.Objects;

public class PracticeDTO {
    private final String stringExample;
    private final int intExample;
    private final double doubleExample;

    public PracticeDTO(String stringExample, int intExample, double doubleExample){
        this.doubleExample = doubleExample;
        this.stringExample = stringExample;
        this.intExample = intExample;
    }

    public double getDoubleExample(){
        return doubleExample;
    }
    public int getIntExample(){
        return intExample;
    }
    public String getStringExample(){
        return stringExample;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticeDTO that = (PracticeDTO) o;
        return intExample == that.intExample && Double.compare(doubleExample, that.doubleExample) == 0 && Objects.equals(stringExample, that.stringExample);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringExample, intExample, doubleExample);
    }

}
