// Don't forget to #include <glm/gtc/quaternion.hpp> and <glm/gtx/quaternion.hpp>
// Creates an identity quaternion (no rotation)
quat MyQuaternion;

// Direct specification of the 4 components
MyQuaternion = quat(w,x,y,z);
// almost never use this directly

 // Conversion from Euler angles (in radians) to Quaternion
 vec3 EulerAngles(90, 45, 0);
 MyQuaternion = quat(EulerAngles);
 
 // Conversion from axis-angle
 MyQuaternion = gtx::quaternion::angleAxis(degrees(RotationAngle), RotationAxis);





// convert a quaternion to a matrix
mat4 RotationMatrix = quaternion::toMat4(quaternion);
//use ModelMatrix to build the MVP matrix


//if two quaternions are similar ?
float matching = quaternion::dot(q1, q2);
if ( abs(matching-1.0) < 0.001 ){
// q1 and q2 are similar
}

//rotate a pt
rotated_point = orientation_quaternion *  point;
rotated_point = origin + (orientation_quaternion * (point-origin));

//interpolate between 2 quaternions
glm::quat interpolatedquat = quaternion::mix(quat1, quat2, 0.5f); // or whatever factor

//cumulate 2 rotations
quat combined_rotation = second_rotation * first_rotation;

//rotation between 2 vectors
quat RotationBetweenVectors(vec3 start, vec3 dest){
   start = normalize(start);
   dest = normalize(dest);

   float cosTheta = dot(start, dest);
   vec3 rotationAxis;
   if (cosTheta < -1 + 0.001f){
      rotationAxis = cross(vec3(0.0f, 0.0f, 1.0f), start);
      if (gtx::norm::length2(rotationAxis) < 0.01 ) // bad luck, they were parallel, try again!
            rotationAxis = cross(vec3(1.0f, 0.0f, 0.0f), start);

	    rotationAxis = normalize(rotationAxis);
	    return gtx::quaternion::angleAxis(180.0f, rotationAxis);
	    }

rotationAxis = cross(start, dest);
float s = sqrt( (1+cosTheta)*2 );
float invs = 1 / s;

return quat(
s * 0.5f,
	rotationAxis.x * invs,
 		       rotationAxis.y * invs,
 		       		      rotationAxis.z * invs
 				      );

 }
