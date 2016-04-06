int trailing(int k){
  int counter = 0;
  for(int c=5;k/c>=1;c*=5)
    counter+=k/c;
}
