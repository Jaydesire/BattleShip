public class Gamer extends Player {

    Gamer() {
        super();
    }

    @Override
    public boolean attack(Player player) {

        boolean isHit = false;

        player.field.print(true);
        System.out.print("Ваш ход (например: " +((char)(1072+Math.random() * (GameMenu.FIELD_SIZE)))+ ((int)(Math.random() * (GameMenu.FIELD_SIZE)+1)) +"): >> ");
        String str = Main.scanner.nextLine();//TODO дописать исключение на ошибку ввода
        System.out.println(str);
        char xChar = str.charAt(0);
        int y = xChar - 1072;
        int x = 0;

        if (y < 0 || y >= 10) {
            System.out.println("Ввод не верный");
        } else {
            x = Integer.parseInt(str.substring(1)) - 1;
            if (x < 0 || x > 9) {
                System.out.println("Ввод не верный");
            }
        }

        if (player.field.coordinates[x][y] == '▶') {
            player.field.coordinates[x][y] = '▷';
            player.field.print(true);
            System.out.println("Попадание");

            player.subLive();
            isHit = true;

        } else if (player.field.coordinates[x][y] == '▲') {

            player.field.coordinates[x][y] = '△';
            player.field.print(true);
            System.out.println("Попадание");
            player.subLive();
            isHit = true;

        } else {

            player.field.coordinates[x][y] = '✕';
            player.field.print(true);
            System.out.println("Промах");
        }
        return isHit;
    }
}
