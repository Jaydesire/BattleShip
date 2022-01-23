public class GameMenu {

    public static final int FIELD_SIZE = 10;

    public static void newGame() {
        Field field = new Field();

        Npc npc = new Npc();
        Gamer gamer = new Gamer();
        //Npc gamer = new Npc();
        boolean fight = true;


        System.out.println("Ваше стартовое поле:");
        gamer.field.print(false);
        System.out.print(">> ОК");
        Main.scanner.nextLine();
        clearScreen();

        while (true) {
            fight = true;
            if (gamer.isAlive()) {
                while (fight) {
                    System.out.println("Жизней у человека: " + gamer.lives);
                    fight = gamer.attack(npc);
                    System.out.println("Жизней у NPC: " + npc.lives);
                    System.out.print(">> ОК");
                    Main.scanner.nextLine();
                    clearScreen();
                    if (fight) {
                        System.out.println("Отличное попадание! Стреляй ещё раз.");
                    }
                }
            } else {
                System.out.println("Машина победила");
                break;
            }

            fight = true;
            if (npc.isAlive()) {
                while (fight) {
                    fight = npc.attack(gamer);
                    System.out.println("Жизней у человека: " + gamer.lives);
                    System.out.print(">> ОК");
                    Main.scanner.nextLine();
                    clearScreen();
                }
            } else {
                System.out.println("Человек победил");
                break;
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 60; i++) {
            System.out.println();
        }
    }

}




