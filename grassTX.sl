surface
grassTX (color bottom = color "rgb" (0.000000 , 0.392157 , 0.000000),
	top = color "rgb" (0.678431 , 1.000000 , 0.184314);)
{

color C;
C = mix(bottom,top,v);

normal Ni = faceforward(normalize(N),I);

Ci = C * (1.3*ambient() + 0.7*diffuse(Ni));
}