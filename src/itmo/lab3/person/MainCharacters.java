package itmo.lab3.person;

import itmo.lab3.world.Vault;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainCharacters {
    
    private Map<String, Character> characters; 


    /**
     * 
     * Inner classes (Non static nested classes)
     * Внутренний класс
     * Внутренний класс имеет доступ ко всем переменным и методам своего внешнего класса и может непосредственно ссылаться на них
     * 
     */
    
    public class Character {
        
        private String name;
        
        public Character(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    public MainCharacters() {
    }
    
    public void initCharacters(String ... names) throws CharacterExistsException {
        characters = new HashMap<>();
        for (String name: names) {
            if (name==null || name.isEmpty()) {
                throw new CharacterCreateException();
            } else if (characters.containsKey(name)) {
                throw new CharacterExistsException();                
            } else {
                characters.put(name, new Character(name));
            }
        }
    }

    public void inspect(Vault vault) {
        System.out.println("Главные герои осмотрели");
        System.out.println(vault.toString());
    }

    public void didntRunAway() {
        System.out.println("Главные герои  не бросились тут же прочь, спасать свои жизни.");
    }
    
    public void think() {
        System.out.println("Опасения главных героев подтвердились.");
    }
    
    public void embrace() {
        System.out.println("Главных героев охватил тот безумный азарт, какой не покидает охотников, выслеживающих диких зверей где-нибудь в джунглях Африки и рискующих жизнью, только чтобы понаблюдать за ними и сфотографировать. Мы застыли на месте, страх парализовал нас, но где-то в глубине уже разгорался неуемный огонек любопытства, и он в конце концов одержал победу.");
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Главные герои: ");
        for (Character character: characters.values()) {
            sb.append("\n- ");
            sb.append(character.toString());
        }
        return sb.toString();
    }
}
