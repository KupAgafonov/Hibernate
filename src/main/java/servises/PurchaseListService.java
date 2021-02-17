package servises;

import dao.Dao;
import dao.SkillBoxDao;
import models.Purchase;

import java.util.List;

public class PurchaseListService {

    private final Dao<Purchase> purchaseListDao = new SkillBoxDao<>(Purchase.class);

    public void savePurchase(Purchase purchase) {
        purchaseListDao.save(purchase);
    }

    public void deletePurchase(Purchase purchase) {
        purchaseListDao.delete(purchase);
    }

    public void updatePurchase(Purchase purchase) {
        purchaseListDao.update(purchase);
    }

    public List<Purchase> findAllPurchase() {
        return purchaseListDao.findAll();
    }

}

