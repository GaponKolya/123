package laba_1C;

public class Sandwich extends Food
{
    /* extends - значит класс является наследником
           другого класса */


    public Sandwich(String filling1, String filling2)                 // конструктор инициализации
    {
        super("Бутерброд");
        par1 = filling1;
        par2 = filling2;
    }
    public boolean equals(Object arg0)  // переопределние метода сравнения
    {
        if (super.equals(arg0))
        {
            if (!(arg0 instanceof Sandwich)) return false;
            if (!(par1.equals(((Sandwich)arg0).par1))) return false;
            return par2.equals(((Sandwich)arg0).par2);
        } else
            return false;
    }
    public Double calculateCalories()       // реализация метода подсчета калорий
    {
        calories=0.0;
        if(!par1.equals("сыр") && !par1.equals("помидор") && !par1.equals("витчина"))
            return calories;
        if(!par2.equals("сыр") && !par2.equals("помидор") && !par2.equals("витчина"))
            return calories;
        if(par1.equals("сыр") || par2.equals("сыр"))
        {
            calories += 40.0;
        }
        if(par1.equals("помидор") || par2.equals("помидор"))
        {
            calories += 20.0;
        }
        if(par1.equals("витчина") || par2.equals("витчина"))
        {
            calories += 50.0;
        }
        return calories;
    }
    public String getFilling1()         // возвращает первую начинку
    {
        return par1;
    }
    public String getFilling2()           // возвращает вторую начинку
    {
        return par2;
    }
    public String toString()       // переопределение метода преобразования в строку
    {
        return super.toString() + " c начинкой: " + par1 + " и " + par2;
    }
    public void consume()            // реализация метода consume (что произошло с объектом)
    {
        System.out.println(this + " съеден");
    }

}