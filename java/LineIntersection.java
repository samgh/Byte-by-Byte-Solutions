/*
 *   Title: Line intersection
 *
 *   Given two lines on a Cartesian plane, write a function to determine 
 *   whether or not the lines intersect.
 * 
 *   Execution: javac LineIntersection.java && java LineIntersection
 * 
 *   For more details, check out http://www.byte-by-byte.com/lineintersection/
 */

public class LineIntersection {

    private static double epsilon = 0.00001;
    private double slope;
    private double yIntercept;

    public LineIntersection(double slope, double yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    public boolean intersect(LineIntersection line) {
        if (this.equals(line)) return true;
        if (Math.abs(slope - line.slope) > epsilon) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LineIntersection)) return false;
        LineIntersection line = (LineIntersection) o;
        return Math.abs(slope - line.slope) < epsilon && 
               Math.abs(yIntercept - line.yIntercept) < epsilon;
    }

    
    // Sample test cases
    public static void main(String[] args) {

        LineIntersection line_1 = new LineIntersection(2, 5);
        LineIntersection line_2 = new LineIntersection(3, 10);

        assert line_1.intersect(line_2) == true;

        System.out.println("Passed all test cases");
    }
}
