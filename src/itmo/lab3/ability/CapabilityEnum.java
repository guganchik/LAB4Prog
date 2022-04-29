package itmo.lab3.ability;

/**
 * 
 * Перечисление - Способность делать что-либо
 * 
 */
public enum CapabilityEnum {
    REPRODUCE("Воспроизводить"),        // способность повторять изображение с одного объекта на другом, зарисовывать
    MAPPING("Работать с планом");       // способность составлять план и намечать путь в реальном мире
    
    private final String capability;
    
    CapabilityEnum(String capability) {
        this.capability = capability;
    }
    
    public String getCapability() {
        return capability;
    }
    
    @Override
    public String toString() {
        return capability;
    }
}
