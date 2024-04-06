package com.berkay;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.print("""
                    ----- Magazaa hosgeldiniz ! -----
                                    
                    1 - Silahlar
                    2 - Zirhlar
                    3 - Cikis Yap
                                    
                    Seciniz : 
                    """);
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Gecersiz deger, tekrar giriniz : ");
                selectCase = Location.input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;
                    break;
            }

        }
        return true;

    }

    public void printWeapon() {
        System.out.println("----- Silahlar -----");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " -" + w.getName() + "< Para : " +
                    w.getPrice() + " , Hasar : " + w.getDamage() + " >");
        }
        System.out.println("0 -Cikis Yap");

    }

    public void buyWeapon() {
        System.out.print("Bir silah seciniz :");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Gecersiz deger, tekrar giriniz : ");
            selectWeaponID = Location.input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
        if (selectWeaponID != 0){
        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paraniz bulunmamaktadir !");
            } else {
                // Satın almanın gerçekleştiği alan
                System.out.println(selectedWeapon.getName() + "silahini satin aldiniz !");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }}

    public void printArmor() {
        System.out.println("----- Zirhlar -----");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " -" + a.getName() + "< Para : " +
                    a.getPrice() + " , Engelleme : " + a.getBlock() + " >");
        }
        System.out.println("0 -Cikis Yap");

    }

    public void buyArmor() {
        System.out.print("Bir zirh seciniz :");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Gecersiz deger, tekrar giriniz : ");
            selectArmorID = Location.input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjById(selectArmorID);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli paraniz bulunmamaktadir !");
            } else {
                // Satın almanın gerçekleştiği alan
                System.out.println(selectedArmor.getName() + " zirhini satin aldiniz !");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paraniz : " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }
}
