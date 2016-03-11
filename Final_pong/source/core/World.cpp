#include "include\core\World.h"
#include "include\object\border.h"
#include "include\object\pong.h"
#include "include\object\RedBrick.h"
#include "include\common\slideredbrick.h"
#include "include\common\Properties.h"
#include "include\handler\InputHandler.h"
#include "include\manager\AIManager.h"
#include "include\manager\PongManager.h"
#include "include\manager\WorldManager.h"

#include "Ogre.h"
#include "OgreMath.h"
#include "OgreSceneManager.h"
#include "OgreSceneNode.h"
#include "OgreOverlayManager.h"
#include "OgreOverlay.h"
#include "OgreFontManager.h"
#include "OgreTextAreaOverlayElement.h"
#include "OgreVector3.h"

#include <ois/ois.h>

World::World(Ogre::SceneManager *sceneManager)   : mSceneManager(sceneManager) { 
	mScore = 0;
	mWorldManager = new WorldManager(this);
	//mAIScore = 0;
	//mUserScore = 0;
	initialStates();
	
	mUser = mUserRedBrick;
	mAIPlayer = mAIRedBrick;
	
	//mOverlay = Ogre::OverlayManager::getSingleton().getByName("Score");
	//mOverlay->show();
	mBorder_4 = new Border_(mSceneManager, Borde_dim_0);
	mBorder_4->load();
	mBorder_4->setScene();
	mBorder_4->setScale(HORIZONTAL_Border__0_SCALE);
	mBorder_4->setPosition(BOTTOM_Border__0_POSITION);
	mBorder_1 = new Border_(mSceneManager, Borde_dim_0);
	mBorder_1->load();
	mBorder_1->setScene();
	mBorder_1->setScale(HORIZONTAL_Border__0_SCALE);
	mBorder_1->setPosition(Border__0_POSITION3);
	mBorder_3 = new Border_(mSceneManager, Borde_dim_0);
	mBorder_3->load();
	mBorder_3->setScene();
	mBorder_3->setScale(scaleOfyBorder);
	mBorder_3->setPosition(Border__0_POSITION2);
	mBorder_2 = new Border_(mSceneManager, Borde_dim_0);
	mBorder_2->load();
	mBorder_2->setScene();
	mBorder_2->setScale(scaleOfyBorder);
	mBorder_2->setPosition(Border__0_POSITION1);
	mUser = mUserRedBrick;
	mAIPlayer = mAIRedBrick;
	mUserRedBrick = new RedBrick(mSceneManager, RB_DIM_0);
	mUserRedBrick->load();
	mUserRedBrick->setScene();
	mUserRedBrick->setScale(RedBrick_0_SCALE);
	mUserRedBrick->setPosition(User_RedBrick_0_POSITION);
	mUser = mUserRedBrick;
    mAIRedBrick = new RedBrick(mSceneManager, RB_DIM_0);
	mAIRedBrick->load();
	mAIRedBrick->setScene();
	mAIRedBrick->setScale(RedBrick_0_SCALE);
	mAIRedBrick->setPosition(AI_RedBrick_0_POSITION);
	mAIPlayer = mAIRedBrick;
	mpong = new pong(mSceneManager, pong_0_DIMENSION);
	mpong->load();
	mpong->setScene();
	mpong->setScale(pong_0_SCALE);
	mpong->setPosition(pong_0_POSITION);
	createOverlay();
}

