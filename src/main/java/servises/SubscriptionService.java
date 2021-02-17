package servises;

import dao.Dao;
import dao.SkillBoxDao;
import models.Subscription;

import java.io.Serializable;
import java.util.List;

public class SubscriptionService {

    private final Dao<Subscription> subscriptionDao = new SkillBoxDao<>(Subscription.class);

    public SubscriptionService() {
    }

    public Subscription findSubscription(Serializable id) throws IllegalArgumentException {
        return subscriptionDao.findById(id).get();
    }

    public void saveSubscription(Subscription subscription) {
        subscriptionDao.save(subscription);
    }

    public void deleteSubscription(Subscription subscription) {
        subscriptionDao.delete(subscription);
    }

    public void updateSubscription(Subscription subscription) {
        subscriptionDao.update(subscription);
    }

    public List<Subscription> findAllSubscriptions() {
        return subscriptionDao.findAll();
    }

}
