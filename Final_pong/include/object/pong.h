#ifndef __pong_h_
#define __pong_h_
#include "include\object\MotionObject.h"
#include "Ogre.h"

namespace Ogre {
	class SceneManager;
	class Vector3;
}

class MotionObject;


class pong : public MotionObject {
public:
	pong(Ogre::SceneManager* sceneManager, Ogre::Vector3 dimension);
	void load();
	void move(const Ogre::Real time);
	void reverseHorizontalvelocity();
	void reverseVerticalvelocity();
	void reset();

private:
	Ogre::Real mSpin;
};

#endif