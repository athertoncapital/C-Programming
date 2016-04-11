MODULE CSEED
  INTEGER :: ISEED
END MODULE CSEED
PROGRAM Ising
  USE CSEED

  INTEGER, PARAMETER :: MAX=1000
!!!!!!!!!!!  # of spins
  INTEGER :: ELEMENT, SPIN(MAX), S, MT, E, FINAL, INITIAL
!!!!!!!!!!! E is energy
  REAL :: KT, RANF
  KT = 1.
  ISEED = 573
  DO I = 1, MAX
!!!!!!!!!!!  initial cond. , set spins = 1
     SPIN(I) = 1
  END DO
  DO I = 1, 500*MAX
!!!!!!!!!!!!  To sweep 500000 times
     INITIAL = E(SPIN, MAX)
     ELEMENT = RANF()*MAX+1
     SPIN(ELEMENT) = -1*SPIN(ELEMENT)
     FINAL = E(SPIN, MAX)
     IF ((FINAL > INITIAL) .AND. (EXP((-(FINAL-INITIAL))/KT) < RANF())) THEN
        SPIN(ELEMENT) = -1*SPIN(ELEMENT)
     END IF
  END DO
  MT = 0

  DO II = 1, 5000
!!!!!!!!!!!!!!! To sweep 5000 times of Monte Carlo
     DO I = 1, MAX
        INITIAL = E(SPIN, MAX)
        ELEMENT = RANF()*MAX+1
!!!!!!!!!!!!!!    
        SPIN(ELEMENT) = -1*SPIN(ELEMENT)
        FINAL = E(SPIN, MAX)
        IF ((FINAL > INITIAL) .AND. (EXP((-(FINAL-INITIAL))/KT) < RANF())) THEN
!!!!!!!!!!!      Metropolis ( important sampling)
           SPIN(ELEMENT) = -1*SPIN(ELEMENT)
!!!!!!!!!!!!    
        END IF
     END DO

     S = 0
     DO I = 1, MAX
        S = S + SPIN(I)
     END DO
     MT = MT + S
  END DO

  WRITE(*,*) 'Temperature =',KT,'Magnetization =', FLOAT(MT)/MAX/5000
  ! !!!!!!!!!!!!      MT/MAX/5000 =平均磁化率
END PROGRAM Ising

FUNCTION E(SPIN,MAX) 
  INTEGER :: SPIN(MAX), MAX, E
  E = 0
  DO I=1,(MAX-1)
     E = E + (-1)*SPIN(I)*SPIN(I+1)
  END DO
END FUNCTION E

FUNCTION RANF() RESULT (R)
  USE CSEED
  IMPLICIT NONE
  INTEGER :: IH,IL,IT,IA,IC,IQ,IR
  DATA IA/16807/,IC/2147483647/,IQ/127773/,IR/2836/
  REAL :: R
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
