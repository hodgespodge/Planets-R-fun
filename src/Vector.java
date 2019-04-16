public class Vector {
    private double x_1, x_2;
    private double length;


    public Vector(double x_1, double x_2) {
        this.x_1 = x_1;
        this.x_2 = x_2;
        this.length = Math.sqrt(this.get_x_1() * this.get_x_1() + this.get_x_2() * this.get_x_2());
    }

    // getters

    public double get_x_1() {
        return this.x_1;
    }

    public double get_x_2() {
        return this.x_2;
    }

    public double get_length() {
        return this.length;
    }


    // Operations

    public Vector add(Vector v) {
        double new_x_1 = get_x_1() + v.get_x_1();
        double new_x_2 = get_x_2() + v.get_x_2();
        return new Vector(new_x_1, new_x_2);
    }

    public Vector subtract(Vector v) {
        double new_x_1 = this.get_x_1() - v.get_x_1();
        double new_x_2 = this.get_x_2() - v.get_x_2();
        return new Vector(new_x_1, new_x_2);
    }

    public Vector scale(double scalar) {
        return new Vector(this.get_x_1() * scalar, this.get_x_2() * scalar);
    }

    public Vector get_normalized_vector() {
        double new_x_1 = this.get_x_1() / this.get_length();
        double new_x_2 = this.get_x_2() / this.get_length();
        return new Vector(new_x_1, new_x_2);
    }
}
