package itmo.lab3.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 
 * Реализация - Склеп
 * 
 */
public class Vault extends WorldObject {


    /**
     * 
     * Static nested classes
     * Статические внутренние (вложенные) классы
     * Cвязь между объектом внутреннего класса и объектом внешнего класса не нужна, внутренный класс может существовать отдельно
     * 
     */

    private static abstract class Thing {
    }
    
    // Консервная банка
    public static class Tincan extends Thing {
        
        @Override
        public String toString() {
            return "Консервная банка, открытая непередаваемо варварским способом";
        }
    }

    // Спичка
    public static class Match extends Thing {
        
        @Override
        public String toString() {
            return "Обгоревшая спичка";
        }
    }

    // Книга
    public static class Book extends Thing {
        
        @Override
        public String toString() {
            return "Иллюстрированная книга в грязных пятнах непонятного происхождения";
        }
    }

    // Пузырек
    public static class Bottle extends Thing {
        
        @Override
        public String toString() {
            return "Пустой пузырек из-под чернил с цветной этикеткой";
        }
    }

    // Ручка
    public static class Pen extends Thing {
        
        @Override
        public String toString() {
            return "Сломанная авторучка";
        }
    }
    
    // Палатка
    public static class Tent extends Thing {
        
        @Override
        public String toString() {
            return "Искромсанная палатка";
        }
    }

    // Куртка
    public static class Coat extends Thing {
        
        @Override
        public String toString() {
            return "Искромсанная меховая куртка";
        }
    }
    
    // Батарейка
    public static class Battery extends Thing {
        
        @Override
        public String toString() {
            return "Использованная электрическая батарейка с приложенной инструкцией";
        }
    }
    
    // Коробка
    public static class Box extends Thing {
        
        @Override
        public String toString() {
            return "Коробка от обогревателя";
        }
    }

    private List<Thing> things;
    
    public Vault(String name, int x, int y) {
        super(name, x, y);
        things = new LinkedList<>();
        
        for (int i=0; i<(int)(Math.random()*3)+1; i++) {
            things.add(new Tincan());
        }
        
        for (int i=0; i<(int)(Math.random()*10)+1; i++) {
            things.add(new Match());
        }
        
        for (int i=0; i<3; i++) {
            things.add(new Book());
        }
        
        things.add(new Bottle());
        
        things.add(new Pen());
        
        things.add(new Battery());
        
        things.add(new Box());
        
        things.add(new Tincan());

        things.add(new Tent());

        things.add(new Coat());

        /**
         * Для сортировки по алфавиту используется анонимный класс, реализующий интерфейс java.util.Comparator
         * Если такой тип сортировки производится только в одном месте приложения, то имеет смысл использовать анонимный класс, 
         * но если такая сортировка нужна во многих местах, то больший смысл имеет определить класс на более высоком уровне 
         * вложенности, или статический вложенный класс
         * да
         */
        Collections.sort(things, new Comparator<Thing>() {
            @Override
            public int compare(Thing o1, Thing o2) {
                String n1 = o1.toString();
                String n2 = o2.toString();
                return n1.compareTo(n2);
            }
        });

        /**
        // lambda 
        Collections.sort(things, (Thing o1, Thing o2) -> {
            String n1 = o1.getClass().getName();
            String n2 = o2.getClass().getName();
            return n1.compareTo(n2);
        });
        */
        
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) 
                && Objects.equals(this.things, ((Vault)obj).things);
    }    

    @Override
    public int hashCode() {
        return super.hashCode()*31 + Objects.hashCode(this.things);
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s {Координаты:%s,%s}", name, x, y));
        sb.append("\nВнутри разбросаны вещи:");
        
        

        /**
        for (Thing thing: things) {
            sb.append("\n-");
            sb.append(thing.toString());
        }
        */
        
        // functional operation
        // https://softwareengineering.stackexchange.com/questions/297162/why-should-i-use-functional-operations-instead-of-a-for-loop
        things.forEach((thing) -> {
            sb.append("\n-");
            sb.append(thing.toString());
        });
        
        
        return sb.toString();
    }
}
