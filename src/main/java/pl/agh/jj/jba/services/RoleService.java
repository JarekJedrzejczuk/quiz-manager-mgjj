package pl.agh.jj.jba.services;

import pl.agh.jj.jba.entities.Role;

public interface RoleService {
    
    public Role getRole(int id);
    
    public Role getRole(String name);
    
    
 
}