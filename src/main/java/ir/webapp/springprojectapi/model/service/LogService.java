package ir.webapp.springprojectapi.model.service;

import ir.webapp.springprojectapi.model.entity.Log;
import ir.webapp.springprojectapi.model.repository.LogDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final LogDA logDA;

    @Autowired
    public LogService(LogDA logDA){
        this.logDA = logDA;
    }

    public Log save(Log log) {
        return logDA.save(log);
    }

}
