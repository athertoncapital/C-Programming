#include<stdio.h>
struct point{
  int x, y; };
struct rectangle { 
  struct point upper_left, lower_right; };

int area(const struct rectangle* r);
struct point center(const struct rectangle* r);
struct rectangle move(const struct rectangle* r, int addx, int addy);
int inside(const struct rectangle* r, const struct point* p);

int main()
{
  struct rectangle box = {{2,8},{10,3}};
  struct point p = {3,6};
  printf("area is %d\n", area(&box));
  struct point c = center(&box);
  printf("center is (%d,%d)\n", c.x, c.y);
  struct rectangle box2 = move(&box, 3, 6);
  printf("moved to (%d,%d) and (%d,%d)\n", box2.upper_left.x, box2.upper_left.y, box2.lower_right.x, box2.lower_right.y);
  printf("inside function test result is %d\n", inside(&box,&p));
}

int area(const struct rectangle* r)
{
  return (((*r).lower_right.x)-((*r).upper_left.x))*(((*r).upper_left.y)-((*r).lower_right.y));
}
struct point center(const struct rectangle* r)
{
  struct point c = {((((*r).lower_right.x)+((*r).upper_left.x))/2),((((*r).lower_right.y)+((*r).upper_left.y))/2)};
  return c;
}
struct rectangle move(const struct rectangle* r, int addx, int addy)
{
  struct rectangle box2={{((*r).upper_left.x+addx),((*r).upper_left.y+addy)},{((*r).lower_right.x+addx),((*r).lower_right.y+addy)}};
  return box2;
}


int inside(const struct rectangle* r, const struct point* p)
{
  if (((*p).x)>((*r).upper_left.x)&&((*p).x)<((*r).lower_right.x)&&((*p).y)<((*r).upper_left.y)&&((*p).y)>((*r).lower_right.y))
         return 1;
  else return 0;
}
