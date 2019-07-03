package impl;

import entity.ReportContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ReportContentEntityRepository;
import service.ReportContentEntityService;

public class ReportContentEntityServiceImpl implements ReportContentEntityService {
    @Autowired
    private ReportContentEntityRepository reportContentEntityRepository;

    @Override
    public Iterable<ReportContentEntity> findAll() {
        return reportContentEntityRepository.findAll();
    }
}