package com.example.sushilikeaboss;
import java.util.List;

public class NigriMakiSet extends SushiSet{
    protected NigriMakiSet (int quantitiy){
        super("Nigiri and Maki Set", quantitiy, 12, 90);
        content.addAll(List.of(
                new MaguroNigri(3),
                new SakeNigiri(3),
                new KappaMaki(1),
                new DaikonMaki (1)
        ));
    }
}
