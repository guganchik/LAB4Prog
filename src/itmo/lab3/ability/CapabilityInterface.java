package itmo.lab3.ability;

/**
 * 
 * Интерфейс - Способность делать что-либо
 * 
 */
public interface CapabilityInterface {
    
    // добавить способность
    public void addCapability(Capability capability);
    
    // есть ли такая способность
    public boolean hasCapability(Capability capability);
    
}
