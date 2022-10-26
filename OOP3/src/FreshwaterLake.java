public class FreshwaterLake extends Lake{

    String sewage_lake;
    @Override
    protected void calculate_the_weight() {
        this.weight = this.volume * 1000;
    }

    public FreshwaterLake(String _name, int _depth, int _area, String _sewage_lake){
        super(_name, _depth, _area);
        calculate_the_weight();
        this.sewage_lake = _sewage_lake;
        LakeBase.add(this);
    }

    public void printInformation(){
        super.printInformation();
        System.out.printf("Тип стока: %s;\n",this.sewage_lake);
    }

    public FreshwaterLake(){
        super();
        this.sewage_lake = "";
    }

    @Override
    protected void editing(){
        System.out.println("Выберете поле, которое вы хотите отредактировать:\n" +
                "1: Имя\n" +
                "2: Площадь\n" +
                "3: Глубина\n" +
                "4: Тип стока\n");
        int command = Integer.parseInt(UserInterface.checkword("[1-4]","Нужно ввести цифру от 1 до 4", "Введите поле(цифру) => "));
        switch (command){
            case 1:
                this.name = UserInterface.checkword("[а-яА-я]+", "Имя должно содержать только буквы!", "Введите новое имя => ");
                break;
            case 2:
                this.area = Integer.parseInt(UserInterface.checkword("[1-9]{0,7}", "Площадь это число (не более 7 цифр)!", "Введите новую площадь => "));
                this.calculate_the_volume();
                this.calculate_the_weight();
                break;
            case 3:
                this.depth = Integer.parseInt(UserInterface.checkword("[1-9]{0,4}", "Глубина это число (не более 4 цифр)!", "Введите новую глубину => "));
                this.calculate_the_volume();
                this.calculate_the_weight();
                break;
            case 4:
                this.sewage_lake = checkword("([с][т][о][ч][н][о][е])|([п][р][о][т][о][ч][н][о][е])","Озеро может быть либо сточным, либо проточным!",
                        "Введите тип стока (сточное, проточное) => ");
                break;
        }
        System.out.println("Отредактированное озеро:");
        printInformation();
    }


}
