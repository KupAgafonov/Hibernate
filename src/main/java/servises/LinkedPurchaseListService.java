package servises;

import dao.Dao;
import dao.SkillBoxDao;
import models.LinkedPurchase;

import java.io.Serializable;
import java.util.List;

public class LinkedPurchaseListService {

    private final Dao<LinkedPurchase> linkedPurchaseListDao = new SkillBoxDao<>(LinkedPurchase.class);

    public LinkedPurchase findLinkedPurchase(Serializable id) throws IllegalArgumentException {
        return linkedPurchaseListDao.findById(id).get();
    }

    public void saveLinkedPurchase(LinkedPurchase linkedPurchase) {
        linkedPurchaseListDao.save(linkedPurchase);
    }

    public void deleteLinkedPurchase(LinkedPurchase linkedPurchase) {
        linkedPurchaseListDao.delete(linkedPurchase);
    }

    public void updateLinkedPurchase(LinkedPurchase linkedPurchase) {
        linkedPurchaseListDao.update(linkedPurchase);
    }

    public List<LinkedPurchase> findAllLinkedPurchases() {
        return linkedPurchaseListDao.findAll();
    }

}
