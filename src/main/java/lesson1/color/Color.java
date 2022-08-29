package lesson1.color;


public class Color {
    private double r;
    private double g;
    private double b;

    private double rNew;
    private double gNew;
    private double bNew;

    public Color(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;

        this.rNew = r / 255;
        this.gNew = g / 255;
        this.bNew = b / 255;

    }

    public String RGBtoHSL() {
        double cmax = cMax(rNew, gNew, bNew);
        double cmin = cMin(rNew, gNew, bNew);

        double delta = cmax - cmin;

        double h = h(cmax, delta, rNew, gNew, bNew);


        double l = (cmax + cmin) / 2;


        double s = s(l, delta);



        return "H=" + h + " S=" + s + "%" + " L=" + l + "%";

    }

    private double s(double l, double delta) {
        double lnew = 0;
        if (delta == 0) {
            lnew = 0;
        } else {
            lnew = delta / (1 - Math.abs(2 * l - 1));
        }
        return lnew;
    }

    private double h(double cmax, double delta, double rNew, double gNew, double bNew) {
        double h = 0;
        if (delta == 0) {
            h = 0;
        } else if (cmax == rNew) {
            h = 60 * (((gNew - bNew) / delta) % 6);
        } else if (cmax == gNew) {
            h = 60 * ((bNew - rNew) / delta + 2);

        } else {
            h = 60 * ((rNew - gNew) / delta + 4);
        }
        return h;
    }


    private double cMin(double rNew, double gNew, double bNew) {
        double i = Math.min(Math.min(rNew, gNew), bNew);
        return i;
    }

    private double cMax(double rNew, double gNew, double bNew) {
        double i = Math.max(Math.max(rNew, gNew), bNew);
        return i;

    }
}
