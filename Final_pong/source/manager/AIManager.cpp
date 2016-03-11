#include "include\manager\AIManager.h"
#include "include\core\World.h"
#include "include\common\slideredbrick.h"
#include "include\object\pong.h"
#include "include\object\RedBrick.h"
#include "include\object\border.h"
#include "include\common\Properties.h"

#include "Ogre.h"
		
AIManager::AIManager(World *world) : mWorld(world) {
    monemorestep = gotopy;
}

AIManager::~AIManager() {  
}

void AIManager::think(float time)
{
	
	pong *pong =mWorld->getpong();
	
	RedBrick* mAIRedBrick = mWorld->getAIPlayer();
	//pong->setSpeed(pong->getSpeed() + pong->getvelocity()*SPEED_INC_STEP*time*10);
	int i = rand();
	i %= 3;
	switch ( i ) {
	case 0:
	// Code

		nobrainer();
	break;
	case 1:
	// Code
		//nobrainer();
		mAIRedBrick->setvelocity(RedBrick_velocity_UP*0);

	break;

	default:
	// Code
		wicked();
		//mAIRedBrick->setvelocity(RedBrick_velocity_UP*0);
	break;
	}

}

void AIManager::nobrainer() {
	pong* pong = mWorld->getpong();
	RedBrick* mAIRedBrick = mWorld->getAIPlayer();
	Border_* Border_4 = mWorld->getBorder_4();
	Border_* Border_1 = mWorld->getBorder_1();
	
	if (mAIRedBrick->hitVerticallyWith(Border_4)) {
		mAIRedBrick->setvelocity(RedBrick_velocity_UP);
	} 
	if (mAIRedBrick->hitVerticallyWith(Border_1)) {
		mAIRedBrick->setvelocity(RedBrick_velocity_neg_y);
	}
	if (mAIRedBrick->getvelocity() == RedBrick_velocity_neg_y) {
		monemorestep = gony;
	} else {
		monemorestep = gotopy;
	}
	



}

void AIManager::wicked() {

	pong* pong = mWorld->getpong();
	Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
	int mLevel = mWorld->getLevel();
			if(mLevel>=1)
		{
		pong = mWorld->getpong1();
		Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
			}

			if(mLevel>=2)
		{
		pong = mWorld->getpong2();
		Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
			}
		if(mLevel>=3)
		{
		pong = mWorld->getpong3();
		Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
			}

				if(mLevel>=4)
		{
		pong = mWorld->getpong4();
		Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
			}

		if(mLevel>=5)
		{
		pong = mWorld->getpong5();
		Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
			}

				if(mLevel>=6)
		{
		pong = mWorld->getpong6();
		Ogre::Vector3 pongvelocity = pong->getvelocity();
	if (pongvelocity.y > 0) {
		monemorestep = gotopy;
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
	} 
	if(pongvelocity.y < 0){
		pong->setSpeed(pong->getSpeed() + SPEED_INC_STEP*1000);
		monemorestep = gony;
	}
			}
}


