package itmo.lab3;

import itmo.lab3.world.World;
import itmo.lab3.person.Person;
import itmo.lab3.ability.Capability;
import itmo.lab3.ability.CapabilityEnum;
import itmo.lab3.ability.MappingCapability;
import itmo.lab3.ability.ReproduceCapability;
import itmo.lab3.common.Image;
import itmo.lab3.person.CharacterExistsException;
import itmo.lab3.person.MainCharacters;
import itmo.lab3.world.Building;
import itmo.lab3.world.NotesGroup;
import itmo.lab3.world.ShapeEnum;
import itmo.lab3.world.SketchEnum;
import itmo.lab3.world.StonesGroup;
import itmo.lab3.world.TombsGroup;
import itmo.lab3.world.Tunnel;
import itmo.lab3.world.Vault;
import itmo.lab3.world.WorldObject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    
            
    public static void main(String[] args) {
        
        /**************************************************************************************/
        /*********************************** ОКРУЖАЮЩИЙ МИР ***********************************/
        /**************************************************************************************/

        final int minObjectNameLength = 2;
        final int maxObjectNameLength = 15;
        
        class ObjectName {
            String name = null;
            ObjectName(String aname){
                if (aname != null) {
                    aname = aname.trim();
                }
                if ((aname.length()>=minObjectNameLength) && (aname.length()<=maxObjectNameLength)) {
                    name = aname;
                } else {
                    name = null;
                }
            }
                
            public String getName() {
                if (name == null) {
                    throw new NameValidateException();
                }
                return name;
            }
        }
            
                
        // инициализируем мир
        World world = new World();
        System.out.println(world.toString());
        
        
        // склеп
        Vault vault = new Vault(new ObjectName("Склеп").getName(), 21, 15);
        world.addWorldObject(vault);
        System.out.println(vault.toString());
        
        
        // башня-цилиндр
        Building tower = new Building(new ObjectName("Башня").getName(), 15, 10, ShapeEnum.CIRCLE);
        world.addWorldObject(tower);
        System.out.println(tower.toString());
        
        // пятиугольное здание
        Building building = new Building(new ObjectName("Здание").getName(), 21, 15, ShapeEnum.PENTAGON);
        world.addWorldObject(building);
        System.out.println(building.toString());
        
        // вход в туннель
        Tunnel tunnel = new Tunnel(new ObjectName("Вход в туннель").getName(), 35, 20);
        world.addWorldObject(tunnel);
        System.out.println(tunnel.toString());
        
        // группа камней
        StonesGroup stones = new StonesGroup(new ObjectName("Камни").getName(), 3, 18, "зеленоватый", new Image("точечный орнамент"));
        world.addWorldObject(stones);
        System.out.println(stones.toString());
        
        // могилы
        TombsGroup tombs = new TombsGroup(new ObjectName("Могилы").getName(), 6, 8, ShapeEnum.PENTAGON, new Image("узоры"));
        world.addWorldObject(tombs);
        System.out.println(tombs.toString());
        
        // листки с зарисовками
        NotesGroup notes = new NotesGroup(new ObjectName("Листки").getName(), 21, 15, new Image("Зарисовки"));
        notes.addSketchesManner(SketchEnum.HASTY);
        notes.addSketchesManner(SketchEnum.INIMITABLE);
        notes.addSketchesManner(SketchEnum.SLOPPY);
        world.addWorldObject(notes);
        System.out.println(notes.toString());
        System.out.println("Манера рисунка:" + notes.getSketchesManner());
        System.out.println();
        
        
        /**************************************************************************************/
        /******************************** КОНЕЦ ОКРУЖАЮЩИЙ МИР ********************************/
        /**************************************************************************************/

        // Способности Гедни
        Person gedny = new Person("Гедни");
        gedny.setCanDrawAsAncient(false);
        System.out.println(gedny.toString());
        
        Capability capability;
        gedny.addCapability(capability = new ReproduceCapability(stones, tombs));
        System.out.println(capability.toString());
        
        gedny.addCapability(capability = new ReproduceCapability(stones, notes));
        System.out.println(capability.toString());
        
        gedny.addCapability(capability = new MappingCapability(world));
        System.out.println(capability.toString());
        ((MappingCapability)capability).drawPlan();

        WorldObject[] path = new WorldObject[3];
        path[0] = tower;
        path[1] = building;
        path[2] = tunnel;
        ((MappingCapability)capability).drawPath(path);
        
        
        System.out.println();
        MainCharacters characters = new MainCharacters();

        try {
            characters.initCharacters("Автор", "Денфорт");
            //characters.initCharacters("Автор", "Автор");
            //characters.initCharacters("Автор", "");
        } catch (CharacterExistsException e) {
            e.printStackTrace();
        }

        System.out.println(characters.toString());
        characters.inspect(vault);
        characters.didntRunAway();
        characters.think();
        characters.embrace();
    }
}
