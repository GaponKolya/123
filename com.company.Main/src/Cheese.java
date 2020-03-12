/**
 * Created by Katy on 22.10.2016.
 */
public class Cheese extends Food
{
    /* extends - значит класс является наследником
           другого класса */

    private Double calories = null;

    public Cheese()      // конструктор инициализации
    {
        super("Сыр");                      // вызывает конструктор базового класса
    }

    public Double calculateCalories()       // реализация метода подсчета калорий
    {
        calories = 30.0;
        return calories;
    }

    public void consume()           // реализация метода consume (что произошло с объектом)
    {
        System.out.println(this + " съеден");
    }

}
