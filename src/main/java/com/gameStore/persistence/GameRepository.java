package com.gameStore.persistence;

import com.gameStore.model.logic.GameDO;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class GameRepository {
    @PersistenceContext(unitName = "game-unit")
    private EntityManager em;

    public void create(GameDO game) {
        em.persist(game);
    }

    public List<GameDO> findAll() {
        return em.createQuery("SELECT p FROM GameDO p", GameDO.class)
                .getResultList();
    }

    public GameDO find(String id) {
        return em.find(GameDO.class, id);
    }
}
