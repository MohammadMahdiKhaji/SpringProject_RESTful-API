//package ir.webapp.springprojectapi.model.entity;
//
//import ir.webapp.springprojectapi.model.entity.enumeration.ActionType;
//import ir.webapp.springprojectapi.model.entity.enumeration.DbTable;
//import lombok.*;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//
//@Entity(name = "LogEntity")
//@Table(name = "LogTable")
//public class Log {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Enumerated(EnumType.STRING)
//    private DbTable dbTable;
//
//    private long userId;
//
//    @Enumerated(EnumType.STRING)
//    private ActionType action;
//
//    private String data;
//
//    private String clientIp;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Timestamp actionDateTime;
//
//    public Log(DbTable DbTable, long userId, ActionType action, String data, String clientIp) {
//        this.dbTable = DbTable;
//        this.userId = userId;
//        this.action = action;
//        this.data = data;
//        this.clientIp = clientIp;
//    }
//
//    @PrePersist
//    private void setActionDateTime(){
//        actionDateTime= Timestamp.valueOf(LocalDateTime.now());
//    }
//
//    @Override
//    public String toString() {
//        return "Log{" +
//                "id=" + id +
//                ", dbTable=" + dbTable +
//                ", userId=" + userId +
//                ", action=" + action +
//                ", data='" + data + '\'' +
//                ", clientIp='" + clientIp + '\'' +
//                ", actionDateTime=" + actionDateTime +
//                '}';
//    }
//}
