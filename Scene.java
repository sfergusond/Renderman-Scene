public class Scene extends Ri {

    public static void main(String[] args) {
	new Scene().scene();
    }


    public void scene() {

	double[] lightningColor = {0,1,1}, p1 = {25,15,50}, p2 = {0,0,80}, p3 ={.5,1,0}, p4 = {0,-10,0}, p5 = {9,-19,25};
	RiLightSource("distantlight", "from",p3,"intensity", 10, RI_NULL);
	RiLightSource("pointlight", "lightcolor", lightningColor, "from", p1, "intensity", 100);
	RiIlluminate(1, RI_FALSE);

	RiTranslate(0,0,100); 

	RiAttributeBegin();
	RiTranslate(0,85,10);
	RiRotate(-35, 1,0,0);
	RiScale(1,0.2,1);
	starfield();
	RiAttributeEnd();

	RiAttributeBegin();
	RiIlluminate(1,RI_TRUE);
	RiTranslate(10,-16,-71);
	RiRotate(-25,0,1,0);
	RiRotate(35, 1,0,0);
	RiRotate(20,0,0,1);
	RiScale(4,4,4);
	RiSurface("stoneTX",RI_NULL);
	new Temple().snakeHead();
	RiIlluminate(1,RI_FALSE);
	RiAttributeEnd();

	RiAttributeBegin();
	RiSurface("skyTX", RI_NULL);
	RiAttribute("visibility", "specular", 1, RI_NULL);
	RiAttribute("visibility", "diffuse", 1, RI_NULL);
	RiTranslate(0,50,100);
	RiRotate(-35, 1,0,0);
	RiScale(500,125,1);
	sky();
	RiAttributeEnd();

	RiAttributeBegin();
	RiAttribute("visibility", "diffuse", 1, RI_NULL);
	RiAttribute("visibility", "specular", 1, RI_NULL);
	double[] grey = {0.5,0.5,0.5};
	RiColor(grey);
	//RiSurface("matte", "Ka", 0.01, "Kd", 0.8,RI_NULL);	
	RiSurface("groundTX", RI_NULL);
	RiTranslate(0, -20, -110);
	RiRotate(90,1,0,0);
	RiScale(110,110,1);
	sky();
	RiAttributeEnd();

	RiAttributeBegin();
	RiIlluminate(1, RI_TRUE);
	RiAttribute("visibility", "specular", 1, RI_NULL);
	RiAttribute("visibility", "specular", 1, RI_NULL);
	RiTranslate(30,-16,-120);
	RiRotate(-35,0,1,0);
	RiScale(20,20,30);
	new Temple().drawTemple();
	RiIlluminate(1, RI_FALSE);
	RiAttributeEnd(); 

	RiAttributeBegin();
	RiAttribute("visibility", "specular", 1, RI_NULL);
	RiAttribute("visibility", "diffuse", 1, RI_NULL);
	RiTranslate(25,25,-50);
	RiRotate(-25,1,0,0);
	RiScale(3,1.5,1);
	new Cloud().cloud();
	RiAttributeEnd();

	RiAttributeBegin();
	RiSurface("lightningshader", RI_NULL);
	RiAttribute("visibility", "specular", 0, RI_NULL);
	RiAttribute("visibility", "diffuse", 0, RI_NULL);
	RiTranslate(40,35,-30);
	RiRotate(180,0,0,1);
	RiScale(.065,.065,.065);
	new LsysExample().lightning();
	RiTranslate(180,0,0);
	new LsysExample().lightning();
	RiAttributeEnd(); 

	RiAttributeBegin();
	RiAttribute("visibility", "specular", 1, RI_NULL);
	RiAttribute("visibility", "diffuse", 1, RI_NULL);
	RiSurface("lightningshader", RI_NULL);
	RiTranslate(8,20,-105);
	RiRotate(160,0,0,1);
	RiScale(.1,.1,.1);
	new LsysExample().lightning();
	RiAttributeEnd();
    }

    void sky() {
	RiAttributeBegin();
	double[] points[] = {
	    {1,1,0},
	    {1,-1,0},
	    {-1,-1,0},
	    {-1,1,0}
	};

	RiPolygon(4,RI_P,points);
	RiAttributeEnd();
    }
 
   void grass() {
	int xcoord = -100, zcoord = 0;
	for (int i = 0; i < 10000; i+= 1) {
	    if (i%200 == 0) {
		xcoord = -100;
		zcoord += 1;
	    }
	    else {
		RiTransformBegin();
		RiTranslate(xcoord + 0.9 * Math.random(),0,zcoord + 0.9*Math.random());
		//RiRotate(360*Math.random(),0,1,0);
		RiScale(.5 + 0.3*Math.random(),.5 +0.3*Math.random() ,.5);
		new Grass().clump();
		RiTransformEnd();
		xcoord += 1;
	    }
	}
    }

    void starfield() {
	RiAttributeBegin();
	double xcoord = 0, ycoord = 0, zcoord = 0, size = 0;
	double[] coords = new double[99], sizes = new double[33];
	for (int i = 0; i< 99; i+= 3){
	    xcoord = 200*Math.random()-100;
	    ycoord = 200*Math.random()-100;
	    size = .8 * Math.random()+0.2;
	    coords[i] = xcoord;
	    coords[i+1] = ycoord;
	    coords[i+2] = zcoord;
	    sizes[i/3] = size;
	}
	RiPoints(coords.length, "P", coords, "width", sizes, RI_NULL);
	RiAttributeEnd();
    }

}