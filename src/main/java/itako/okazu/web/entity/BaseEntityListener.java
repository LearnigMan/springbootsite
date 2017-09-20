package itako.okazu.web.entity;

import java.time.LocalDateTime;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class BaseEntityListener<T extends BaseEntity> implements EntityListener<T> {

    @Override
    public void preUpdate(T entity, PreUpdateContext<T> context) {
        entity.updatedAt = LocalDateTime.now();
        entity.updatedBy = "11";
    }

    @Override
    public void preInsert(T entity, PreInsertContext<T> context) {
        entity.createdAt= LocalDateTime.now();
        entity.createdBy = "11";
    }



}