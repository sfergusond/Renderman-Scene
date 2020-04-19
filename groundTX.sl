surface
groundTX (float Ka = 1, Kd  = 1;
	 color ground = color "rgb" (0.5,0.5,0.5);)
{




    vector R = normalize(reflect(I,faceforward(normalize(N),I)));
    color Cr = trace(P,R);

	Ci = Oi * (Ka * ambient() + Kd*diffuse(faceforward(normalize(N),I)) +2*Cr);
}