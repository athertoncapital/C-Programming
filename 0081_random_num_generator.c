#include <stdio.h>
#include <time.h>
#include <math.h>
#define NMAX 10000
#define MMAX 10000
#define LMAX    15
#define g(x)  (x*x/(exp(x*x)-1))
#define w(x)  (exp(x*x)-1)
int iseed,icpt;
double x,b,wt;
void mtsp(void);

main()
{
  int i,n,m,l;
  int t1,t2,t3,t4,t5,t6;
  time_t ts,tp;
  struct tm t;
  double z,sum1,sum2,st,ds,at;
  double ranf();
  extern int iseed,icpt;
  extern double x,b,wt;

  n = NMAX;
  m = MMAX;
  l = LMAX;
  b = 0.4;
  z = 0.46265167;

  /* Initial seed from the system time and and forced to be odd */

  ts = time(&tp);
  t  = *gmtime(&tp);
  t1 = t.tm_sec;
  t2 = t.tm_min;
  t3 = t.tm_hour;
  t4 = t.tm_mday;
  t5 = t.tm_mon;
  t6 = t.tm_year;
  iseed = t6+70*(t5+12*(t4+31*(t3+23*(t2+59*t1))));
  if ((iseed%2) == 0)
    {
      iseed = iseed-1;
    }

  /* Remove the initial configuration dependence */

  x  = ranf();
  wt = w(x);
  for (i = 0; i < m; ++i)
    {
      mtsp();
    }

  /* Collect data at every nf steps */

  sum1 = 0;
  sum2 = 0;
  icpt = 0;
  for (i = 0; i < n*l; ++i)
    {
      mtsp();
      if (i%l == 0)
	{
	  sum1 = sum1+g(x);
	  sum2 = sum2+g(x)*g(x);
	}
    }
  st = z*sum1/n;
  ds = z*sqrt(fabs(sum2/n-(sum1/n)*(sum1/n))/n);
  at = 100.0*icpt/(n*l);
  printf("%16.8lf %16.8lf %16.8lf\n", st,ds,at);
}

void mtsp(void)
/* Subroutine for one Metropolis step.
   Copyright (c) Tao Pang 1997. */
{
  double xsav,rndx,wtry,rndw;
  double ranf();
  extern int iseed,icpt;
  extern double x,b,wt;

  xsav = x;
  rndx = ranf();
  x    = x+2*b*(rndx-0.5);
  if ((x < 0) || (x > 1))
    {
      x = xsav;
    }
  else
    {
      wtry = w(x);
      rndw = ranf();
      if (wtry > (wt*rndw))
	{
	  wt   = wtry;
	  icpt = icpt+1;
	}
      else
	{
	  x = xsav;
	}
    }
}

double ranf()
/* Uniform random number generator x(n+1)= a*x(n) mod c
   with a = pow(7,5) and c = pow(2,31)-1.
   Copyright (c) Tao Pang 1997. */
{
  const int ia=16807,ic=2147483647,iq=127773,ir=2836;
  int il,ih,it;
  double rc;
  extern int iseed;
  ih = iseed/iq;
  il = iseed%iq;
  it = ia*il-ir*ih;
  if (it > 0)
    {
      iseed = it;
    }
  else
    {
      iseed = ic+it;
    }
  rc = ic;
  return iseed/rc;
}
