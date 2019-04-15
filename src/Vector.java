public class Vector extends Point {
    private Point p;
    private Vector normalized;
    private double length;


    public Vector(double x_1, double x_2) {
        super(x_1, x_2);
        this.length = norm(this);
        this.normalized = normalize(this);
    }

    public double get_length() {
        return this.length;
    }

    public Vector get_normalized_vector() {
        return this.normalized;
    }

    public Vector add(Vector v) {
        double new_x_1 = get_x_1() + v.get_x_1();
        double new_x_2 = get_x_2() + v.get_x_2();
        return new Vector(new_x_1, new_x_2);
    }

    public Vector subtract(Vector v) {
        double new_x_1 = this.vector.get_x_1() - v.get_x_1();
        double new_x_2 = this.vector.get_x_2() - v.get_x_2();
        return new Vector(new_x_1, new_x_2);
    }


    // static functions

    private static double norm(Vector v) {
        return Math.sqrt(v.get_x_1() * v.get_x_1() + v.get_x_2() * v.get_x_2());
    }

    private static Vector normalize(Vector v) {
        double new_x_1 = v.get_x_1() / v.norm;
        double new_x_2 = v.get_x_2() / v.norm;
        return new Vector(new_x_1, new_x_2);
    }
}
