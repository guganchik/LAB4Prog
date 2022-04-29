package itmo.lab3.person;

import itmo.lab3.ability.Capability;
import itmo.lab3.ability.CapabilityEnum;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import itmo.lab3.ability.CapabilityInterface;
import java.util.Iterator;
import java.util.Objects;

public class Person implements CapabilityInterface {
    
    
    private String name;
    private Set<Capability> capabilities;
    private boolean canDrawAsAncient = false;

    public Person(String name) {
        this.name = name;
        this.capabilities = new HashSet<Capability>();
    }

    public String getName() {
        return name;
    }
    
    @Override
    public void addCapability(Capability capability) {
        this.capabilities.add(capability);
    }

    @Override
    public boolean hasCapability(Capability ability) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isCanDrawAsAncient() {
        return canDrawAsAncient;
    }

    public void setCanDrawAsAncient(boolean canDrawAsAncient) {
        this.canDrawAsAncient = canDrawAsAncient;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        
        Person other = (Person) obj;
        return Objects.equals(this.name, other.name)
                && Objects.equals(this.capabilities, other.capabilities)
                && this.canDrawAsAncient==other.canDrawAsAncient; 
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.capabilities);
        hash = 31 * hash + (this.canDrawAsAncient ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("Персонаж:%s; Может ли воспроизвести манеру рисунка древних:%s", this.name, this.canDrawAsAncient?"да":"нет");
    }
    
}
