package com.berkay;

import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hos Geldiniz !");
        System.out.print("Lutfen bir isim giriniz :");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayin " + player.getName() + " bu karanlik ve sisli adaya hosgeldiniz !! Burada yasananların hepsi gercek !");
        System.out.println("Lutfen bir karakter seciniz ! ");
        player.selectChar();  // Karakter seçme methodunu çağırdık
        Location location = null;
        while (true) {
            player.pritInfo();
            System.out.println();
            System.out.println("###### Bolgeler ######");
            System.out.println();
            System.out.println("1 - Guvenli Ev  --> Burasi sizin icin guvenli bir ev, dusman ypktur ! ");
            System.out.println("2 - Esya Dukkani--> Silah veya zirh satin alabilirsiniz !");
            System.out.println("3 - Magara      --> Odul <Yemek>, dikkatli ol canavar cikabilir !");
            System.out.println("4 - Orman       --> Odul <Odun>, dikkatli ol karsina vampir cikabilir !");
            System.out.println("5 - Nehir       --> Odul <Su>, dikkatli ol karsina ayi cikabilir !");
            System.out.println("0 - Cikis Yap   --> Oyunu sonladir !");
            System.out.println("Lutfen gitmek istediginiz bolgeyi seciniz : ");
            int sellectLocation = input.nextInt();
            switch (sellectLocation){
                case 0:
                 location = null;
                    break;
                case 1: location = new SafeHouse(player);
                    break;
                case 2: location = new ToolStore(player);
                    break;
                case 3: location = new Cave(player);
                break;
                case 4: location = new Forest(player);
                break;
                case 5: location = new River(player);
                break;
                default:
                System.out.println("Lutfen gecerli bir bolge giriniz !");
            }
            if (location == null){
                System.out.println("Bu karanlık ve sisli adadan cabuk vazgectin !");
                break;
            }

          if (!location.onLocation())
            {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
