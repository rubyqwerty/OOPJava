public class MineralLake extends Lake{

    private double salt_content;

    //Рассчет массы
    @Override
    protected void calculate_the_weight() {
        this.weight = this.volume * 1000 * (this.salt_content+1);
    }

    //Конструктор с параметрами
    public MineralLake(String _name, int _depth, int _area, double _salt_content){
        super(_name, _depth, _area);
        this.salt_content = _salt_content;
        calculate_the_weight();

    }

    //Конструктор по умолчанию
    public MineralLake(){
        super();
        this.salt_content = 0;
    }

    //Вывод информации об оере
    public String printInformation(){
        return super.getInformation() + "Содержание соли: " + this.salt_content + "\n";

    }

    //Редактирование полей озера
    @Override
    protected boolean editing(String _pole, String _newValue){
        switch (_pole){
            case "1":
                this.name = _newValue;
                return true;
            case "2":
                this.area = Integer.parseInt(_newValue);
                calculate_the_volume();
                calculate_the_weight();
                return true;
            case "3":
                this.depth = Integer.parseInt(_newValue);
                calculate_the_volume();
                calculate_the_weight();
                return true;
            case "5":
                this.salt_content = Double.parseDouble(_newValue);
                return true;
            default:
                return false;
        }
    }
}
