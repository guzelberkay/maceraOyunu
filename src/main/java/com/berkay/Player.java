package com.berkay;

import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;         // oyuncu adı
    private String charName;    //Karakter adı
    private int orjinalHealth;

    private Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler");

        System.out.println("----------------------------");
        for (GameCharacter gameCharacter : charList) {
            System.out.println("ID : " + gameCharacter.getId() +
                    "\t\tKarakter : " + gameCharacter.getName() +
                    "\t\tHasar : " + gameCharacter.getDamage() +
                    "\t\tSaglik : " + gameCharacter.getHealth() +
                    "\t\tPara : " + gameCharacter.getMoney());
        }
        System.out.println("----------------------------");
        System.out.print("Lutfen bir karakter seciniz !");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println("Karakter : " + this.getCharName() +
                ", Hasar : " + getDamage() +
                ", Saglik : " + this.getHealth() +
                ", Para : " + this.getMoney());
    }


    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOrjinalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }
    public void pritInfo (){
        System.out.println(
                "Silahiniz   : "+this.getInventory().getWeapon().getName()+
                ", Zirhiniz  : "+this.getInventory().getArmor().getName()+
                ", Bloklama  : "+this.getInventory().getArmor().getBlock()+
                ", Hasariniz : " + getDamage() +
                ", Saglik    : " + this.getHealth() +
                ", Para :    " + this.getMoney()
        );

    }
    public int getTotalDamage(){
       return  damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public Weapon
    getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}
