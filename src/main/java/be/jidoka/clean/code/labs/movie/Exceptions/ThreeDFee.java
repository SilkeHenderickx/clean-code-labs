package be.jidoka.clean.code.labs.movie.Exceptions;

public class ThreeDFee implements PriceException {

    private static final double THREED_PRICE = 3.0;

    private boolean threeD;

    public ThreeDFee(boolean threeD) {
        this.threeD = threeD;
    }

    @Override
    public double calculatePrice() {

        if(this.threeD == true) {
            return THREED_PRICE;
        }
        return 0.0;
    }
}
