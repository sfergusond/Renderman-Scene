
public class LsysExample extends Ri{


	public static void main(String[] args) {
		new LsysExample().go(args);
	}

	public void go(String[] args) {
		double scaleFactor= 0.5;
		int moveDown = 100;
		int which = 0;


		for (int pos = 0; pos< args.length; ) {
		    switch (args[pos].toLowerCase()) {
		    case "which" : 
			which = Integer.parseInt(args[pos+1]);
			pos = pos + 2;
			break;   
		    case "scale" :
			scaleFactor = Double.parseDouble(args[pos+1]);
			pos = pos + 2;
			break;
		    case "movedown":
			moveDown = Integer.parseInt(args[pos+1]);
			pos = pos + 2;
			break;
		    default: 
			System.out.println("Unhandled option "+args[pos]);
			pos = pos +1;
			break;
		    }
		}


		RiBegin(RI_NULL);

		RiDisplay("test.tiff","framebuffer","rgba",RI_NULL);
		RiLightSource("distantlight",RI_NULL);
		RiLightSource("ambientlight",RI_NULL);
		RiProjection("perspective",RI_NULL);

		RiFormat(1024,1024,1);
		RiPixelSamples(2,2);

		RiSurface("matte", RI_NULL);

		RiWorldBegin();

		RiAttributeBegin();
		RiColor(1.0,0.0,0.0);
		RiSurface("plastic", RI_NULL);
		RiTranslate(5.0, 0.0, 100.0);
		RiSphere(5.0, -5.0, 5.0, 360.0, RI_NULL);
		RiAttributeEnd();

		RiTranslate(0.0,250,300);
		RiScale(scaleFactor,scaleFactor,scaleFactor);
		RiRotate(180.0, 0.0, 0.0, 1.0);


		if (which == 1) {
		RiAttributeBegin();
		RiSurface("lightningshader", RI_NULL);
		lightning();
		RiAttributeEnd();}
		else
		    jungleTree();

		double[] back = {0.9,0.9,0.9};
		RiColor(back);
		RiTranslate(0,0,10);
		RiRotate(20.0,1.0,0.0,0.0);
		RiScale(1000.0,1000.0,1000.0);

	

		RiWorldEnd();

		RiEnd();


	}

	void lightning() {
	    example(new String[] {"F"+"FFF[WP[FWF]]RF"}, "FF", 4, 0.0, 1.0, 6,8);
	}

    // "F"+"FFF[WP[FWF]]RF

    void jungleTree() {
	int depth = 4 + ((int)Math.random())*3;
	double degree =20  + 40.0*Math.random();
	double percent = .7 + .2*Math.random();

	example(new String[] {"F" + "FF", "G" + "F[GFLttGFL//GF---L[G]]F[GFLssGFL\\GF+++L[G]]"}, "FF[G]++[G]---[G]", depth,degree,percent,3,8);
    }


/** generate a plant given a set of rules
	 @param rules The rules, the first character should be the left hand side.  Rules should 

	 be deterministic
	 @param axiom the starting point of the derivation
	 @param depth the depth of the derivation (the number of substitution cycles)
	 @param angle the turning angle - this is the same for all directions
	 @param percent used in stochastic rules (note - very limited)
 */
public  void example(String[] rules, String axiom, int depth, double angle, 
		double percent, double width, double length) {

	APlant pm = new APlant();
	pm.setAxiom(axiom);
	pm.setRules(rules);
	String sample = new PlantMaker().makePlant(pm,depth,percent);

	System.out.println(sample);
	
	PlantRenderer pr = new PlantRenderer(sample,
			new TurtleBuilder().length(length).width(width).angleX(angle).angleY(angle).angleZ(angle).buildSpecial());

	pr.startPlantDrawing();
}


}