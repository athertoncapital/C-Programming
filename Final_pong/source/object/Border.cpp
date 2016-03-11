#include "include\object\border.h"
#include "include\object\PongObject.h"

#include "Ogre.h"
#include "OgreSceneManager.h"

Border_::Border_(Ogre::SceneManager* sceneManager, Ogre::Vector3 dimension):PongObject(sceneManager, dimension) {}

void Border_::load() {
	Ogre::SceneManager* sceneManager = getSceneManager();
	Ogre::Entity* entity = sceneManager->createEntity("Cube.mesh");
	setEntity(entity);
}
