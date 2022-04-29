package itmo.lab3.ability;

import itmo.lab3.world.World;
import itmo.lab3.world.WorldObject;

/**
 * 
 * Реализация - Способность воспроизводить(повторять) изображение с одного объекта мира на другом
 * 
 */
public class MappingCapability extends Capability {
    
    private World world;

    public MappingCapability(World world) {
        super(CapabilityEnum.MAPPING);
        this.world = world;
    }

    // Нарисовать план
    public void drawPlan() {
        System.out.println("Построить приблизительный план местности");
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Намечать путь
    public void drawPath(WorldObject[] points) {
        if (points.length <= 1) {
            System.out.println("Недостаточно ключевых точек для построения пути");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Наметить путь ");
            for (int i=0; i<points.length; i++) {
                if (i==0) {
                    sb.append("от ");
                } else if (i==points.length-1) {
                    sb.append("к ");
                } else {
                    sb.append("через ");
                }
                sb.append(points[i].toString());
                sb.append(" ");
            }
            System.out.println(sb.toString());
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String toString() {
        return String.format("Обладает какими-никакими картографическими способностями");
    }
    
}
