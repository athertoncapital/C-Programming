#ifndef __InputHandler_h_
#define __InputHandler_h_

#include <ois/ois.h>
#include <Ogre.h>
#include "OgreRenderWindow.h"

class World;
class PongCamera;
class InputHandler;

class InputHandler 
{
public:
	InputHandler(Ogre::RenderWindow* win);
	~InputHandler();
	void think(float time);
	bool isKeyDown(OIS::KeyCode key) const;
	bool wasKeyDown(OIS::KeyCode key) const;

protected:
	OIS::InputManager* mInputManager;
	Ogre::RenderWindow *mRenderWindow;
	OIS::Keyboard *mPreviousKeyboard;
	OIS::Keyboard *mCurrentKeyboard;
	char mOldKeys[256];
};

#endif