package be.jidoka.clean.code.labs.movie;

import java.time.DayOfWeek;

public class PriceChangers {

    // TODO better name possible? THREED looks weird vs 3D
    private static final Double THREED_PRICE = 3.0;
    private static final Double OVERLENGTH_PRICE = 1.5;
    private static final Double WEEKEND_PRICE = 1.5;
    private static final Double SPECIAL_MOVIE_DAY_PRICE = -2.0;
    private static final int MAX_RUNTIME = 120;
    private static final DayOfWeek SPECIAL_MOVIE_DAY = DayOfWeek.THURSDAY;

    private boolean threeD;
    private int runTime;
    private DayOfWeek dayOfWeek;


    public PriceChangers(int runTime, DayOfWeek dayOfWeek, boolean threeD) {
        this.runTime = runTime;
        this.dayOfWeek = dayOfWeek;
        this.threeD = threeD;

    }
    public double calculatePriceChanges(){

        Double price = 0.0;

        if(threeD){
            price += THREED_PRICE;
        }
        if(runTime > MAX_RUNTIME){
            price += OVERLENGTH_PRICE;
        }
        if(isWeekend()){
            price += WEEKEND_PRICE;
        }
        if(dayOfWeek == SPECIAL_MOVIE_DAY){
            price += SPECIAL_MOVIE_DAY_PRICE;
        }

        return price;
    }

    private boolean isWeekend() {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