World::~World() {
	delete mBorder_2;
	delete mBorder_3;
	delete mBorder_1;
	delete mBorder_4;
	delete mAIRedBrick;
	delete mUserRedBrick;
	delete mpong;
	if(mLevel>=1)
	delete mpong1;
	if(mLevel>=2)
	delete mpong2;
	if(mLevel>=3)
	delete mpong3;
	if(mLevel>=4)
	delete mpong4;
	if(mLevel>=5)
	delete mpong5;
	if(mLevel>=6)
	delete mpong6;
	delete mWorldManager;
}
void World::initialStates() {
	mAIScore = 0;

	mLevel = 0;
	mUserScore = 0;
	mUser = mUserRedBrick;
	mAIPlayer = mAIRedBrick;
}
void World::think(const Ogre::Real& time) {
	mWorldManager->doWork();
	mpong->move(time);
	if(mLevel>=1)
	{
		mpong1->move(time);
	}
    if(mLevel>=2)
	{
		mpong2->move(time);
	}
	if(mLevel>=3)
	{
		mpong3->move(time);
	}
	if(mLevel>=4)
	{
		mpong4->move(time);
	}
	if(mLevel>=5)
	{
		mpong5->move(time);
	}
	if(mLevel>=6)
	{
		mpong6->move(time);
	}
	mAIPlayer->move(time);
	mUser->move(3*time);

	//mScore++;
	//Ogre::OverlayManager::getSingleton().getOverlayElement("left")->setCaption(std::to_string(mAIScore));
}

void World::getEventFrom(PongManager *pongManager) {
	mWorldManager->getEvent(pongManager);
}


bool World::flag() {
    return mLevel <-7;
}

void World::updateLevel() {
	if(!flag()){
	if (mAIScore == 3)
	{
		mLevel--;
		    mAIScore = 0;
		    mUserScore = 0;
			Ogre::Vector3 newScale = mUserRedBrick->getScale() - RedBrick_SCALE_DEC_STEP;
			if (newScale.y > RedBrick_MIN_SCALE.y) {
			    mUserRedBrick->setScale(mUserRedBrick->getScale() - RedBrick_SCALE_DEC_STEP);
			}
	}
	else if ( mUserScore == 3) {
			mLevel++;
		    mAIScore = 0;
		    mUserScore = 0;
			Ogre::Vector3 newScale = mUserRedBrick->getScale() - RedBrick_SCALE_DEC_STEP;
			if (newScale.y > RedBrick_MIN_SCALE.y) {
			    mUserRedBrick->setScale(mUserRedBrick->getScale() - RedBrick_SCALE_DEC_STEP);
				if(mLevel==1)
				{

					mpong1 = new pong(mSceneManager, pong_0_DIMENSION);
					mpong1->load();
					mpong1->setScene();
					mpong1->setScale(pong_0_SCALE);
					mpong1->setPosition(pong_0_POSITION);
				}
				else if(mLevel==2)
				{
					mpong2 = new pong(mSceneManager, pong_0_DIMENSION);
					mpong2->load();
					mpong2->setScene();
					mpong2->setScale(pong_0_SCALE);
					mpong2->setPosition(pong_0_POSITION);
				}
				else if(mLevel==3)
				{
					mpong3 = new pong(mSceneManager, pong_0_DIMENSION);
					mpong3->load();
					mpong3->setScene();
					mpong3->setScale(pong_0_SCALE);
					mpong3->setPosition(pong_0_POSITION);
				}
				else if(mLevel==4)
				{
					mpong4 = new pong(mSceneManager, pong_0_DIMENSION);
					mpong4->load();
					mpong4->setScene();
					mpong4->setScale(pong_0_SCALE);
					mpong4->setPosition(pong_0_POSITION);
				}
				else if(mLevel==5)
				{
					mpong5 = new pong(mSceneManager, pong_0_DIMENSION);
					mpong5->load();
					mpong5->setScene();
					mpong5->setScale(pong_0_SCALE);
					mpong5->setPosition(pong_0_POSITION);
				}
				else if(mLevel==6)
				{
					mpong6 = new pong(mSceneManager, pong_0_DIMENSION);
					mpong6->load();
					mpong6->setScene();
					mpong6->setScale(pong_0_SCALE);
					mpong6->setPosition(pong_0_POSITION);
				}
				} 
			}
	}


}

			

			
	
	

void World::createOverlay() {
	Ogre::OverlayManager& om = Ogre::OverlayManager::getSingleton();
	mOverlay = om.getByName("Score");
	mOverlay->show();
}

