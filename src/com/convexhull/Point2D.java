package com.convexhull;

/**
 * Created by Dhaval on 6/19/2016.
 */
public class Point2D {

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c) {

        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x); // finding the determinant
        if (area2 < 0) return -1; //clockwise
        if (area2 > 0) return +1; // counter clockwise
        else return 0; //collinear
    }

}
