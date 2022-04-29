package itmo.lab3.world;

/**
 * 
 * Перечисление - Форма объекта реального мира
 * 
 */
public enum ShapeEnum {
    SQUARE("квадрат"),
    CIRCLE("круг"),
    PENTAGON("пятиугольник");

    private final String shape;
    
    ShapeEnum(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
    
    @Override
    public String toString() {
        return shape;
    }
    
    
}
