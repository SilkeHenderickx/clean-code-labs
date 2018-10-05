package be.jidoka.clean.code.labs.movie.Exceptions;

import java.time.DayOfWeek;

public class SpecialMovieDayDiscount implements PriceException {

    private static final Double SPECIAL_MOVIE_DAY_PRICE = -2.0;
    private static final DayOfWeek SPECIAL_MOVIE_DAY = DayOfWeek.THURSDAY;

    private DayOfWeek dayOfWeek;

    public SpecialMovieDayDiscount(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public double calculatePrice() {
        if(this.dayOfWeek == SPECIAL_MOVIE_DAY){
            return SPECIAL_MOVIE_DAY_PRICE;
        }
        return 0.0;
    }
}
