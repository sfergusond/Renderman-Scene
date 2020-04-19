public class Grass extends Ri {

    public static void main(String[] args) {
	new Grass().clump();
    }

    public void clump() {
	RiAttributeBegin();

	double[] curvepts = {
	    0,0,0,
	    0,0.5,0,
	    0,1,0,
	    0.5,1.5,1};

	RiCurves("cubic", 1, new int[] {4}, "nonperiodic", "P", curvepts, "width", new double[] {1, 0.001}, RI_NULL);

	double[] curvepts1 = {
	    0,0,0,
	    0,0.5,0,
	    1,1,0,
	    1.4,1.5,0.75};

	RiCurves("cubic", 1, new int[] {4}, "nonperiodic", "P", curvepts1, "width", new double[] {1, 0.001}, RI_NULL);

	double[] curvepts2 = {
	    0,0,0,
	    0,0.5,0,
	    0,1,0,
	    -0.1,2,-0.5};

	RiCurves("cubic", 1, new int[] {4}, "nonperiodic", "P", curvepts2, "width", new double[] {1, 0.001}, RI_NULL);

	RiAttributeEnd();

	/*
	RiWorldEnd();
	RiEnd();*/
    }
}