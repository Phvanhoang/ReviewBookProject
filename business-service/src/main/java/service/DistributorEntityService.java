package service;

import entity.DistributorEntity;

public interface DistributorEntityService {
    DistributorEntity findById(long id);

    void save(DistributorEntity distributorEntity);
}
