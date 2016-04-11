  !20081020001.f90
PROGRAM ONE_D_MOTION
  IMPLICIT NONE
  INTEGER, PARAMETER :: n=10001,in=50
  INTEGER :: i
  REAL :: pi,dt,w,B
  REAL, DIMENSION (N):: t,x,v
  open(3,file='20081020001.dat')
  pi   = 4.0*ATAN(1.0)
  dt   = 2.0*pi/FLOAT(N-1)
  x(1) = 0.0
  t(1) = 0.0
  v(1) = 1.0
  w = 1.0
  B = 0.0
  DO i = 1, n-1
     t(i+1) = dt*i
     x(i+1) = x(i)+v(i)*dt
     v(i+1) = v(i)+(-2*B*v(i)-w*w*x(i))*dt
     x(i+1) = x(i)+(v(i)+v(i+1))/2*dt

  END DO
  WRITE (3,"(3F16.8)") (t(i),v(i),x(i),i=1,n,in)
  WRITE (6,"(3F16.8)") (t(i),v(i),x(i),i=1,n,in)
  END PROGRAM ONE_D_MOTION
