package hibernate.dao;

import hibernate.entity.ItemEntity;
import hibernate.interceptors.Transactional;
import hibernate.utils.MySessionFactory;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ItemDao {
    @Inject
    private MySessionFactory sessionFactory;

    @Transactional
    public Long addItem(String name, String description, float price) {
        ItemEntity item = new ItemEntity(name, description, price);
        Long id = (Long) sessionFactory.getCurrentSession().save(item);
        return id;
    }

    @Transactional
    public void updateItem(Long id, String name, String description, float price) {
        ItemEntity item = sessionFactory.getCurrentSession().get(ItemEntity.class, id);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
    }

    @Transactional
    public void deleteItem(Long id) {
        ItemEntity item = sessionFactory.getCurrentSession().get(ItemEntity.class, id);
        item.setIsdeleted(true);
    }

    public ItemEntity get(Long id) {
        ItemEntity item = sessionFactory.getCurrentSession().get(ItemEntity.class, id);
        return item;
    }

    public List<ItemEntity> getAll() {
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<ItemEntity> criteria = builder.createQuery(ItemEntity.class);
        criteria.from(ItemEntity.class);

        List<ItemEntity> items = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
        return items;
    }
}
