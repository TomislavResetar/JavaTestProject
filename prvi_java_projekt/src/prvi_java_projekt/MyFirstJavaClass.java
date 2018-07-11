package prvi_java_projekt;


public class MyFirstJavaClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int c; double d;
		
		Circle circ = new Circle();
		circ.findArea(2.0);
		
		Circle circ2 = new Circle();
		circ2.findArea(5.0);
		
		Circle circ3 = new Circle();
		circ3.findArea(6.0); 
		
		c=add2(2,3);
		d=add2(2.3,3.2);
		System.out.println(c);
		System.out.println(d);
		
		System.out.println(circ.area);
		System.out.println(circ2.area);
	}


	public static int add2(int a, int b) {
		System.out.println("Integer version called.");
		return a+b;
	}
	
	public static double add2(double a, double b) {
		System.out.println("Double version called.");
		return a+b;
	}
	
	
}

class Circle
{
	double radius;
	double area;
	
	public void findArea(double r)
	{
		radius=r;
		area=r*r*Global.PI;
	}
	
}
