#include "include\manager\PongManager.h"
#include "include\manager\AIManager.h"
#include "include\handler\InputHandler.h"
#include "include\core\World.h"
#include "include\common\slideredbrick.h"

#include "OgreCamera.h"
#include "OgreColourValue.h"
#include "OgreOverlayManager.h"
#include "OgreOverlay.h"
#include "Ogre.h"
#include <ois.h>

PongManager::PongManager(Ogre::SceneManager* sceneManager, Ogre::RenderWindow *mainWindow) : mSceneManager(sceneManager), mRenderWindow(mainWindow) {
	flag = false;
createGameOverOverlay();
}

// On every frame, call the appropriate managers
bool PongManager::frameStarted(const Ogre::FrameEvent &evt) {
	Ogre::Real time = evt.timeSinceLastFrame;
	if (time > 0.5) {
		time = 0.5;
	}
	mInputHandler->think(time);
	think(time);
	mAIManager->think(time);
	mWorld->think(time);
	return mKeepGoing;
}

void PongManager::think(const Ogre::Real& time) {
	mWorld->getEventFrom(this);
	if (mInputHandler->isKeyDown(OIS::KC_ESCAPE) || mRenderWindow->isClosed()) {
		mKeepGoing = false;}
		if (mWorld->flag()) {
		flag = true;
		mGameOverOverlay->show();
		if(mWorld->getAIPlayerScore()>2)
		startOver();
			//mKeepGoing = false;

	}
		if (mInputHandler->isKeyDown(OIS::KC_RETURN) && !mInputHandler->wasKeyDown(OIS::KC_RETURN)) {
		startOver();
	}
	}
void PongManager::startOver() {
	flag = false;
	mGameOverOverlay->hide();
	mWorld->reset();
}

void PongManager::createCamera() {
	mCamera = mSceneManager->createCamera("USERCam");
	mCamera->setPosition(Ogre::Vector3(300, 60, 100));
	mCamera->lookAt(Ogre::Vector3::ZERO);
	mCamera->roll(Ogre::Degree(90.0f));
}

// We will have a single viewport.  If you wanted splitscreen, or a rear-view mirror, then
// you may want multiple viewports.


void PongManager::createViewports() {
	Ogre::Viewport* vpUser = mRenderWindow->addViewport(mCamera);
    vpUser->setBackgroundColour(Ogre::ColourValue(1, 1, 1));
    mCamera->setAspectRatio(Ogre::Real(vpUser->getActualWidth()) / Ogre::Real(vpUser->getActualHeight()));

}

void PongManager::setUp() {
	mSceneManager->setAmbientLight(Ogre::ColourValue(0.65, 0.55, 0.25));
	createCamera();
	createViewports();
	mInputHandler = new InputHandler(mRenderWindow);
	mWorld = new World(mSceneManager);
	mAIManager = new AIManager(mWorld);
}

PongManager::~PongManager() {
	delete mInputHandler;
	delete mWorld;
	delete mAIManager;
}
void PongManager::createGameOverOverlay() {
	Ogre::OverlayManager& om = Ogre::OverlayManager::getSingleton();
	mGameOverOverlay = om.getByName("GameOver");
}