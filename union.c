#include <stdio.h>
#include <math.h>
//#include <float.h>
#define PI (4*atan(1))

struct point { int x, y; };
struct shape {
  enum {RECTANGLE, CIRCLE} shape_type;
  struct point center; //coordinates of center
  union {
    struct {
      int height, width;
    } rectangle;
    struct {
      int radius;
    } circle;
  } u;
};
void display(const struct shape s);
double area(struct shape* s);
struct shape move(const struct shape* s, int addx, int addy);
struct shape scale(const struct shape* s, double c);
int main()
{
    struct shape a={RECTANGLE, {0,0}, {{3,4}}};
    struct shape b={CIRCLE, {0,0}, {5}};
  display(a);
  display(b);
  printf("a area is %f\n", area(&a)); 
  printf("b area is %f\n", area(&b)); 
  display(move(&a, -5, -2)); 
  display(move(&b, -5, -2)); 
  display(scale(&a,1.5)); 
  display(scale(&b,0.8));
}
void display(const struct shape s)
{
  if (s.shape_type==0) printf("Rectangle, center=(%d, %d), with height= %d, and width= %d\n",s.center.x, s.center.y, s.u.rectangle.height,s.u.rectangle.width);
  else printf("Circle, center=(%d, %d), with radius= %d\n",s.center.x, s.center.y, s.u.circle.radius);
}
double area(struct shape* s)
{
  if (((*s).shape_type)==0) return ((*s).u.rectangle.height)*((*s).u.rectangle.width);
  else return PI*((*s).u.circle.radius)*((*s).u.circle.radius);
}
struct shape move(const struct shape* s, int addx, int addy){
  if (((*s).shape_type)==0){
      struct shape S = {(*s).shape_type,{addx+((*s).center.x),addy+((*s).center.y)},{{(*s).u.rectangle.height,(*s).u.rectangle.width}}};
    return S;
  }
    else
      {
          struct shape S = {(*s).shape_type,{addx+((*s).center.x),addy+((*s).center.y)},{{(*s).u.circle.radius}}};
    return S;
  }	

}
struct shape scale(const struct shape* s, double c){
  if (((*s).shape_type)==0){
      struct shape S = {(*s).shape_type,{((*s).center.x),((*s).center.y)},{{c*((*s).u.rectangle.height),c*((*s).u.rectangle.width)}}};
    return S;
  }
    else
      {
          struct shape S = {(*s).shape_type,{((*s).center.x),((*s).center.y)},{{c*((*s).u.circle.radius)}}};
    return S;
  }
}
