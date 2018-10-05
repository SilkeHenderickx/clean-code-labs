package be.jidoka.clean.code.labs.movie.Exceptions;

public class OverLengthFee implements PriceException {

    private static final double OVERLENGTH_FEE = 1.5;
    private static final int MAX_RUNTIME = 120;

    private int overLength;

    public OverLengthFee(int runTime) {
        this.overLength = runTime;
    }

    @Override
    public double calculatePrice() {

        if(this.overLength > MAX_RUNTIME){
            return OVERLENGTH_FEE;
        }
        return 0.0;
    }
}
