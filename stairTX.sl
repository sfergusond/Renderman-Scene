displacement
stairTX ( float frequency = 0.075;)
{
    float tmod = mod (t, frequency);
    point newP;
    float change;

    change = step(0.4*frequency, tmod);

    if (s <= 0.8 && s > -.8) {
       newP = P - (change * normalize(N));
       N = calculatenormal(newP);
    }  
        
}
