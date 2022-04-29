package itmo.lab3.world;

/**
 * 
 * Перечисление - Характеристика (манера) рисунка на заметках
 * 
 */
public enum SketchEnum {
    HASTY("поспешный"),
    SLOPPY("небрежный"),
    INIMITABLE("неподражаемый"),
    REPRODUCIBLE("воспроизводимый");
    

    private final String feature;
    
    SketchEnum(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }
    
    @Override
    public String toString() {
        return feature;
    }
}
