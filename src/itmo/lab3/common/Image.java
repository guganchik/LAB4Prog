package itmo.lab3.common;

import java.util.Objects;

/**
 * 
 * Класс представляет собой орнамент, зарисовку, узор и т.д., который может быть нанесен на объекте. 
 * Сохранение тела картинки на данный момент не реализовано
 * 
 */

public class Image {

    private String name;
    
    public Image(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        
        Image other = (Image) obj;
        return Objects.equals(this.name, other.name);
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}
