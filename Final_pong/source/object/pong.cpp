#include "include\object\pong.h"
#include "include\object\MotionObject.h"
#include "include\common\Properties.h"

#include "OgreSceneManager.h"
#include "OgreSceneNode.h"
#include "OgreVector3.h"
#include "Ogre.h"

pong::pong(Ogre::SceneManager* sceneManager, Ogre::Vector3 dimension) : MotionObject(sceneManager, dimension, 
																				   pong_0_SPEED, pong_MOVE_User_BOTTOM) {
	mSpin = 1000;
}

void pong::move(const Ogre::Real time) {
	Ogre::SceneNode* sceneNode = getSceneNode();
	sceneNode->translate(getvelocity() * getSpeed() * time);
	sceneNode->roll(Ogre::Degree(mSpin*time));
}

void pong::load() {
	Ogre::SceneManager* sceneManager = getSceneManager();
	Ogre::Entity* entity = sceneManager->createEntity("Sphere.mesh");
	setEntity(entity);
}

void pong::reverseHorizontalvelocity() {
	setvelocity(getvelocity() * HORIZONTAL_REVERSE_FACTOR);
}

void pong::reverseVerticalvelocity() {
	setvelocity(getvelocity() * VERTICAL_REVERSE_FACTOR);
}

void pong::reset() {
	setPosition(pong_0_POSITION);
	setSpeed(pong_0_SPEED);
}