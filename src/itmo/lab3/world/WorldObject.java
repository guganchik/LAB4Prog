package itmo.lab3.world;

import java.util.Objects;

/**
 * 
 * Абстракция - Объект реального мира
 * 
 */
public abstract class WorldObject {

    protected String name;          // название объекта реального мира
    protected int x;                // координата x объекта
    protected int y;                // координата y объекта
    protected boolean group = false;// группа объектов
    
    public WorldObject(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isGroup() {
        return group;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        
        
        WorldObject other = (WorldObject) obj;
        return Objects.equals(this.name, other.name)
                && this.x==other.x 
                && this.y==other.y 
                && this.group==other.group; 
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        hash = 31 * hash + (this.group ? 1 : 0);
        return hash;
    }
    
    
    @Override
    public String toString() {
        return String.format("%s (Координаты:%s,%s)", this.name, this.x, this.y);
    }

    
}
