!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!hydrogen20080105002.f90
PROGRAM hydrogen

  REAL:: m,hbar,e0,E,dE,r,dr,psi0,psi1,psi2

  pi=3.1415926
  m=9.109534e-31
  hbar=1.05459e-34
  e0=1.602189e-19
  epsilon=8.854188e-12
  dr=0.001e-10


  OPEN(5,file='a1.dat')

  E = -13.6

  psi0 = 1
  psi1 = 1

  DO i = 1,10000
     r = i*dr
     psi2 = ( r*(2*m*(dr/hbar)**2*(-e0*e0/(4*pi*epsilon*r)-E)+2)*psi1+(dr-r)*psi0 )/(r+dr)
     psi0=psi1
     psi1=psi2

     ! write(*,*) psi2
     !         pause
     !         IF (psi2>1.e30.OR.psi2<-1.e30) THEN
     !            GOTO 10
     !   ENDIF
  ENDDO
10 WRITE(*,*) r,psi2
  WRITE(5,*) r,psi2



END PROGRAM hydrogen
