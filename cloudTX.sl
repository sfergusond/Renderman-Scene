float
snoise(float x; float y) {
	     return 2*noise(x,y)-1;
}

surface
cloudTX(float Ka = 0.7, Kd = 1, freq = 0.25;
	      color c1 = color "rgb" (.9,.9,.9);)
{

color C;

float xM = 5, yM =4, amp = 1, noi = 0, i;

for (i=1;i<129;i=i*2){
    noi = noi + snoise(s*i,t*i)/(2*i);
}

C = noi*c1 + (0.5,0.5,0.5);

Oi = 0.6*Os;
Ci = Oi * C *(Ka*ambient()+Kd*diffuse(faceforward(normalize(N),I)));
}