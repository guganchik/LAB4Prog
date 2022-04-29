package itmo.lab3.world;

import itmo.lab3.common.Image;

/**
 * 
 * Интерфейс - На объекте может быть какое то интересующее нас изображение (орнамент, узор и т.д.)
 * 
 */
public interface ImagedWorldObject {
    
    // нанести изображение на объект 
    public void setImage(Image image);

    // взять изображение с объекта
    public Image getImage();
    
}
