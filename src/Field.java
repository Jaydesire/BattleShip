public class Field {

    char[][] coordinates;

    Field() {
        this.coordinates = new char[GameMenu.FIELD_SIZE][GameMenu.FIELD_SIZE];
    }

    public void printTest() {
        char cPrint = ' ';
        System.out.printf(" %2c ", ' ');
        for (int i = 0; i < GameMenu.FIELD_SIZE; i++) {
            System.out.printf(" %c ", (char) 1040 + i); //АБВГД

        }
        System.out.println();
        for (int i = 1; i < GameMenu.FIELD_SIZE + 1; i++) {
            System.out.printf(" %2d ", i);              // 12345
            for (int j = 0; j < GameMenu.FIELD_SIZE; j++) {

                cPrint = coordinates[i - 1][j];
                System.out.printf(" %c ", cPrint);
            }
            System.out.println();
        }
    }

    public void print(boolean fogOfWar) {

        char cPrint = ' ';
        System.out.printf(" %2c ", ' ');
        for (int i = 0; i < GameMenu.FIELD_SIZE; i++) {
            System.out.printf(" %c ", (char) 1040 + i); //АБВГД

        }
        System.out.println();

        for (int i = 1; i < GameMenu.FIELD_SIZE + 1; i++) {
            System.out.printf(" %2d ", i);              // 12345
            for (int j = 0; j < GameMenu.FIELD_SIZE; j++) {

                cPrint = coordinates[i - 1][j];
                if (cPrint == '_' || cPrint == 0) {
                    cPrint = '_';
                }
                if ((cPrint == '▶' || cPrint == '▲') //Туман войны
                        && fogOfWar) {
                    cPrint = '_';//TODO Заменять черные треугольники на квадраты пока не утонет корабль
                }
                System.out.printf(" %c ", cPrint);
            }
            System.out.println();
        }
    }

    public boolean newShip(int size) { //TODO возвращать ArrayList с координатами нового корабля
        //TODO добавить проверку ArrayList на соответствие попадания, если потопил, обводим поле '✕', рисуем направление корабля
        boolean freeChar = false;
        int randomInt1;
        int randomInt2;
        while (freeChar == false) {
            freeChar = true;

            randomInt1 = (int) (Math.random() * (GameMenu.FIELD_SIZE - size + 1));
            randomInt2 = (int) (Math.random() * (GameMenu.FIELD_SIZE - size + 1));


            boolean isVertical; //Ставим вертикально?
            if ((Math.random() < 0.5)) {
                isVertical = true;
            } else {
                isVertical = false;
            }

            for (int i = 0; i < size; i++) {

                if (isVertical) { //if (isVertical)
                    if (this.coordinates[randomInt1 + i][randomInt2] != 0) {
                        freeChar = false;
                        break;
                    }
                } else { //Если горизонтально
                    if (this.coordinates[randomInt2][randomInt1 + i] != 0) {
                        freeChar = false;
                        break;
                    }
                }
            }

            if (freeChar) {

                for (int i = 0; i < size; i++) {
                    if (isVertical) {//if (isVertical)

                        //Обставляем пробелами
                        if (randomInt2 < GameMenu.FIELD_SIZE - 1) {
                            this.coordinates[randomInt1 + i][randomInt2 + 1] = '_'; //Восток
                        }
                        if (randomInt2 - 1 >= 0) {
                            this.coordinates[randomInt1 + i][randomInt2 - 1] = '_'; //Запад
                        }
                        if (randomInt1 - 1 >= 0) {
                            this.coordinates[randomInt1 - 1][randomInt2] = '_'; //Север
                        }
                        if (randomInt1 + size < GameMenu.FIELD_SIZE) {
                            this.coordinates[randomInt1 + size][randomInt2] = '_'; //Юг
                        }
                        if (randomInt1 + size < GameMenu.FIELD_SIZE && randomInt2 - 1 >= 0) {
                            this.coordinates[randomInt1 + size][randomInt2 - 1] = '_'; //Юго-Запад
                        }
                        if (randomInt1 + size < GameMenu.FIELD_SIZE && randomInt2 < GameMenu.FIELD_SIZE - 1) {
                            this.coordinates[randomInt1 + size][randomInt2 + 1] = '_'; //Юго-восток
                        }
                        if (randomInt1 - 1 >= 0 && randomInt2 - 1 >= 0) {
                            this.coordinates[randomInt1 - 1][randomInt2 - 1] = '_'; //Северо-запад
                        }
                        if (randomInt1 - 1 >= 0 && randomInt2 < GameMenu.FIELD_SIZE - 1) {
                            this.coordinates[randomInt1 - 1][randomInt2 + 1] = '_'; //Северо-восток
                        }

                        //Ставим корабль
                        this.coordinates[randomInt1 + i][randomInt2] = '▲'; //Верная строчка
                        //System.out.println("Поставили корабль " +   "▲  [" + (randomInt1 + i) + "][" + randomInt2 + "]");

                    } else { //Если горизонтально

                        //Обставляем пробелами
                        if (randomInt2 < GameMenu.FIELD_SIZE - 1) {
                            this.coordinates[randomInt2 + 1][randomInt1 + i] = '_'; //Восток
                        }
                        if (randomInt2 - 1 >= 0) {
                            this.coordinates[randomInt2 - 1][randomInt1 + i] = '_'; //Запад
                        }
                        if (randomInt1 - 1 >= 0) {
                            this.coordinates[randomInt2][randomInt1 - 1] = '_'; //Север
                        }
                        if (randomInt1 + size < GameMenu.FIELD_SIZE) {
                            this.coordinates[randomInt2][randomInt1 + size] = '_'; //Юг
                        }
                        if (randomInt1 + size < GameMenu.FIELD_SIZE && randomInt2 - 1 >= 0) {
                            this.coordinates[randomInt2 - 1][randomInt1 + size] = '_'; //Юго-Запад
                        }
                        if (randomInt1 + size < GameMenu.FIELD_SIZE && randomInt2 < GameMenu.FIELD_SIZE - 1) {
                            this.coordinates[randomInt2 + 1][randomInt1 + size] = '_'; //Юго-восток
                        }
                        if (randomInt1 - 1 >= 0 && randomInt2 - 1 >= 0) {
                            this.coordinates[randomInt2 - 1][randomInt1 - 1] = '_'; //Северо-запад
                        }
                        if (randomInt1 - 1 >= 0 && randomInt2 < GameMenu.FIELD_SIZE - 1) {
                            this.coordinates[randomInt2 + 1][randomInt1 - 1] = '_'; //Северо-восток
                        }

                        //Ставим корабль
                        this.coordinates[randomInt2][randomInt1 + i] = '▶'; //Верная строчка
                        //System.out.println("Поставили корабль " +  "▶  [" + randomInt2 + "][" + (randomInt1 + i) + "]");
                    }
                }
            }
        }
        return freeChar;
    }


}
