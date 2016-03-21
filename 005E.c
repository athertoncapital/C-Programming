double inner_product(double *a, double* b, int n)
{
 if (n==0){
    return 0.0;}
  else
    {
          
      return ((*a)*(*b)
              )+inner_product((a+1), (b+1), n-1);
    }
}
