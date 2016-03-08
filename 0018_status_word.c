#include <stdio.h>
typedef struct
{
  unsigned lo:4; // unsigned hi, lo:4;
  unsigned hi:4; // two lines
} byte;

typedef struct
{
  unsigned m:1;
  unsigned b2:5;
  unsigned t:1;
  unsigned i:1;
  unsigned b1:20;
  unsigned v:1;
  unsigned c:1;
  unsigned z:1;
  unsigned n:1;
} SW_;

int main() {
  byte b = { .hi=0x0F, .lo=0x0C };
  unsigned char *bp = (unsigned char*) &b;
  printf("byte=%02x\n", *bp);

  SW_ sw = { .n=1,.z=0,.c=1,.v=0,.i=1,.t=1,.m=0,.b1=0,.b2=0 };
  unsigned int *psw = (unsigned int*) &sw;
  printf("SW=%08x\n", *psw);
}
