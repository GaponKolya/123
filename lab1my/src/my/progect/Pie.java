package my.progect;

import java.util.Objects;

public class Pie extends Food {
    private String filling;

    public Pie(String filling) {
        super("Пирог ");
        this.filling = filling;
    }

    public void consume() {
        System.out.println(this + " съеден");
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Pie)) return false;
            return filling.equals(((Pie) arg0).filling);
        } else
            return false;
    }


    public String toString() {
        return super.toString() + "начинка '" + filling.toUpperCase() + "'";
    }
}

