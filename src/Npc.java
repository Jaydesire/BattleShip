public class Npc extends Player {

    int strategPlan;

    Npc() {
        super();
    }

    @Override
    public boolean attack(Player player) {

        boolean isHit = false;
        int randomX = (int) (Math.random() * (GameMenu.FIELD_SIZE));
        int randomY = (int) (Math.random() * (GameMenu.FIELD_SIZE));

        if (player.field.coordinates[randomX][randomY] == '▶') {
            player.field.coordinates[randomX][randomY] = '▷';
            player.field.print(false);
            System.out.println("NPC попадает");
            ;
            player.subLive();
            isHit = true;
            // TODO Прокачать скил бота
        } else if (player.field.coordinates[randomX][randomY] == '▲') {
            player.field.coordinates[randomX][randomY] = '△';
            player.field.print(false);
            System.out.println("NPC попадает");

            player.subLive();
            isHit = true;
            // TODO Прокачать скил бота
        } else {

            player.field.coordinates[randomX][randomY] = '✕';

            player.field.print(false);
            System.out.println("NPC не попадает");
        }
        return isHit;
    }
}
