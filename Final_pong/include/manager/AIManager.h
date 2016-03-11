#ifndef __AIManager_h_
#define __AIManager_h_

enum slideredbrick;
class World;

class AIManager 
{

public:
	AIManager(World *world);
	~AIManager();
	slideredbrick onemorestep() const { return monemorestep; }
    void think(float time);

private:
	void nobrainer();
	void wicked();

	World *mWorld;
	slideredbrick monemorestep;

};

#endif