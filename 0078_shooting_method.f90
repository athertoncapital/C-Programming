!!!!!!!!!!!!!!!!!!!!!!!!!20081117001.f90
 PROGRAM SHOOTING
 !
   IMPLICIT NONE
     INTEGER, PARAMETER :: N=201
       REAL :: DL,H,D,X0,X1,X2,F0,F1,F2
         REAL :: Y1,Y2,X,PI
	   REAL, DIMENSION (2,N) :: Y
	     INTEGER:: i,j
	     !
	     ! Initialization of the problem
	     !
	       open(3,file='20081117001.dat')
	         PI = 4.0*ATAN(1.0)
		   Y(1,1) = 0.0
		     DL = 5.0E-06
		       H  = (1.0-0.0)/(N-1)
		         X0 = 1.0
			   X1 = 4.0
			     j = 0.0
			     !
			     !
			         Y(2,1) = X0
				     DO I = 1, N-1
				           Y(1,I+1) = Y(1,I)+Y(2,I)*H
					         Y(2,I+1) = Y(2,I)+(-(PI**2/4)*(Y(1,I)+1))*H
						     END DO
						         F0 = Y(1,N)-1.0
							 !
							     Y(2,1) = X1
							         DO I = 1, N-1
								       Y(1,I+1) = Y(1,I)+Y(2,I)*H
								             Y(2,I+1) = Y(2,I)+(-(PI**2/4)*(Y(1,I)+1))*H
									         END DO
										     F1 = Y(1,N)-1.0
										         D = X1 - X0
											     WRITE (6,"(2F16.8)") F0,F1
											     !
											       DO WHILE (ABS(D).GT.DL)
											           j = j +1
												       X2 = (X0+X1)/2.
												           Y(2,1) = X2
													       DO I = 1, N-1
													             Y(1,I+1) = Y(1,I)+Y(2,I)*H
														           Y(2,I+1) = Y(2,I)+(-(PI**2/4)*(Y(1,I)+1))*H
															       END DO
															           F2 = Y(1,N)-1.0

    IF (F2*F0>0) THEN
           X0 = X2
	          F0 = F2
		      ELSE
		             X1 = X2
			            F1 = F2
				        ENDIF
					    D = X1 - X0
					        WRITE(6,"(2F16.8)") X2,F2
						  END DO
						    WRITE (6,"(2F16.8)") (H*(I-1), Y(1,I),I=1,N)
						      WRITE(6,*) j
						        WRITE (3,"(2F16.8)") (H*(I-1), Y(1,I),I=1,N)
							END
							!!!!!!!!!!!!!!!!NEW