package be.jidoka.clean.code.labs.movie;

import be.jidoka.clean.code.labs.movie.Exceptions.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class TicketOffice implements Bill {

    private static final int MIN_CUSTOMER_IN_GROUP = 20;
    private static final double GROUP_PRICE = 6.0;
    private List<Ticket> tickets = new ArrayList<>();
    private OverLengthFee overLengthFee;
    private ThreeDFee threeDFee;
    private WeekendFee weekendFee;
    private SpecialMovieDayDiscount specialMovieDayDiscount;
    //private PriceChangers priceChangers;

    @Override
    public void startPurchase(int runtime, DayOfWeek dayOfWeek, boolean loge, boolean threeD) {

        //priceChangers = new PriceChangers(runtime, dayOfWeek, threeD);
        overLengthFee = new OverLengthFee(runtime);
        threeDFee = new ThreeDFee(threeD);
        weekendFee = new WeekendFee(dayOfWeek);

        specialMovieDayDiscount = new SpecialMovieDayDiscount(dayOfWeek);

    }

    @Override
    public void addTicket(int age, boolean student) {
        Ticket newTicket = new Ticket(age, student);
        tickets.add(newTicket);
    }

    @Override
    public double finishPurchase() {
        double total = 0.0;

        for (Ticket ticket : tickets) {

            if(isGroup()){
                total += GROUP_PRICE;
            }
            else {
                total += ticket.calculatePrice();
                total += specialMovieDayDiscount.calculatePrice();
            }

            //total += priceChangers.calculatePriceChanges();
            total += overLengthFee.calculatePrice();
            total += threeDFee.calculatePrice();
            total += weekendFee.calculatePrice();

        }

        return total;
    }

    private boolean isGroup() {
        return tickets.size() >= MIN_CUSTOMER_IN_GROUP;
    }
}
