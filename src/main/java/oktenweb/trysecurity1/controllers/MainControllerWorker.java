//package oktenweb.trysecurity1.controllers;
//
//import oktenweb.trysecurity1.dao.WorkerDAO;
//import oktenweb.trysecurity1.models.Worker;
//import oktenweb.trysecurity1.services.WorkerService;
//import oktenweb.trysecurity1.services.impl.WorkerServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class MainControllerWorker {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    WorkerDAO workerDAO;
//    @Autowired
//    WorkerService workerService;
//    @Autowired
//    WorkerServiceImpl workerServiceImpl;
//
//    @PostMapping("/saveWorker")
//    public String saveWorker(Worker worker){
//        worker.setPassword(passwordEncoder.encode(worker.getPassword())); // to encode the pass
//        workerDAO.save(worker);
//        return "login";
//    }
//}
