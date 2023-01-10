package ua.stupin.shop.repository.hibernate;

import ua.stupin.shop.entity.Goods;
import ua.stupin.shop.repository.GoodsRepository;

public class GoodsRepositoryImpl extends AbstractHibernateRepository<Goods> implements GoodsRepository {
    protected void init() {
        aClass = Goods.class;
    }
}