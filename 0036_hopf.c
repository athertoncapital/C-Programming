/* 1-d */

#include <stdio.h>
#include <math.h>
#define LENGTH 1000
#define TEMP   2.0 
#define WARM   10
#define MCS    1000
void initialize( int [], int [] , int []);
int total_energy( int [], int [] , int []);
int total_mag( int []);
void mcmove( int[] , int [] , int [] );
void print_config( int [] , int );
void print_config_alt( int [] , int );
double ran3( long int *);
main()
{
  int itime;
  int i;
  long int iseed;
  int spin[LENGTH];
  int nbr1[LENGTH];
  int nbr2[LENGTH];
  double energy_analytic;
  int big_energy;
  int big_mag;
  double E_per_spin;
  double M_per_spin;
  big_energy = 0;
  big_mag = 0;
  itime = 0;
  iseed= -12888333;
  energy_analytic = -1.0 * tanh (1.0/TEMP);
  initialize(spin, nbr1, nbr2);
  for (i = 1 ; i <= WARM; i++)
    {
      itime = i;
      mcmove(spin, nbr1, nbr2);
    }
  //MC
  for (i = (WARM + 1) ; i <= MCS; i++)
    {
      itime = i;
      mcmove(spin, nbr1, nbr2);
      big_mag = big_mag + total_mag(spin);
      big_energy = big_energy + total_energy(spin,nbr1,nbr2);
    }

  M_per_spin = big_mag;
  M_per_spin = M_per_spin/((MCS - WARM)*(LENGTH));
  E_per_spin = big_energy;
  E_per_spin = E_per_spin/((MCS - WARM)*(LENGTH));
  printf("spin %lf \n", M_per_spin);
  printf("Energy %lf \n", E_per_spin);
  printf("spin is zero, Energy/spin is %lf \n", energy_analytic);
  printf("T %lf, Size= %d \n", TEMP , LENGTH);
  printf("# of warm-up steps is %d, No. of MCS is %d \n", WARM , MCS);
}
void mcmove( int spin[], int nbr1[] , int nbr2[])
{
  int i;
  int flag;
  int ipick;
  long int idum;
  double prob;
  prob = exp (-4.0/TEMP);
  flag = 0;
  for (i = 0 ; i < LENGTH ; i++)
    {
      ipick =  LENGTH * ran3(&idum) ;
      if ( (spin[ipick] == spin[nbr1[ipick]])
	       &&
	   (spin[nbr1[ipick]] == spin[nbr2[ipick]])
	       &&
	   (ran3(&idum) > prob)
	   )
	{
	  flag = 0;              /* flip spin if flag = 1 */
	}
      else flag = 1;
      spin[ipick] = (1 - 2*flag )*spin[ipick];
    }
}
int total_mag( int spin[] )
{
  int i;
  int foom;
  foom = 0;
  for (i = 0 ; i < LENGTH; i++) foom = foom + spin[i];
  return(foom);
}

int total_energy( int spin[] , int nbr1[] , int nbr2[])
{
  int i;
  int fooe;
  fooe = 0;
  for (i = 0;i<LENGTH;i++) fooe=fooe-spin[i]*spin [nbr2[i]];
  return(fooe);
}
void print_config( int spin[] , int itime )
{
  int i;
  for (i = 0 ; i < LENGTH; i++) printf("%d", (spin[i]+1)/2 );
  printf(" %d \n", itime);
}
void print_config_alt( int spin[] , int itime )
{
  int i;
  printf("Configuration at %d \n", itime);
  for (i = 0 ; i < LENGTH; i++)
    {
      printf("%d",spin[i]);
    }
  printf("\n");
}

void initialize( int spin[], int nbr1[] , int nbr2[])
{
  int i;
  for (i = 0 ; i < LENGTH; i++)
    {
      spin[i] = 1;
      nbr1[i] = i - 1;
      nbr2[i] = i + 1;
      if (nbr1[i] == -1 ) nbr1[i] = LENGTH;
      if (nbr2[i] == LENGTH) nbr2[i] = 0;
    }
}
#include <stdlib.h>
#define MBIG 1000000000
#define MSEED 161803398
#define MZ 0           
#define FAC (1.0/MBIG)
double ran3(long *idum)
{
  static int inext,inextp;
  static long ma[56];
  static int iff=0;
  long mj,mk;
  int i,ii,k;

  if (*idum < 0 || iff == 0){
    iff=1;
    mj = labs(MSEED-labs(*idum));
    mj %= MBIG;
    ma[55]=mj;
    mk=1;
    for (i=1;i<=54;i++){
      ii=(21*i) % 55;
      ma[ii]=mk;
      mk=mj-mk;
      if (mk < MZ) mk += MBIG;
      mj =ma[ii];
    }
    for (k=1;k<=4;k++)
      for (i=1;i<=55;i++) {
	ma[i] -= ma[1+(i+30) % 55];
	if (ma[i] < MZ) ma[i] += MBIG;
      }
    inext=0;
    inext=31;
    *idum=1;
  }
  if (++inext == 56) inext=1;
  if (++inextp == 56) inextp=1;
  mj =ma[inext]-ma[inextp];
  if (mj < MZ) mj += MBIG;
  ma[inext] =mj;
  return mj*FAC;
}

