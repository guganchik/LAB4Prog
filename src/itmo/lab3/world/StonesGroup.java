package itmo.lab3.world;

import itmo.lab3.common.Image;
import java.util.Objects;

/**
 * 
 * Реализация - Группа камней, по контексту задания рассматривается в совокупности
 * 
 */
public class StonesGroup extends WorldObject implements ImagedWorldObject {
    
    private String color;           // цвет камней
    private Image ornament;         // точечный орнамент на группе камней

    public StonesGroup(String name, int x, int y, String color, Image ornament) {
        super(name, x, y);
        this.group = true;
        this.color = color;
        this.ornament = ornament;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Image getImage() {
        return ornament;
    }

    @Override
    public void setImage(Image ornament) {
        this.ornament = ornament;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) 
                && Objects.equals(this.color, ((StonesGroup)obj).color)
                && Objects.equals(this.ornament, ((StonesGroup)obj).ornament);
    }  

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + Objects.hashCode(this.color);
        hash = 31 * hash + Objects.hashCode(this.ornament);
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("%s {Координаты:%s,%s; Цвет:%s; Рисунок:%s}", name, x, y, color, ornament.toString());
    }
    
}
