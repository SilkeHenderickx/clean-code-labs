package be.jidoka.clean.code.labs.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

public class BillTest {

    private Bill bill;

    @BeforeEach
    public void setUp() {
        bill = new TicketOffice();
    }

    @Test
    public void singleTicketGeneralAdmissionShouldBe11WithoutExceptions() {
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);
        bill.addTicket(29, false);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(11.0);
    }

    @Test
    public void twoTicketsGeneralAdmissionShouldBe22WithoutExceptions() {
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);
        bill.addTicket(29, false);
        bill.addTicket(29, false);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(22.0);
    }

    @Test
    public void studentsShouldPay8DollarAdmission() {
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);
        bill.addTicket(29, true);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(8.0);
    }

    @Test
    public void seniorShouldPay6DollarAdmission(){
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);
        bill.addTicket(65, true);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(6.0);
    }

    @Test
    public void childShouldPay5Dollar50CentAdmission(){
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);
        bill.addTicket(12, true);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(5.5);
    }

    @Test
    public void seniorStudentShouldPay6DollarAdmission(){
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);
        bill.addTicket(70, true);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(6.0);
    }

    @Test
    public void groupOf20ShouldPay120DollarAdmission(){

        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, false);

        for(int i = 0; i < 20; ++i) {
            bill.addTicket(29, false);
        }

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(120);
    }

    @Test
    public void threeDGeneralAdmissionShouldPay14Dollar(){
        // Given
        bill.startPurchase(70, DayOfWeek.MONDAY, false, true);

        bill.addTicket(29, false);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(14);
    }

    @Test
    public void OverLength120MinGeneralAdmissionShouldPay12Dollar50Cent(){
        // Given
        bill.startPurchase(130, DayOfWeek.MONDAY, false, false);

        bill.addTicket(29, false);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(12.5);
    }

    @Test
    public void WeekendGeneralAdmissionShouldPay12Dollar50Cent(){
        // Given
        bill.startPurchase(90, DayOfWeek.SATURDAY, false, false);

        bill.addTicket(29, false);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(12.5);
    }

    @Test
    public void ThursdayGeneralAdmissionShouldPay9Dollar(){
        // Given
        bill.startPurchase(90, DayOfWeek.THURSDAY, false, false);

        bill.addTicket(29, false);

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(9.0);
    }

    @Test
    public void ThursdayGroupOf20ShouldPay120Dollar(){
        // Given
        bill.startPurchase(90, DayOfWeek.THURSDAY, false, false);

        for(int i = 0; i < 20; ++i) {
            bill.addTicket(29, false);
        }

        // When
        double price = bill.finishPurchase();

        // Then
        assertThat(price).isEqualTo(120);
    }



    // What if we want to purchase for multiple movies? --> Out of scope

    // TODO: New test(acceptance test): enter several different types of ticket if group gets group price
    // TODO: acceptance test: random cases testen
}
