int mul(int x, int y)
{
    if(y == 0)
        return 0;
    else if (x==0)
        return 0;
    else if(y > 0 && x>0)
        return (x + mul(x, y-1));
    else if(x < 0 && y<0)
        return (-x + mul(-x, -y-1));
    
    else if(y > 0 && x<0)
        return x + mul(x, y-1);
    else //(y < 0 && x>0)
        return y+ mul(x-1,y);
}


