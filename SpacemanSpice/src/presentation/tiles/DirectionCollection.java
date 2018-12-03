/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.tiles;

/**
 * Direction collection class,
 * that with three parameters sets the following:
 * - which location you move to
 * - which direction from
 * - which direction to
 * 
 */
public class DirectionCollection {
    
    private String toLocationName;
    private Direction directionTo;
    
    public DirectionCollection(String name, Direction to){
        this.toLocationName = name;
        this.directionTo = to;
    }

    /**
     * @return the toLocationName
     */
    public String getToLocationName() {
        return toLocationName;
    }

    /**
     * @return the directionTo
     */
    public Direction getDirectionTo() {
        return directionTo;
    }
    
}
