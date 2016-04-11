!I let the computer do it 10000 times.

!Take ten times (the sum of Xi)*M
!by using the command:
!if(MOD(J,1000).eq.0)  WRITE(*,*)Y
!  4.6000001E-03
!   -1.4800000E-02
!    -1.4000000E-02
!      7.1999999E-03
!       -3.0000000E-03
!        -9.6000005E-03
!	 -1.0600000E-02
!	   3.1999999E-03
!	     6.2000002E-03
!	      -1.1200000E-02
!	        5.8200068E-05
!
!Finally, we obtained the results as follow :
!      Mean(SYbar)    Variance            Standard derivation
!            0.00005820      0.00009886      0.00994298
	    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!20081208003.f90
	    MODULE CSEED
	      INTEGER :: ISEED
	      END MODULE CSEED
	      !
	      PROGRAM MCDS
	      !
	      ! Integration with the direct sampling Monte Carlo scheme.
	      !
	      !
	        USE CSEED
		  IMPLICIT NONE
		    INTEGER, PARAMETER :: M=10000
		      INTEGER :: j,I
		        REAL ::mean, Variance,Sd,X,F,FX,R,RANF,pi,Xi,Y,Yb,SY,SYbar,SYSYbar,SYSY,Standard_derivation

  ISEED =13
    SY=0.
      SYSY=0.
        DO j = 1, M
	   Y=0.0

   DO I = 1, M

     X=RANF()
          If (X < 0.5) THEN
	           Xi=1
		        Else
			         Xi=-1
				      End if
				           Y=Y+Xi
					      END DO
					        Y=Y/M
						  if(MOD(J,1000).eq.0)  WRITE(*,*)Y
						    SY=SY+Y
						      SYSY=SYSY+Y*Y
						        End do
							  SYbar=SY/M
							    SYSYbar=SYSY/M
							      WRITE(*,*)SYbar
							        Variance=ABS(SYSYbar-SYbar**2)
								  Standard_derivation= SQRT(ABS(SYSYbar-SYbar**2))
								    WRITE(6,"(3F16.8)") SYbar,Variance,Standard_derivation
								    END PROGRAM MCDS
								    FUNCTION FX(X) RESULT (F)
								      IMPLICIT NONE
								        REAL :: X,pi,F
									 pi=3.1445926
									  F = exp(-1*(X**2)/2)/((2*pi)**0.5)
									  END FUNCTION FX
									  !
									  FUNCTION RANF() RESULT (R)
									  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
									  !! Uniform random number generator x(n+1) = a*x(n) mod c with!!
									  !! a=7**5 and c = 2**(31)-1.  Copyright (c) Tao Pang 1997.   !!
									  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
									    USE CSEED
									      IMPLICIT NONE
									        INTEGER :: IH,IL,IT,IA,IC,IQ,IR
										  DATA IA/16807/,IC/2147483647/,IQ/127773/,IR/2836/
										    REAL :: R
										    !
										      IH = ISEED/IQ
										        IL = MOD(ISEED,IQ)
											  IT = IA*IL-IR*IH
											    IF(IT.GT.0) THEN
											        ISEED = IT
												  ELSE
												      ISEED = IC+IT
												        END IF
													  R = ISEED/FLOAT(IC)
													  END FUNCTION RANF

