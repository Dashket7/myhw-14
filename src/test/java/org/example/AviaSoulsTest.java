

package org.example;

import org.example.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Comparator;


public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Moscow", "Perm", 5000, 10, 12);
    Ticket ticket2 = new Ticket("Moscow", "Perm", 30000, 11, 16);
    Ticket ticket3 = new Ticket("Barcelona", "Moscow", 70000, 8, 12);
    Ticket ticket4 = new Ticket("Perm", "Tumen", 5000, 10, 12);
    Ticket ticket5 = new Ticket("Moscow", "Perm", 25000, 16, 22);

    @Test

    public void CompareToPriceTest1() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        int expected = ticket1.compareTo(ticket2);
        int actual = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void CompareToPriceTest2() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        int expected = ticket2.compareTo(ticket1);
        int actual = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test

    public void CompareToPriceTest3() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        int expected = ticket1.compareTo(ticket4);
        int actual = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void CompareToPriceTest4() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        int expected = ticket4.compareTo(ticket1);
        int actual = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void PriceIncreaseTest() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket2};
        Ticket[] actual = repo.search("Moscow", "Perm");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ComparatorTest1() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = timeComparator.compare(ticket1, ticket2);
        int actual = -1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ComparatorTest2() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = timeComparator.compare(ticket2, ticket1);
        int actual = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ComparatorTest3() {

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = timeComparator.compare(ticket1, ticket4);
        int actual = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SearchAndSortTest() {
        AviaSouls repo = new AviaSouls();
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket1, ticket2, ticket5};
        Ticket[] actual = repo.searchAndSortBy("Moscow", "Perm", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
