package com.berkay;

import java.util.Random;

public abstract class BatleLocation extends Location {
    private Obstacle_Monster obstacle;
    private String award;  //Ödül
    private int maxObstacle;


    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Su an buradasiniz --> " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yasiyor !");
        System.out.print("<S>avaş veya <K>ac : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {

            System.out.println(this.getName() + " tum dusmanlari yendiniz !");
            return true;
        }


        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Oldunuz !");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) { // dövüş - Savaş

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.obstacle.getHealth() > 0) {
                System.out.print("<V>ur veya <K>ac : ");
                String selectCase = input.nextLine().toUpperCase();
                if (selectCase.equals("V")) {
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar Size Vurdu !");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }

            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Dusmani yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandiniz !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Gucel paraniz : " + this.getPlayer().getMoney());
            } else {
                return false;
            }

        }

        return true;
    }

    public void afterHit() {
        System.out.println("Caniniz : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Cani : " + this.getObstacle().getHealth());
        System.out.println("-----------");
    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Degerleri");
        System.out.println("----------------------------");
        System.out.println("Saglik : " + this.getObstacle().getHealth());
        System.out.println("Hasar  : " + this.getObstacle().getDamage());
        System.out.println("Odul   : " + this.getObstacle().getAward());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Degerleri");
        System.out.println("----------------------------");
        System.out.println("Saglik   : " + this.getPlayer().getHealth());
        System.out.println("Silah    : " + this.getPlayer().getWeapon().getName());
        System.out.println("Zirh     : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar    : " + this.getPlayer().getTotalDamage());
        System.out.println("Para     : " + this.getPlayer().getMoney());


    }

    public BatleLocation(Player player, String name, Obstacle_Monster obstacle, String award, int maxObstacle) {

        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle_Monster getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle_Monster obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}



