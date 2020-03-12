/**
 * Created by Katy on 22.10.2016.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class MainApplication
{
    public static void main(String[] args) throws Exception
    {
        Food[] breakfast = new Food[20];
        int i = 0;
        boolean case1, case2; //кейсы для спец параметов(сорт и калории)
        case1 = case2 = false;

        for (String arg : args)
        {
            String[] parts = arg.split(("/")); //раздлеяем параметры ком строки
            try {
                Class myClass = Class.forName("Laba_1_C." + parts[0]);
                if (parts.length == 1) {                               //если 1 параметр(имя класса)
                    Constructor constructor = myClass.getConstructor();
                    breakfast[i] = (Food) constructor.newInstance();
                    i++;
                } else if (parts.length == 2) {                           //если 2 парметра(имя класса + метод)
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[i] = (Food) constructor.newInstance(parts[1]);
                    i++;
                } else if (parts.length == 3) {                           //если 3 параметра(имя класса + 2 метода)
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[i] = (Food) constructor.newInstance(parts[1], parts[2]);
                    i++;
                }
            } catch (ClassNotFoundException e) { //ну если ввели Coca-cola,а такого класса нет
                switch (parts[0]) {
                    case "-sort":
                        case1 = true;
                        break;
                    case "-calories":
                        case2 = true;
                        break;
                    default:
                        System.out.println("Класс " + parts[0] + " не найден.");
                        break;
                }

            } catch (NoSuchMethodException e) { //если ввели Apple/SUPERBIG,а такого метода нет
                System.out.println("Метод класса " + parts[0] + " не был найден.");
                //прочие эксепшены,чтобы не ругалась прога
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace(System.out); //вывод стек-стрейса,забей,это не понадобится
            }

        }

        System.out.println("Завтрак: "); //выводим завтрак таким,каким он был первоначально
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
                System.out.println(" " + item.calculateCalories());
            } else {
                break;
            }
        }

        if (case1) { //случай "ClassNotFoundException", когда мы задаем параметр -sort
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object o1, Object o2)
                {
                    if (o2 == null || ((Food)o2).name.length() > ((Food)o1).name.length())
                    {
                        return 1;
                    }
                    if (o1 == null || ((Food)o2).name.length() < ((Food)o1).name.length())
                    {
                        return -1;
                    }
                    else return 0;
                }
            });

            System.out.println("Завтрак:"); //ну тут понятно
            for (Food item : breakfast) {
                if (item != null) {
                    item.consume();
                    System.out.println(" " + item.calculateCalories());
                } else {
                    break;
                }
            }
        }
        if (case2)
        {    //случай "ClassNotFoundException", когда мы задаем парметр -calories
            double CaloriesCounter = 0.0;
            for (Food item : breakfast)
            {
                if (item != null) {
                    CaloriesCounter += item.calculateCalories();
                }
                else {
                    break;
                }
            }
            System.out.println("total amount of calories= " + CaloriesCounter + " cal.");

        }

    }
}