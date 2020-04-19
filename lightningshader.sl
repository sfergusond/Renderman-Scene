surface
lightningshader (float Ka = 10, Kd = 2;)
{
	color C = color "rgb" (0.5,0.5,1.0);;
	Oi = Os;
	Ci = Oi * C * (Ka * ambient() + Kd*diffuse(faceforward(normalize(N),I)));
}