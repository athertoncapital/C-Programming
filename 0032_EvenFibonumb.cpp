#include<iostream>
using namespace std;

int main(){
  int i=0;
  int r=0;
  unsigned long long n=40000000000000000,sum=0,a=0,b=1,c,d,e[50];
  while(1){
    c=b;
    b=a+b;
    if(b>n) break;
    a=c;
    if(b%2==0) e[i++]=b;
  }
  cin>>r;
  while(--r){
    sum=0;
    int j=0;
    cin>>n;
    while(e[j]<=n && j<i) sum+=e[j++] ;
    cout<<sum<<endl;
  }
  return 0;
}
