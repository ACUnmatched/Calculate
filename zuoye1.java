package kaifa;
import java.util.Scanner;
public class zuoye1 {
     public static void main(String[] args) {
    	 Scanner in = new Scanner(System.in); //定义调用
    	 double x1 = in.nextDouble();       
    	 double y1 = in.nextDouble();
    	 double x2 = in.nextDouble();
    	 double y2 = in.nextDouble();
    	 Point p1 = new Point(x1,y1);
    	 Point p2 = new Point(x2,y2);
    	 Line line = new Line(p1,p2);
    	 System.out.println( line.slope());
    	 in.close();
     }
}
class Point{   //定义点坐标
	private double x;
	private double y;
	public Point() {
		this(0,0);
	}
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double distance(Point secondPoint) {
		return distance(this,secondPoint);
	}
	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x)+(p1.y - p2.y)*(p1.y - p2.y));
	}
}
class Line{   //输出函数
	private Point start;  //起始坐标 
	private Point end;//终点坐标
	public Line(Point p1, Point p2) {
		start = p1;
		end = p2;
	}
	public double slope() {
		double d1 = end.getX() - start.getX();
		double d2 = end.getY() - start.getY();
		return d2/d1;
	}
}

