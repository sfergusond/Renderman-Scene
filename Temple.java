public class Temple extends Ri {

    public static void main(String[] args) {
	new Temple().drawTemple();
    }

    public void drawTemple() {

	double[] stone = {0.439216 , 0.501961 , 0.564706};
	RiColor(stone);
       
	RiTranslate(0,0,1);

	RiTransformBegin();
	RiTranslate(-1.55,-.1,2.25);
	RiRotate(-45,0,0,3);
	RiRotate(90,0,1,0);
	RiScale(0.1,0.1,0.1);
	snakeHead();
	RiTransformEnd();
	
	// columns + top
	RiTransformBegin();
	RiTranslate(0,1.675,2.1); 
	RiScale(0.18,0.075,0.1);
       	RiTransformBegin();
	RiTranslate(-1,-.575,1.25);
	RiRotate(-90,1,0,0);
	RiScale(.25,.25,.75);
	column();
	RiTransformEnd();  
	
	RiTransformBegin();
	RiTranslate(-1,-.575,.75);
	RiRotate(-90,1,0,0);
	RiScale(.25,.25,.75);
	column();
	RiTransformEnd();

	RiTransformBegin();
	templeTop();
	RiTransformEnd();
	RiTransformEnd(); 
	
	// staircase 1
	RiTransformBegin();
	RiTranslate(0,0.99,2.08);
	RiScale(.18,.585,1.5);
	stairs();
	RiTransformEnd();
      
	// staircase 2
	RiTransformBegin();
	RiTranslate(-0.3,0.97,2.25);
	RiRotate(90, 0,1,0);
	RiScale(.125,.585,2.5);
	stairs();
	RiTransformEnd();

	// temple base
	RiScale(.1,.1,0.05);
	RiTransformBegin();
	RiTranslate(0.0,0.0,45.0);
	RiRotate(90.0, 1.0,0.0,0.0);
	//RiRotate(40.0, 0.0,0.0,1.0);

	RiTransformBegin();
	templeBase(9);
	RiTransformEnd();

	RiTransformBegin();
	RiTranslate(0.0,0.0,-2);
	templeBase(8);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-4);
	templeBase(7);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-6);
	templeBase(6);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-8);
	templeBase(5);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-10);
	templeBase(4);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-12);
	templeBase(3);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-14);
	templeBase(2);
	RiTransformEnd(); 

	RiTransformBegin();
	RiTranslate(0.0,0.0,-16);
	templeBase(1);
	RiTransformEnd(); 
	RiTransformEnd(); 

	//RiWorldEnd();
	//RiEnd();
    }

    void templeBase(int layer) {
	RiAttributeBegin();
	RiSurface("stoneTX2", RI_NULL);
	double sharp1 = 5.0;
	if (layer == 9)
	    sharp1 = 6.4;
	else if (layer == 8)
	    sharp1 = 6.2;
	else if (layer == 7)
	    sharp1 = 6.0;
	else if (layer == 6)
	    sharp1 = 5.8;
	else if (layer == 5)
	    sharp1 = 5.6;
	else if (layer == 4)
	    sharp1 = 5.4;
	else if (layer == 3)
	    sharp1 = 5.2;
	else if (layer == 2)
	    sharp1 = 5.0;
	else 
	    sharp1 = 4.8;
	
	double sharp2 = 3.7, vertex1 = 30+(layer*40), vertex2 = 400+(layer*65);

	double[] controlPoints[] = {
	    {-2-layer, 2+layer, 0.0}, //0 TL
	    {2+layer, 2+layer, 0.0}, //1 TR
	    {2+layer, -2-layer, 0.0}, //2 BR
	    {-2-layer, -2-layer, 0.0}, //3 BL
	    {-vertex1, vertex1, vertex2}, //4 TL
	    {vertex1, vertex1, vertex2}, //5 TR
	    {vertex1,-vertex1, vertex2}, //6 BR
	    {-vertex1, -vertex1, vertex2}}; //7 BL

	RiSubdivisionMesh("catmull-clark", 5, new int[] {4,4,4,4,4},
		new int[] {
		0,1,2,3,
		1,5,6,2,
		2,6,7,3,
		3,7,4,0,
		0,4,5,1},
	        8, new String[] {"crease","crease","crease","crease","crease","crease","crease","crease"}, 
	    new int[] {2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1, 2,1},
	    new int[] {0,1, 1,2, 2,3, 3,0, 0,4, 1,5, 2,6, 3,7},
	    new double[] {sharp1,sharp1,sharp1,sharp1,sharp2,sharp2,sharp2,sharp2},
	    "P", controlPoints); 
	RiAttributeEnd();
    }

    void stairs() {
	RiAttributeBegin();
	RiSurface("stoneTX2", RI_NULL);
	RiAttributeBegin();
	RiAttribute("displacementbound", "sphere", 10.0, RI_NULL);
	RiDisplacement("stairTX", RI_NULL);

	double[] points[] = {
	    {-1.0, 1.0, 0.0}, //0
	    {1.0, 1.0, 0.0}, //1
	    {1.0, -2.0, -0.5}, //2
	    {-1.0, -2.0, -0.5}}; //3 

	double[] points2[] = {
	    {-1.0, 1.0, 0.0}, //0
	    {1.0, 1.0, 0.0}, //1
	    {1.0, -2.0, -0.5}, //2
	    {-1.0, -2.0, -0.5}, //3
	    {1.0, -2.0, 0.0}, //4 
	    {-1.0, -2.0, 0.0}}; //5  

	RiPointsPolygons(1, new int[] {4}, new int[] {0,1,2,3}, "P", points);
	RiAttributeEnd();

	RiAttributeBegin();

	RiPointsPolygons(1, new int [] {3,3}, new int [] {
		0,5,3,
		1,4,2}, "P", points2);
	RiAttributeEnd();
			     
	RiAttributeEnd();
    }

    void snakeHead() {
	RiAttributeBegin();
	RiSurface("stoneTX", RI_NULL);
	double[] pointsBox[] = {
	    {1,1,0}, //0
	    {1,0,0}, //1
	    {0,0,0}, //2
	    {0,1,0}, //3
	    {0,1,1}, //4
	    {0,0,1}, //5
	    {1,1,1}, //6
	    {1,0,1} //7
	};

	RiSolidBegin(RI_DIFFERENCE);

	RiSolidBegin(RI_DIFFERENCE);
	
	RiSolidBegin(RI_UNION);

	RiSolidBegin(RI_UNION);

	RiSolidBegin(RI_DIFFERENCE);

	RiSolidBegin(RI_DIFFERENCE);

	RiSolidBegin(RI_DIFFERENCE);

	RiTransformBegin();
	RiRotate(90,1,0,0);

      
	RiSolidBegin(RI_PRIMITIVE);
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiSphere(1,-1,1,360,RI_NULL);
	RiSolidEnd();


	RiTransformEnd();

	RiSolidBegin(RI_PRIMITIVE);
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);	
	RiTranslate(.65,-1,-.75);
	RiScale(1,3,3);
	RiPointsGeneralPolygons(6, new int[] {1,1,1,1,1,1}, 
				new int[] {4,4,4,4,4,4},
				new int[] {
				    0,1,2,3,
				    3,2,5,4,
				    4,5,7,6,
				    1,0,6,7,
				    6,0,3,4,
				    5,2,1,7}, "P", pointsBox);

	RiSolidEnd();
	RiSolidEnd();
	RiSolidEnd();

	RiSolidBegin(RI_PRIMITIVE);
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiTranslate(-1.6,-1,-1);
	RiScale(1,3,3);
	RiPointsGeneralPolygons(6, new int[] {1,1,1,1,1,1}, 
				new int[] {4,4,4,4,4,4},
				new int[] {
				    0,1,2,3,
				    3,2,5,4,
				    4,5,7,6,
				    1,0,6,7,
				    6,0,3,4,
				    5,2,1,7}, "P", pointsBox);
	RiSolidEnd();
	RiSolidEnd(); //main body end

	// sphere - box L, sphere - box R, sphere - wedge

	RiTransformBegin();

	RiTranslate(0,-.8,-.3);
	RiRotate(120,1,0,0);
	RiScale(.4,.25,1.5);

	RiSolidBegin(RI_DIFFERENCE);
	RiRotate(-90,0,1,0);

	RiSolidBegin(RI_PRIMITIVE);
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiRotate(90,0,1,0);
	RiCone(1,1,360.0,RI_NULL);
	RiSolidEnd();
	
	RiSolidBegin(RI_PRIMITIVE);
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiTranslate(0.7,-.5,-.5);
	RiPointsGeneralPolygons(6, new int[] {1,1,1,1,1,1}, 
				new int[] {4,4,4,4,4,4},
				new int[] {
				    0,1,2,3,
				    3,2,5,4,
				    4,5,7,6,
				    1,0,6,7,
				    6,0,3,4,
				    5,2,1,7}, "P", pointsBox);
	RiSolidEnd();
	RiSolidEnd(); // cone - box
	RiTransformEnd();
	RiSolidEnd(); // cone + spherebody

	RiSolidBegin(RI_PRIMITIVE);
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiTranslate(0,0.2,-.75);
	RiRotate(-20,1,0,0);
	RiScale(0.7,0.4,.6);
	RiCylinder(1,-1,1,360,RI_NULL);

	RiTransformBegin();
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiTranslate(0,0,-2);
	RiDisk(1,1,360.0,RI_NULL);
	RiTransformEnd();
	
	RiSolidEnd();
	RiSolidEnd(); //cylinder 

	RiSolidBegin(RI_PRIMITIVE);
	double[] pointsWedge[] = {
	    {1,1,0}, //0
	    {1,0,0}, //1
	    {0,0,0}, //2
	    {0,1,0}, //3
	    {0,0,1}, //4
	    {1,0,1}, //5
	};
	
	RiTranslate(-.7,-.25,-1);
	RiRotate(70,1,0,0);
	RiScale(1.5,1,1);
	
	RiPointsGeneralPolygons(5, new int[] {1,1,1,1,1}, new int[] {4,4,4,3,3},
			       new int[] {
				   4,3,0,5,
				   0,1,2,3,
				   2,4,5,1,
				   3,2,4,
				   0,1,5}, "P", pointsWedge);
				
	RiSolidEnd();
	RiSolidEnd();

	RiSolidBegin(RI_PRIMITIVE);
	
	RiTransformBegin();
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiTranslate(.65,.3,-.4);
	RiRotate(-20,1,0,0);
	RiScale(0.2,0.2,0.3);
	RiSphere(1,-1,1,360);
	RiTransformEnd();

	RiTransformBegin();
	RiAttribute("displacementbound", "sphere", 10, RI_NULL);
	RiDisplacement("roughTX", RI_NULL);
	RiTranslate(-.65,.3,-.4);
	RiRotate(-20,1,0,0);
	RiScale(0.2,0.2,0.3);
	RiSphere(1,-1,1,360);
	RiTransformEnd();

	RiSolidEnd();
	RiSolidEnd();
	// eyeball -> sphere - small sphere
	// add RiCurve (snake inlay)

	RiAttributeEnd();
    }

    void templeTop() {
	RiAttributeBegin();
	RiSurface("stoneTX2", RI_NULL);
	RiScale(1,1,2);

	double[] points[] = {
	    {1,1,0}, //0
	    {-1,1,0}, //1
	    {-1,1,1}, //2
	    {1,1,1}, //3
	    {1,-1,0}, //4
	    {-1,-1,0}, //5
	    {-1,-1,1}, //6
	    {1,-1,1}, //7
	    {.2,-1,0}, //8
	    {.2,-.2,0}, //9
	    {-.2,-.2,0}, //10
	    {-.2,-1,0}, //11
	    {-1,-1,.25}, //12
	    {-1,-.2,.25}, //13
	    {-1,-.2,.75}, //14
	    {-1,-1,.75} //15
	};

	RiPointsGeneralPolygons(7, new int[] {1,1,2,2,1}, 
				new int[] {4,4,4,4,4,4,4},
				new int[] {
				    0,1,2,3,
				    3,7,4,0,
				    0,4,5,1, 8,9,10,11,
				    1,5,6,2, 12,13,14,15,
				    6,2,3,7}, "P", points);

	
	RiAttributeEnd();
    }

    void column() {

	double[] points[] = {
	    {1,1,.5}, //0
	    {1,-1,.5}, //1
	    {-1,-1,.5}, //2
	    {-1,1,.5}, //3
	    {-1,1,1}, //4
	    {-1,-1,1}, //5
	    {1,1,1}, //6
	    {1,-1,1} //7
	};

	RiAttributeBegin();
	RiScale(.25,.25,.5);

	RiSolidBegin(RI_UNION);
	RiCylinder(1, -1, 1, 360.0, RI_NULL);
	RiTransformBegin();	
	RiPointsPolygons(6, new int[] {4,4,4,4,4,4}, new int [] {
		0,1,2,3,
		2,3,4,5,
		4,5,7,6,
		0,1,7,6,
		0,3,4,6,
		1,2,7,5}, "P", points);
	RiTransformEnd();
	RiSolidEnd();
	RiAttributeEnd();
    }
}