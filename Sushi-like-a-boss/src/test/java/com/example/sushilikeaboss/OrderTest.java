package com.example.sushilikeaboss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {



    @Test
    public void totalTimeIsCalculatedCorrectly(){
        Order myOrder = new Order(0);
        //add new Sushi to order
        myOrder.addItem(new DaikonMaki(1));
        // totalTime should be 50 seconds
        assertEquals(50, myOrder.getTotalTime());
    }

    @Test
    public void basketCostsIncrease(){
        Order myOrder = new Order(0);
        myOrder.addItem(new DaikonMaki(1));
        //Total costs of order should be 2.7 (costs of one daikon maki)
        assertEquals(2.7, myOrder.getTotal());
    }

    @Test
    public void basketCostsDecrease(){
        Order myOrder = new Order(0);
        // sushi is added to order
        myOrder.addItem(new DaikonMaki(1));
        // same sushi as above removed from order
        myOrder.removeItem(new DaikonMaki(1));
        // costs of order should go back to zero
        assertEquals(0, myOrder.getTotal());
    }

    @Test
    public void basketCostsDecreaseIfNoItemInBasket(){
        Order myOrder = new Order(0);
        // sushi that is not in order is removed from oder
        myOrder.removeItem(new DaikonMaki(1));
        // total costs should be zero
        assertEquals(0, myOrder.getTotal());
    }

}