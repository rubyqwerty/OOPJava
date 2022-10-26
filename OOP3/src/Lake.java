import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class Lake extends UserInterface{

    public String name;
    int depth;
    int area;
    int volume;
    double weight;
    public static ArrayList<Lake> LakeBase = new ArrayList<>();

    public Lake (){
        this.area = 0;
        this.depth = 0;
        this.name = "";
        this.volume = 0;
        this.weight = 0;
    }

    public Lake(String _name, int _depth, int _area){
        this.name = _name;
        this.depth = _depth;
        this.area = _area;
        calculate_the_volume();
    }

    //Рассчет массы озера
    protected abstract void calculate_the_weight();

    protected abstract void editing();

    public static void printbase(){
        System.out.printf("-----------------------------Вывод информации о всех озерах-----------------------\n");
        for (int i = 0; i < LakeBase.size(); ++i)
          LakeBase.get(i).printInformation();
        System.out.printf("----------------------------------------------------------------------------------\n");
    }

    public void printInformation(){
        System.out.printf("---------------Информация-----------------\n");
        System.out.printf("Имя озера: %s;\n",this.name);
        System.out.printf("Глубина озера: %s;\n",this.depth);
        System.out.printf("Площадь озера: %s;\n",this.area);
        System.out.printf("Объем озера: %s;\n",this.volume);
        System.out.printf("Масса озера: %s;\n",this.weight);
    }

    //Рассчет объема
    protected void calculate_the_volume(){
        this.volume = this.area * this.depth;
    }


    //Упорядочивание списка озер
    public static void sortLakeBase(){
        Collections.sort(LakeBase, new Comparator<Lake>() {
            @Override
            public int compare(Lake o1, Lake o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }

    //Самое большое озеро
    public static Lake biggestLake(){
        if (LakeBase.isEmpty())
            return null;
        Lake result = LakeBase.get(0);
        int max = result.volume;
        for (int i = 1; i < LakeBase.size(); ++i)
            if (LakeBase.get(i).volume > max) {
                result = LakeBase.get(i);
                max = LakeBase.get(i).volume;
            }
        return result;
    }

    //Средняя площадь озер
    protected static double average_area(){
        double sum = 0;
        for (int i = 0; i < LakeBase.size(); ++i)
            sum += LakeBase.get(i).area;
        return sum / LakeBase.size();
    }

    //Количество озер с плотностью меньше средней
    public static int number_small_lake() {
        int count = 0;
        double average = average_area();
        for (int i = 0; i < LakeBase.size(); ++i)
            if (LakeBase.get(i).area < average)
                count++;
        return count;
    }

    private static Lake search(String _name){
        for (int i = 0; i < LakeBase.size(); ++i)
            if (_name.equals(LakeBase.get(i).name))
                return LakeBase.get(i);
        return null;
    }

    public static void redactions(String _name){
        Lake lake = search(_name);
        if (lake == null){
            System.out.println("Нет озера с таким названием!");
            return;
        }
       lake.editing();
    }


}