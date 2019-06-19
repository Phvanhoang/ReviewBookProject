package service;

import entity.ReportContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ReportContentEntityRepository;

public class ReportContentEntityServiceImpl implements ReportContentEntityService {
    @Autowired
    private ReportContentEntityRepository reportContentEntityRepository;

    @Override
    public Iterable<ReportContentEntity> findAll() {
        return reportContentEntityRepository.findAll();
    }
}