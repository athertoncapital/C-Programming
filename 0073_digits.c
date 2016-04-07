int digitCts(int k, int n) {
  int digit = 1;
  int cts = 0;
  while(digit <= n) {
    int low = n % digit; 
    int up = n / (digit*10); 
    int cur = n / digit % 10;
    if(cur == k) 
      // upper digits * digit + lower digits + 1;
      cts += ((up * digit) + low + 1);
    else if(cur < k)
      // upper digits * digit
      cts += (up * digit);
    else
      // (upper digits + 1: itself) * digit
      cts += ((up + (k == 0?0:1)) * digit);
    
    digit *= 10;
  }
  return cts + (k == 0 ? 1 : 0);
}
