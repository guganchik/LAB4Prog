package itmo.lab3.world;

import itmo.lab3.common.Image;
import java.util.Objects;

/**
 * 
 * Реализация - Группа могил, по контексту задания рассматривается в совокупности
 * 
 */
public class TombsGroup extends WorldObject implements ImagedWorldObject {
    
    private Image pattern;          // узор на могилах
    private ShapeEnum tombShape;    // форма могил
    
    public TombsGroup(String name, int x, int y, ShapeEnum tombShape, Image pattern) {
        super(name, x, y);
        this.group = true;
        this.tombShape = tombShape;
        this.pattern = pattern;
    }

    public TombsGroup(String name, int x, int y, ShapeEnum tombShape) {
        super(name, x, y);
        this.group = true;
        this.tombShape = tombShape;

    }

    public ShapeEnum getTombShape() {
        return tombShape;
    }

    public void setTombShape(ShapeEnum tombShape) {
        this.tombShape = tombShape;
    }
    
    @Override
    public Image getImage() {
        return pattern;
    }

    @Override
    public void setImage(Image pattern) {
        this.pattern = pattern;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) 
                && Objects.equals(this.pattern, ((TombsGroup)obj).pattern)
                && Objects.equals(this.tombShape, ((TombsGroup)obj).tombShape);
    }  

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(this.pattern);
        hash = 31 * hash + Objects.hashCode(this.tombShape);
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("%s {Координаты:%s,%s; Форма могил:%s, Рисунок:%s}", name, x, y, tombShape.toString(), pattern.toString());
    }
    
}
