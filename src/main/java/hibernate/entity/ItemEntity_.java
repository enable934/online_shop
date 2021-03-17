package hibernate.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(ItemEntity.class)
public class ItemEntity_ {
    public static volatile SingularAttribute<ItemEntity, Long> id;
    public static volatile SingularAttribute<ItemEntity, String> name;
    public static volatile SingularAttribute<ItemEntity, String> description;
    public static volatile SingularAttribute<ItemEntity, Float> price;
    public static volatile SingularAttribute<ItemEntity, Timestamp> createdAt;
    public static volatile SingularAttribute<ItemEntity, Boolean> isdeleted;
}
