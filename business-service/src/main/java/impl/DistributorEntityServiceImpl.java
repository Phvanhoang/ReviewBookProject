package impl;

import entity.DistributorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.DistributorEntityRepository;
import service.DistributorEntityService;

import java.util.Optional;

public class DistributorEntityServiceImpl implements DistributorEntityService {

    @Autowired
    private DistributorEntityRepository distributorEntityRepository;

    @Override
    public DistributorEntity findById(long id) {
        Optional<DistributorEntity> distributorEntity = distributorEntityRepository.findById(id);
        if (distributorEntity.isPresent()) {
            return distributorEntity.get();
        }
        return null;
    }

    @Override
    public void save(DistributorEntity distributorEntity) {
        distributorEntityRepository.save(distributorEntity);
    }
}
