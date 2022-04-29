package itmo.lab3.ability;

import itmo.lab3.world.ImagedWorldObject;
import java.util.Objects;

/**
 * 
 * Реализация - Способность воспроизводить(повторять) изображение с одного объекта мира на другом
 * 
 */
public class ReproduceCapability extends Capability {
    
    private ImagedWorldObject source;
    private ImagedWorldObject destination;

    public ReproduceCapability(ImagedWorldObject source, ImagedWorldObject destination) {
        super(CapabilityEnum.REPRODUCE);
        this.source = source;
        this.destination = destination;
    }

    public ImagedWorldObject getSource() {
        return source;
    }

    public void setSource(ImagedWorldObject source) {
        this.source = source;
    }

    public ImagedWorldObject getDestination() {
        return destination;
    }

    public void setDestination(ImagedWorldObject destination) {
        this.destination = destination;
    }
    
    public void reproduce() {
        destination.setImage(source.getImage());
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) 
                && Objects.equals(this.source, ((ReproduceCapability)obj).source)
                && Objects.equals(this.destination, ((ReproduceCapability)obj).destination);
    }    
    
    
    @Override
    public String toString() {
        return String.format("Способен воспроизводить изображение с %s на %s", this.source, this.destination);
    }
    
}
