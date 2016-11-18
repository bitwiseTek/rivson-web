package com.bitwise.manageme.rssson.domain.accommodation;
/**
 *  
 * @author Sika Kay
 * @date 10/06/16
 *
 */
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Room.class)
public abstract class Room_ {

	public static volatile SingularAttribute<Room, Long> id;
	
	public static volatile SetAttribute<Room, RoomType> type;
	
	public static volatile SingularAttribute<Room, String> name;
}
