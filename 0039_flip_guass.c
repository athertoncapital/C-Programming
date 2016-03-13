#include <stdio.h>
#include <math.h>
#define MCS    300 
#define WIDTH  100 
#define SCREEN_HEIGHT 20
#define TEMP   1.0      
void   boundary_conditions( int [], int []);
void   initialize_hot( int []);
void   initialize_cold( int []);
void   mcmove( int[] , int [], int [] );
void   frame_xterm ( int [] );
double ran3( long int *);
main()
{
  int itime;
  int height[WIDTH];
  int nbr1[WIDTH];
  int nbr2[WIDTH];
  long int iseed; 
  float junk;
  iseed = -12888333;
  junk = ran3(&iseed);
  boundary_conditions(nbr1, nbr2);
  initialize_cold(height);  
  itime = 0;
  printf("initiate, i= %d \n", itime);
  frame_xterm(height);
  for (itime = 1 ; itime < MCS; itime++) {
    mcmove(height, nbr1, nbr2);
    printf("i= %d \n", itime);
    frame_xterm(height);
  }
  itime = MCS;
  mcmove(height, nbr1, nbr2);
  printf("final, i= %d \n", itime);
  frame_xterm(height);
}
void boundary_conditions (int nbr1[], int nbr2[]) {
  int i;
  for (i = 0 ; i < WIDTH ; i++) {
    nbr1[i] = i - 1;
    nbr2[i] = i + 1;
    if (i == 0 )        nbr1[i] = WIDTH - 1;
    if (i == WIDTH - 1) nbr2[i] = 0;
  }
void initialize_cold( int height[]) {
  int ix;
  for (ix = 0 ; ix < WIDTH; ix++) {
    height[ix] = 0;
  }
}
void initialize_hot( int height[]){
  int ix;
  long int idum;
  int zero_one, plus_minus;
  height[0] = 0;
  for (ix = 1 ; ix < WIDTH; ix++){
    zero_one   = 2*ran3(&idum);          
    plus_minus = 2*zero_one - 1;         
    height[ix] = height[ix-1] + plus_minus;
  }
}
void frame_xterm( int height[] ) {
  int ix , iy;
  int local_height;
  int spin[WIDTH][SCREEN_HEIGHT];
  int working_height;
  working_height= SCREEN_HEIGHT - 3; 
  for (ix = 0 ; ix < WIDTH; ix++) {
    local_height = height[ix] + (working_height)/2;
    if (local_height < 0) local_height = 0;
    if (local_height > working_height) local_height = WIDTH;
    for (iy = 0 ; iy < local_height; iy++) {
      spin[ix][iy] = 0;
    }
    for (iy = local_height ; iy < working_height; iy++) {
      spin[ix][iy] = 1;
    }
  }
  for (iy = 0 ; iy < working_height; iy++) {
    for (ix = 0 ; ix < WIDTH; ix++) {
      if(spin[ix][iy] == 1 ) printf("*");
      else printf(" ");
    }
    printf("\n");
  }
  printf("\n");
}
void mcmove( int height[], int nbr1[] , int nbr2[] ) {
  int i;
  int ixpick;
  int h_old, h_new, h_left, h_right;
  float E_old, E_new, dE;
  double prob ;
  int zero_one, plus_minus, flag;
  long int idum;
  for (i = 1 ; i <= WIDTH ; i++) {
    ixpick = WIDTH * ran3(&idum) ; 
    zero_one     = 2*ran3(&idum);   
    plus_minus   = 2*zero_one - 1;  
    h_old   = height [ixpick]       ;
    h_new   = height [ixpick] + plus_minus;
    h_left  = height [nbr1[ixpick]] ;
    h_right = height [nbr2[ixpick]] ;
    E_old = pow(h_left - h_old, 2) + pow(h_old - h_right, 2);
    E_new = pow(h_left - h_new, 2) + pow(h_new - h_right, 2);
    dE =  E_new - E_old,
      prob = exp ( -1.0* dE/TEMP);
    flag = 1;                    
    if ( (dE > 0) && (ran3(&idum) > prob) )  flag = 0;
    height[ixpick] = h_old - flag * (h_old - h_new);
  }
}
#include <stdlib.h>
#define MBIG 1000000000
#define MSEED 161803398       
#define MZ 0
#define FAC (1.0/MBIG)
double ran3(long *idum) {
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
