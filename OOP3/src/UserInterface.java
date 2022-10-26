import java.util.Scanner;

public class UserInterface {
    private static Scanner in = new Scanner(System.in);

    protected static String checkword(String regex, String massage, String whatinput){
        System.out.printf(whatinput);
        String word;
        word = in.next();
        while (!word.matches(regex)){
            System.out.println(massage);
            System.out.printf(whatinput);
            word = in.next();
        }
        return word;
    }
    public static void start(){
        Scanner in = new Scanner(System.in);
        boolean work = true;
        while (work)
        {
            System.out.printf("\n\n-------------------------------------------------------------------\n" +
                    "Ознакомтесь с командами, которые вы можете ввести:\n" +
                    "   0: Закончить\n" +
                    "   1: Определить самое большое озеро\n" +
                    "   2: Подсчитать количество озер с площадью меньше средней\n" +
                    "   3: Упорядочить список по названиям\n" +
                    "   4: Создать озеро\n" +
                    "   5: Найти озеро по названию и отредактировать\n" +
                    "   6: Просмотреть список\n\n");
            int command = Integer.parseInt(checkword("[0-6]","Команда - это число от 0 до 6", "Введите команду => "));
            switch (command){
                case 0:
                    work = false;
                    break;
                case 1:
                    if (Lake.biggestLake() == null)
                        System.out.println("Список озер пустой!");
                    else {
                        System.out.println("Самое большое озеро:");
                        Lake.biggestLake().printInformation();
                    }
                    break;
                case 2:
                    System.out.println("Количество озер с площадью меньше средней => " + Lake.number_small_lake());
                    break;
                case 3:
                    Lake.sortLakeBase();
                    System.out.println("Список отсортирован!");
                    break;
                case 4:
                    String name = checkword("[а-яА-я]+", "Название должно содержать только буквы", "Введите название озера => ");

                    int depth = Integer.parseInt(checkword("[0-9]{0,4}","Глубина это число (не больше 4 цифр)","Введите глубину озера => "));

                    int area = Integer.parseInt(checkword("[0-9]{0,7}","Площадь это число (не больше 7 цифр)", "Введите площадь озера => "));
                    System.out.printf("Введите тип озера\n" +
                            "1: пресное озеро\n" +
                            "2: минеральное озеро\n" +
                            "Введите тип => ");
                    int type = Integer.parseInt(checkword("[0-6]","Тип - это цифра 1 или 2!", "Введите тип => "));
                    if (type == 2){
                        double salt_content = Double.parseDouble(checkword("[0][.][1-9]{0,3}","Содержание соли - это число <1!", "Введите содержание соли в озере (число <1) => "));
                        new MineralLake(name, depth,area,salt_content);
                    }
                    else {
                        String sewage = checkword("([с][т][о][ч][н][о][е])|([п][р][о][т][о][ч][н][о][е])","Озеро может быть либо сточным, либо проточным!",
                                "Введите тип стока (сточное, проточное) => ");
                        new FreshwaterLake(name, depth, area,sewage);
                    }
                    System.out.printf("Озеро успешно создано, вы можете просмотреть список!\n\n");
                    break;
                case 5:
                    String _name = checkword("[а-яА-я]+","Название должно содержать только буквы","Введите название озера => ");
                    Lake.redactions(_name);
                    break;
                case 6:
                    Lake.printbase();
                    break;

            }

        }
    }
}
