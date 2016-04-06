#include <stdio.h>
//Reference: CS420 David Galles Lecture Notes 
class A
{
public:
  void P1() {printf("P1 in A\n");}
  virtual void P2() {printf("P2 in A\n");}
  virtual void P3() {printf("P3 in A\n");}

};

class B : public A
{
public:
  void P1() {printf("P1 in B\n");}
  void P2() {printf("P2 in B\n");}
};


class C : public B
{
public:
  void P1() {printf("P1 in C\n");}
  void P2() {printf("P2 in C\n");}
  void P3() {printf("P3 in C\n");}
};


int main()
{
  A aVar;
  B bVar;
  C cVar;
  A *aPtr = new C();
  B *bPtr = new C();

  aVar.P1();
  aVar.P2();
  aVar.P3();
  printf("--------\n");
  bVar.P1();
  bVar.P2();
  bVar.P3();
  cVar.P1();
  cVar.P2();
  cVar.P3();
  printf("--------\n");
  aPtr->P1();
  aPtr->P2();
  aPtr->P3();
  bPtr->P1();
  bPtr->P2();
  bPtr->P3();
  printf("--------\n");
  aVar = cVar;
  aVar.P1();
  aVar.P2();
  aVar.P3();
  printf("--------\n");
  bVar = cVar;
  aPtr = &(bVar);
  aPtr->P1();
  aPtr->P2();
  aPtr->P3();
}
