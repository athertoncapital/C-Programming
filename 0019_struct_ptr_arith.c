#include <stdio.h>

#define offsetof(TYPE, MEMBER) ((size_t) &((TYPE *)0)->MEMBER)

#define container_of(ptr, type, member) ({    \
      const typeof( ((type *)0)->member ) *__mptr = (ptr);    \
      (type *)( (char *)__mptr - offsetof(type,member) );})

typedef struct {
  char name[20];
  int age;
} foo;


//  container_of(&p.age, foo, age)
//    typeof( ((foo *)0)->age ) is int
//    int *__mptr = (&p.age);
//    (foo *) ((char *) __mptr - offsetof(foo, age))

int main() {
  foo p = {
    .name="John",
        .age=40
  };

  size_t offset = offsetof(foo, age);
  printf("offset=0x%x\n", offset);
  printf("offsetof(foo,age)=0x%x\n", offsetof(foo, age));
  printf("&p=%p\n", &p);
  printf("&p.age=%p\n", &p.age);
  printf("p.age=%d\n", *(&p.age));
  printf("&p+1=%p\n", &p+1);
  printf("&((foo*)&p)[1]=%p\n", &((foo*)&p)[1]);
  char *cptr = (char*) &p;
  printf("cptr+1=%p\n", cptr+1);
  printf("cptr+20=%p\n", cptr+20);
  printf("*(int *)(cptr+20)=%d\n", *(int *)(cptr+20));
  int *mptr = (&p.age);
  foo *pptr = (foo *) ((char *) mptr-20);
  printf("*pptr=%p\n", pptr);
  //  int **agePtr;
  //  agePtr  = (int**) (&p+offset);
  //  printf("agePtr=%p\n", agePtr);
  //  printf("*(&p+offset)=%d\n", *agePtr);
  //  printf("&p+offsetof(foo,age)=%p\n", &p+offset);
  //  printf("container_of(&p.age,Person,age)=%p\n", container_of(&p.age, foo, age));
}
