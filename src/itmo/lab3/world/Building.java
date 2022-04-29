package itmo.lab3.world;

import java.util.Objects;

/**
 * 
 * Реализация - Любое здание в реальном мире
 * 
 */
public class Building extends WorldObject {

    private ShapeEnum shape;
    
    public Building(String name, int x, int y, ShapeEnum shape) {
        super(name, x, y);
        this.shape = shape;
    }

    public ShapeEnum getShape() {
        return shape;
    }

    public void setShape(ShapeEnum shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) 
                && Objects.equals(this.shape, ((Building)obj).shape);
    }    

    @Override
    public int hashCode() {
        return super.hashCode()*31 + Objects.hashCode(this.shape);
    }
    
    @Override
    public String toString() {
        return String.format("%s {Координаты:%s,%s; Форма:%s}", name, x, y, shape.toString());
    }
}
