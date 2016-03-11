#ifndef __OgrePong_h_
#define __OgrePong_h_
#include "OgrePrerequisites.h"
#include "OgreWindowEventUtilities.h"

namespace Ogre {
   class Root;
    class RenderWindow;
    class Camera;
    class SceneManager;
	class OverlaySystem;
}
class AIManager;
class InputHandler;
class World;
class PongCamera;
class PongManager;


class OgrePong :  public Ogre::WindowEventListener
{
public:
    OgrePong();
    ~OgrePong();
    bool setup(void);
    void go(void);

private:
     void setupRoot();
    void setupResources(void);
    bool configure(void);
	void setupPongManager(void);
	void setupSceneManager();
	void setupOverlaySystem();
	void setupResourceGroup();

	PongManager *mPongManager;
	Ogre::SceneManager* mSceneManager;
    Ogre::Root *mRoot;
    Ogre::RenderWindow* mWindow;
    Ogre::String mResourcePath;
	Ogre::OverlaySystem *mOverlaySystem;
};

#endif