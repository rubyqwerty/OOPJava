public class MineralLake extends Lake{

    double salt_content;

    @Override
    protected void calculate_the_weight() {
        this.weight = this.volume * 1000 * this.salt_content;
    }

    public MineralLake(String _name, int _depth, int _area, double _salt_content){
        super(_name, _depth, _area);
        this.salt_content = _salt_content;
        calculate_the_weight();
        LakeBase.add(this);
    }

    public MineralLake(){
        super();
        this.salt_content = 0;
    }

    public void printInformation(){
        super.printInformation();
        System.out.printf("Содержание соли: %s;\n",this.salt_content);
    }

    @Override
    protected void editing(){
        System.out.println("Выберете поле, которое вы хотите отредактировать:\n" +
                "1: Имя\n" +
                "2: Площадь\n" +
                "3: Глубина\n" +
                "4: Содержание соли\n");
        int command = Integer.parseInt(UserInterface.checkword("[1-4]",
                "Нужно ввести цифру от 1 до 4", "Введите поле(цифру) => "));
        switch (command){
            case 1:
                this.name = UserInterface.checkword("[а-яА-я]+",
                        "Имя должно содержать только буквы!", "Введите новое имя => ");
                break;
            case 2:
                this.area = Integer.parseInt(UserInterface.checkword("[1-9]{0,7}",
                        "Площадь это число (не более 7 цифр)!", "Введите новую площадь => "));
                this.calculate_the_volume();
                this.calculate_the_weight();
                break;
            case 3:
                this.depth = Integer.parseInt(UserInterface.checkword("[1-9]{0,4}",
                        "Глубина это число (не более 4 цифр)!", "Введите новую глубину => "));
                this.calculate_the_volume();
                this.calculate_the_weight();
                break;
            case 4:
                this.salt_content = Double.parseDouble(checkword("[0][.][1-9]{0,3}",
                        "Содержание соли - это число <1!", "Введите содержание соли в озере (число <1) => "));
                break;
        }
        System.out.println("Отредактированное озеро:");
        printInformation();
    }
}
