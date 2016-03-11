#include "include\core\OgrePong.h"
#include "include\core\World.h"
#include "include\handler\InputHandler.h"
#include "include\manager\AIManager.h"
#include "include\manager\PongManager.h"

#include "Ogre.h"
#include "OgreConfigFile.h"
#include "OgreFontManager.h"
#include "OgreOverlaySystem.h"

OgrePong::OgrePong() {
    mPongManager = 0;
    mRoot = 0;
	// Provide a nice cross platform solution for locating the configuration files
    // On windows files are searched for in the current working directory, on OS X however
    // you must provide the full path, the helper function macBundlePath does this for us.
	//  (Note:  This is not fully tested under IOS)
#if OGRE_PLATFORM == OGRE_PLATFORM_APPLE
    mResourcePath = macBundlePath() + "/Contents/Resources/";
#else
    mResourcePath = "";
#endif
}

/// Standard destructor
OgrePong::~OgrePong() {
    delete mPongManager;
    delete mRoot;
}

void OgrePong::setupPongManager(void) {
	mPongManager = new PongManager(mSceneManager, mWindow);
	mPongManager->setUp();
	mRoot->addFrameListener(mPongManager);
}

void OgrePong::setupSceneManager() {
	// Create the SceneManager, in this case a generic one
    mSceneManager = mRoot->createSceneManager(Ogre::ST_GENERIC, "PongSMInstance");
}

void OgrePong::setupOverlaySystem() {
	Ogre::TextureManager::getSingleton().setDefaultNumMipmaps(5);
	mOverlaySystem = new Ogre::OverlaySystem();
	mSceneManager->addRenderQueueListener(mOverlaySystem);
}

void OgrePong::setupResourceGroup() {
	Ogre::ResourceGroupManager::getSingleton().initialiseAllResourceGroups();  
	Ogre::ResourceManager::ResourceMapIterator iter = Ogre::FontManager::getSingleton().getResourceIterator();
	while (iter.hasMoreElements()) { 
		iter.getNext()->load(); 
	}
}

bool 
	OgrePong::setup(void) {
	setupRoot();
    setupResources();
    bool carryOn = configure();
    if (!carryOn) 
		return false;
    setupSceneManager();
	setupOverlaySystem();
	setupResourceGroup();
	setupPongManager();
    return true;
}
/** Configures the application - returns false if the user chooses to abandon configuration. */
bool OgrePong::configure(void) {
	// Show the configuration dialog and initialise the system
    // You can skip this and use root.restoreConfig() to load configuration
    // settings if you were sure there are valid ones saved in ogre.cfg
    if(mRoot->showConfigDialog()) {
		// If returned true, user clicked OK so initialise
        // Here we choose to let the system create a default rendering window by passing 'true'
        mWindow = mRoot->initialise(true);
        return true;
    } else {
        return false;
    }
}

void OgrePong::setupRoot() {
	Ogre::String pluginsPath;
	Ogre::String configPath;
    // only use plugins.cfg if not static
#ifndef OGRE_STATIC_LIB

#if OGRE_DEBUG_MODE == 1 && (OGRE_PLATFORM != OGRE_PLATFORM_APPLE && OGRE_PLATFORM != OGRE_PLATFORM_APPLE_IOS)
	// add _d suffix to config files
	pluginsPath = mResourcePath + "plugins_d.cfg";
	configPath = mResourcePath + "ogre_d.cfg";
#else
	pluginsPath = mResourcePath + "plugins.cfg";
	configPath = mResourcePath + "ogre.cfg";

#endif

#endif
	
    mRoot = new Ogre::Root(pluginsPath, configPath, mResourcePath + "Ogre.log");
}

void OgrePong::setupResources(void) {
	// Load resource paths from config file
    Ogre::ConfigFile cf;
	#if OGRE_DEBUG_MODE == 1 && (OGRE_PLATFORM != OGRE_PLATFORM_APPLE && OGRE_PLATFORM != OGRE_PLATFORM_APPLE_IOS)
	// add _d suffix to config files
    cf.load(mResourcePath + "resources_d.cfg");
#else
	cf.load(mResourcePath + "resources.cfg");
#endif
	// Go through all sections & settings in the file
    Ogre::ConfigFile::SectionIterator seci = cf.getSectionIterator();
    Ogre::String secName, typeName, archName;
    while (seci.hasMoreElements()) {
        secName = seci.peekNextKey();
        Ogre::ConfigFile::SettingsMultiMap *settings = seci.getNext();
        Ogre::ConfigFile::SettingsMultiMap::iterator i;
        for (i = settings->begin(); i != settings->end(); ++i) {
            typeName = i->first;
            archName = i->second;
#if OGRE_PLATFORM == OGRE_PLATFORM_APPLE
			 // OS X does not set the working directory relative to the app,
            // In order to make things portable on OS X we need to provide
            // the loading with it's own bundle path location
            Ogre::ResourceGroupManager::getSingleton().addResourceLocation(
                String(macBundlePath() + "/" + archName), typeName, secName);
#else
            Ogre::ResourceGroupManager::getSingleton().addResourceLocation(
                archName, typeName, secName);
#endif
        }
    }
}

void OgrePong::go(void) {
    if (!setup())
        return;
    mRoot->startRendering();

}




