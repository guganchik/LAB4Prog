package itmo.lab3.world;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Реализация - Реальный мир
 * 
 */
public class World {
    
    private Set<WorldObject> worldObjects;

    public World() {
        worldObjects = new HashSet<WorldObject>();
    }
    
    public void addWorldObject(WorldObject worldObject) {
        worldObjects.add(worldObject);
    }

    public Set<WorldObject> getWorldObjects() {
        return worldObjects;
    }

    @Override
    public String toString() {
        return "Окружающий мир";
    }
    
    
    /**
    public Set<WorldObject> getStones() {
        
    }
     * @return 
    */
    
    
    
}
