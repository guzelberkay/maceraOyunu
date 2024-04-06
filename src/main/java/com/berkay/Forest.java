package com.berkay;

public class Forest extends BatleLocation{
    public Forest(Player player) {
        super(player, "Orman", new Vampire(),"firewood",3)
        ;
    }
}
