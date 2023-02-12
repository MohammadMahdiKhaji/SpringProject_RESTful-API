package ir.webapp.springprojectapi.model.entity.base;

//import ir.webapp.springprojectapi.controller.app.LogController;
//import ir.webapp.springprojectapi.controller.app.UserAccessController;
//import ir.webapp.springprojectapi.model.entity.Log;
//import ir.webapp.springprojectapi.model.entity.enumeration.ActionType;
//import ir.webapp.springprojectapi.model.entity.enumeration.DbTable;
//import ir.webapp.springprojectapi.model.repository.LogDA;
//import ir.webapp.springprojectapi.model.service.LogService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @Transient
//    Logger logger = LoggerFactory.getLogger(BaseEntity.class);

//    @Version
//    private long versionId;

//    //log
//    @Transient
//    private final LogController logController;
//
//    @Autowired
//    public BaseEntity(LogController logController){
//        this.logController = logController;
//    }
//
//    @PostPersist
//    private void saveLog() {
//        logger.trace(new Log(
//                DbTable.valueOf(this.getClass().getSimpleName()),
//                1,
//                ActionType.Persist,
//                this.toString(),
//                "IP").toString());
//    }
//
//    @PostUpdate
//    private void editLog() {
//        logger.trace(new Log(
//                DbTable.valueOf(this.getClass().getSimpleName()),
//                1,
//                ActionType.Update,
//                this.toString(),
//                "IP").toString());
//    }
}
