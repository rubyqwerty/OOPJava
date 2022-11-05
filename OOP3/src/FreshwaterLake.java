public class FreshwaterLake extends Lake{

    private String sewage_lake;

    //Рассчитать массу озера
    @Override
    protected void calculate_the_weight() {
        this.weight = this.volume * 1000;
    }

    //Конструктор с параметрами
    public FreshwaterLake(String _name, int _depth, int _area, String _sewage_lake){
        super(_name, _depth, _area);
        calculate_the_weight();
        this.sewage_lake = _sewage_lake;
    }

    //Вывод информации об озере (перегруженный)
    public String getInformation(){
        return super.getInformation() + "Тип стока: " + this.sewage_lake + "\n";
    }

    //Конструктор по умолчанию
    public FreshwaterLake(){
        super();
        this.sewage_lake = "";
    }

    //Редактирование полей
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
            case "4":
                this.sewage_lake = _newValue;
                return true;
            default:
                return false;
        }
    }


}
