/**
 * Created by Katy on 22.10.2016.
 */
public class Sandwich extends Food
{
    /* extends - значит класс является наследником
           другого класса */

    private String filling1 = null;
    private String filling2 = null;
    private Double calories = null;

    public Sandwich(String filling1, String filling2)                       // конструктор
    {
        super("Бутерброд");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }
    public String getFilling1()
    {
        return filling1;
    }
    public String getFilling2()
    {
        return filling2;
    }
    public Double calculateCalories()
    {
        if(filling1.equals("сыр") || filling2.equals("сыр"))
        {
            calories += 40.0;
        }
        else if(filling1.equals("помидор") || filling2.equals("помидор"))
        {
            calories += 20.0;
        }
        else if(filling1.equals("витчина")&& filling2.equals("витчина"))
        {
            calories += 40.0;
        }
        return calories;
    }
    public String toString()
    {
        return super.toString() + " c начинкой: " + filling1 + " и " + filling2;
    }
    public void consume()
    {                      // метод: что произошло с объектом
        System.out.println(this + " съеден");
    }

}
