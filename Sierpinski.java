/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double x1 = 0;
		double y1 = 0;
		double x2 = 0.5;
		double y2 = 0.866;
		double x3 = 1;
		double y3 = 0;

		StdDraw.line(x1, y1, x3, y3);
		StdDraw.line(x3, y3, x2, y2);
		StdDraw.line(x2, y2, x1, y1);

		if(n > 0) sierpinski(n, x1,x2,x3,y1,y2,y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                           double y1, double y2, double y3) {
        //base case
        if(n == 0)
			return ;

        double m12x = (x1 + x2) / 2;
		double m12y = (y1 + y2) / 2;

		double m13x = (x1 + x3) / 2;
		double m13y = (y1 + y3) / 2;

		double m23x = (x2 + x3) / 2;
		double  m23y = (y2 + y3) / 2;

		StdDraw.line(m12x, m12y, m13x, m13y);
		StdDraw.line(m13x, m13y, m23x, m23y);
		StdDraw.line(m12x, m12y, m23x, m23y);

        
		sierpinski(n - 1, x1, m13x ,m12x,  y1, m13y ,m12y);
		sierpinski(n - 1, m13x ,x3 , m23x , m13y , y3, m23y);
		sierpinski(n - 1, m12x, x2, m23x , m12y, y2, m23y);
	}
}
