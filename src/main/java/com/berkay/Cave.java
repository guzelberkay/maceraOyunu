package com.berkay;

public class Cave extends BatleLocation {
    public Cave(Player player) {
        super(player,"Magara", new Zombie(),"food",3);
    }
}
