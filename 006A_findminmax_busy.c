#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "timer.h"
/* Global variables */
int     thread_count;
int     n;
double* A;
double max, min;
//double start, finish;
/* Serial functions */
void Usage(char* prog_name);
void Gen_matrix(double A[], int n);
void Print_matrix(char* title, double A[], int n);

/* Parallel function */
void *work2(void* rank);

/* Busy-Waiting*/
volatile int flag = 0;

/*------------------------------------------------------------------*/
int main(int argc, char* argv[]) {
    long       thread;
    pthread_t* thread_handles;
    
    if (argc != 3) Usage(argv[0]);
    thread_count = strtol(argv[1], NULL, 10);
    n = strtol(argv[2], NULL, 10);
    thread_handles = malloc(thread_count*sizeof(pthread_t));
    A = malloc(n*sizeof(double));
    srandom(1);
    Gen_matrix(A, n);
    //GET_TIME(start);
    for (thread = 0; thread < thread_count; thread++)
    pthread_create(&thread_handles[thread], NULL,
                   work2, (void*) thread);
    
    for (thread = 0; thread < thread_count; thread++)
    pthread_join(thread_handles[thread], NULL);
    //GET_TIME(finish);
    //printf("Elapsed time = %e seconds \n", finish - start);
    free(A);

    free(thread_handles);

    printf("min = %.6f, max = %.6f\n",min,max);
    return 0;
}  /* main */


/*------------------------------------------------------------------
 * Function:  Usage
 * Purpose:   print a message showing what the command line should
 *            be, and terminate
 * In arg :   prog_name
 */
void Usage (char* prog_name) {
    fprintf(stderr, "usage: %s <thread_count> <size>\n", prog_name);
    exit(0);
}  /* Usage */

/*------------------------------------------------------------------
 * Function: Gen_matrix
 * Purpose:  Use the random number generator random to generate
 *    the entries in A
 * In args:  m, n
 * Out arg:  A
 */
void Gen_matrix(double A[], int n) {
    int j;
    for (j = 0; j < n; j++)
      { A[j] = random()/((double) RAND_MAX);}
}  /* Gen_matrix */

/*------------------------------------------------------------------
 */
/*void *work(void* rank) {
    long my_rank = (long) rank;
    int local_n = n/thread_count;
    int i;
    int k;
    
    int my_min = my_rank*local_n;
    int my_max = my_min + local_n - 1;
    
    
    for (i = my_min; i <= my_max; i++) {
        y[i] = 0.0;
        
        // Count number of elements > list[i]
        for (k = 0; k < n; k++)
        if (A[k] > A[i]) p[i]++;
    }
    for (i = my_min; i <= my_max; i++)
    y[p[i]] = A[i];
    return NULL;
    } *//* Thread work */
/*------------------------------------------------------------------
 */
void *work2(void* rank) {
    long my_rank = (long) rank;
    int local_n = n/thread_count;
    int i;
    int my_first = my_rank*local_n;
    int my_last = my_first + local_n - 1;
    double localm;
    double localM;
   if(n%thread_count != 0 && my_rank == thread_count-1)
    my_last = n-1;
    

    localm=A[my_last];
    localM=A[my_first];
    
    for (i = my_first; i <= my_last; i++) {
      
      // Count number of elements > list[i]
      if (A[i]<localm) localm = A[i];
      if (A[i]>localM) localM = A[i];

    }
    while(flag!=my_rank);
    if(min>localm)
    min=localm;
    if(max<localM)
    max=localM;
    flag++;    
    return NULL;
} /* Thread work */



/*------------------------------------------------------------------
 * Function:    Print_matrix
 * Purpose:     Print the matrix
 * In args:     title, A, 1, n
 */
void Print_matrix( char* title, double A[], int n) {
    int   j;
    
    printf("%s\n", title);
   
        for (j = 0; j < n; j++)
        printf("%6.3f ", A[n + j]);
        printf("\n");

}  /* Print_matrix */


