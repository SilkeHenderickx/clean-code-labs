package be.jidoka.clean.code.labs.movie.Exceptions;

import java.time.DayOfWeek;

public class WeekendFee implements PriceException {

    private static final Double WEEKEND_PRICE = 1.5;

    private DayOfWeek dayOfWeek;

    public WeekendFee(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public double calculatePrice() {
        if(isWeekend()){
            return WEEKEND_PRICE;
        }
        return 0.0;
    }

    private boolean isWeekend() {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
