package service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MyBookEntityRepository;
import service.MyBookEntityService;

@Service
public class MyBookEntityServiceImpl implements MyBookEntityService {
    @Autowired
    private MyBookEntityRepository myBookEntityRepository;
}
