//package oktenweb.trysecurity1.services.impl;
//
//import oktenweb.trysecurity1.dao.WorkerDAO;
//import oktenweb.trysecurity1.models.Worker;
//import oktenweb.trysecurity1.services.WorkerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//@Qualifier("workerServiceImpl")
//public class WorkerServiceImpl implements WorkerService {
//
//    @Autowired
//    WorkerDAO workerDAO;
//
//    @Override
//    public void save(Worker worker) {
//        if(worker!=null) workerDAO.save(worker);
//    }
//
//    @Override
//    public List<Worker> findAll() {
//        return workerDAO.findAll();
//    }
//
//    @Override
//    public Worker findOneById(Integer id) {
//        return workerDAO.findOne(id);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String workerName) throws UsernameNotFoundException {
//        return workerDAO.findByUsername(workerName);
//    }
//}
