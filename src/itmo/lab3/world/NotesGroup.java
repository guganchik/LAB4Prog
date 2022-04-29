package itmo.lab3.world;

import itmo.lab3.common.Image;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 
 * Реализация - Листки, по контексту задания рассматривается в совокупности
 * 
 */
public class NotesGroup extends WorldObject implements ImagedWorldObject {
    
    private Image sketches;                     // зарисовки на листках
    private Set<SketchEnum> sketchesManner;     // манера рисунка

    public NotesGroup(String name, int x, int y, Image sketches) {
        super(name, x, y);
        this.group = true;
        this.sketches = sketches;
        sketchesManner = new HashSet<SketchEnum>();
    }

    @Override
    public Image getImage() {
        return sketches;
    }

    @Override
    public void setImage(Image sketches) {
        this.sketches = sketches;
    }
    
    public void addSketchesManner(SketchEnum manner) {
        this.sketchesManner.add(manner);
    }

    public Set<SketchEnum> getSketchesManner() {
        return sketchesManner;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) 
                && Objects.equals(this.sketches, ((NotesGroup)obj).sketches)
                && Objects.equals(this.sketchesManner, ((NotesGroup)obj).sketchesManner);
    }  

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(this.sketches);
        hash = 31 * hash + Objects.hashCode(this.sketchesManner);
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("%s {Нанесено: %s}", name, sketches.toString());
    }
    
}
