!!!!!!!!!!!!20081020004.f90
PROGRAM ONE_D_MOTION
  IMPLICIT NONE
  INTEGER, PARAMETER :: n=40001,in=50
  INTEGER :: i
  REAL :: pi,dt,Wo,B,Fo,W
  REAL, DIMENSION (N):: t,x,v
  open(3,file='20081020004.dat')
  pi   = 4.0*ATAN(1.0)
  dt   = 16.0*pi/FLOAT(N-1)
  x(1) = 0.0
  t(1) = 0.0
  v(1) = 10.0
  Wo = 0.1428
  W = 0.12
  B = 0.20
  Fo = 100.0

  DO i = 1, n-1
     t(i+1) = dt*i
     !Predicting for x & v
     x(i+1) = x(i)+v(i)*dt
     v(i+1) = v(i)+(-2*B*v(i)-Wo*Wo*x(i)+Fo*COS(w*t(i)))*dt
     !Correcting for x & v
     x(i+1) = x(i)+(v(i)+v(i+1))/2*dt
     v(i+1) = v(i)+((-2*B*v(i)-Wo*Wo*x(i)+Fo*COS(w*t(i)))+(-2*B*v(i+1)-Wo*Wo*x(i+1)+Fo*COS(w*t(i+1))))/2*dt
  END DO
  WRITE (3,"(3F16.8)") (t(i),v(i),x(i),i=1,n,in)
  WRITE (6,"(3F16.8)") (t(i),v(i),x(i),i=1,n,in)
END PROGRAM ONE_D_MOTION
