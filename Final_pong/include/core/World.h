#ifndef __World_h_
#define __World_h_
#include "Ogre.h"

namespace Ogre {
    class SceneNode;
    class SceneManager;
	class Overlay;
	class Vector3;
}

class PongManager;
class InputHandler;
class Border_;
class pong;
class RedBrick;
enum slideredbrick;
class WorldManager;

class World
{
public:
	
    World(Ogre::SceneManager *sceneManager);
	~World();
    void think(const Ogre::Real& time);

	pong* getpong() const { return mpong; }
	pong* getpong1() const { return mpong1; }
	pong* getpong2() const { return mpong2; }
	pong* getpong3() const { return mpong3; }
	pong* getpong4() const { return mpong4; }
	pong* getpong5() const { return mpong5; }
	pong* getpong6() const { return mpong6; }
	void getEventFrom(PongManager *pongManager);
	RedBrick* getAIRedBrick() const { return mAIRedBrick; }
	RedBrick* getUserRedBrick() const { return mUserRedBrick; }
	Border_* getBorder_2() const { return mBorder_2; }
	Border_* getBorder_3() const { return mBorder_3; }
	Border_* getBorder_1() const { return mBorder_1; }
	Border_* getBorder_4() const { return mBorder_4; }
	RedBrick* getAIPlayer() const { return mAIPlayer; }
	int getUserScore() const { return mUserScore; }
	void setUserScore(int score) { mUserScore = score; }
	RedBrick* getUser() const { return mUser; }
	void reset();

	int getAIPlayerScore() const { return mAIScore; }
	void setAIPlayerScore(int score) { mAIScore = score; }
	void updateLevel();
	bool flag();
	int getLevel() { return mLevel; }
	int mLevel;
private:
	void createModifiers();
	int mScore;
	Ogre::SceneManager *mSceneManager;
	Ogre::Overlay* mOverlay;
	Border_* mBorder_2;
	Border_* mBorder_3;
	Border_* mBorder_4;
	Border_* mBorder_1;
	pong* mpong;
	pong* mpong1;
	pong* mpong2;
	pong* mpong3;
	pong* mpong4;
	pong* mpong5;
	pong* mpong6;
	RedBrick* mUserRedBrick;
	RedBrick* mAIRedBrick;
	RedBrick* mAIPlayer;
	RedBrick* mUser;
	WorldManager *mWorldManager;
	int mUserScore;
	int mAIScore;
	void createOverlay();
	void initialStates();
	
	protected:
	Ogre::SceneManager* getSceneManager() { return mSceneManager; }
};

#endif

