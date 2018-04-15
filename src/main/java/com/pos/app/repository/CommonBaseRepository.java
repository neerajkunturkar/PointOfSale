package com.pos.app.repository;

/**
 * Created by admin on 4/12/2018.
 */
import java.io.Serializable;
import java.util.Optional;

import javax.transaction.Transactional;

import com.pos.app.model.core.AuditCommonBaseModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface CommonBaseRepository <T extends AuditCommonBaseModel, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

    Optional<T> findById(ID id);
    <S extends T> S save (S entity);

    //	@Query("update #{#entityName} e set e.isDeleted=false where e.id = ?1")
    @Transactional
    @Modifying
    void delete(Long id);

    @Override
    @Transactional
    default void delete(T entity) {
        delete(entity.getId());
    }

    @Override
    @Transactional
    default void delete(Iterable<? extends T> entities) {
        entities.forEach(entitiy -> delete(entitiy.getId()));
    }


    @Override
//	@Query("update #{#entityName} e set e.isDeleted=false")
    @Transactional
    @Modifying
    void deleteAll();

}
