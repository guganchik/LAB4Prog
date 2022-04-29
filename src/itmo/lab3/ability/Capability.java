package itmo.lab3.ability;

import java.util.Objects;

/**
 * 
 * Абстракция - Способность делать что-либо
 * 
 */
public abstract class Capability {

    protected CapabilityEnum capability;
    
    public Capability(CapabilityEnum capability) {
        this.capability = capability;
    }

    public CapabilityEnum getCapability() {
        return capability;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        
        Capability other = (Capability) obj;
        return Objects.equals(this.capability, other.capability);
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.capability);
        return hash;
    }
    
    
}
