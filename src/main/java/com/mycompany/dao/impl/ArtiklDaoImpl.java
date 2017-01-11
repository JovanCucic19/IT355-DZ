package com.mycompany.dao.impl;

import com.mycompany.dao.ArtiklDao;
import com.mycompany.messaging.MessageSender;
import com.mycompany.model.Artikl;
import com.mycompany.model.InventoryResponse;
import com.mycompany.model.OrderStatus;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("artiklDao")
@Service
public class ArtiklDaoImpl implements ArtiklDao {
    
    @Autowired
    MessageSender messageSender;

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addArtikl() {
        System.out.println("Dodajem artikl..");
    }

    @Override
    public String addArtiklRet() {
        System.out.println("Dodajem artikl i vracam vrednost..");
        return "dodato";
    }

    @Override
    public void addArtiklThrowException() throws Exception {
        System.out.println("Dodajem artikl, ali bacicu gresku");
        throw new Exception("Generic Error");
    }

    @Override
    @Transactional
    public int getCount() {
//        String sql = "SELECT COUNT(*) FROM knjige";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class);
//        System.out.println("ArtiklDaoImpl count rez: " + count);
//        return count;
        Number result = (Number) getSession().createSQLQuery("SELECT COUNT(*) FROM knjige").uniqueResult();
        return Integer.parseInt(result.toString());

    }

    @Override
    @Transactional
    public List<Artikl> getAllArtikls() {
        List<Artikl> results = (List<Artikl>) getSession().createCriteria(Artikl.class).list();
        return results;
    }

    @Override
    @Transactional
    public Artikl addArtiklic(Artikl artikl) {
//        String sql = "INSERT INTO knjige"
//                + "(knjiga_id, knjiga_naziv, knjiga_cena, knjiga_opis, knjiga_slika) VALUES (?, ?, ?, ?, ?)";
//        jdbcTemplate.update(sql, new Object[]{artikl.getKnjiga_id(), artikl.getKnjiga_naziv(), artikl.getKnjiga_cena(), artikl.getKnjiga_opis(), artikl.getKnjiga_slika()});
//        return true;
        messageSender.sendMessage(artikl);
        return (Artikl) getSession().merge(artikl);

    }

    @Override
    @Transactional
    public boolean updateArtikl(Artikl artikl) {
//        String sql = "UPDATE knjige SET knjiga_naziv='" + artikl.getKnjiga_naziv()
//                + "', knjiga_cena='" + artikl.getKnjiga_cena()
//                + "', knjiga_opis='" + artikl.getKnjiga_opis() + "' WHERE knjiga_id='" + artikl.getKnjiga_id() + "'";
//        jdbcTemplate.update(sql);
//        return true;

        getSession().saveOrUpdate(artikl);
        return true;
    }

    @Override
    @Transactional
    public Artikl getArtiklById(int knjiga_id) {
//        String sql = "SELECT * FROM knjige WHERE knjiga_id=?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{knjiga_id}, new BeanPropertyRowMapper<Artikl>(Artikl.class));
        Artikl artikl = (Artikl) getSession().createCriteria(Artikl.class)
                .add(Restrictions.eq("knjiga_id", knjiga_id)).uniqueResult();
        return artikl;
    }

    @Override
    @Transactional
    public void delete(Artikl artikl) {
//        String sql = "DELETE FROM knjige WHERE knjiga_id=" + knjiga_id + "";
//        return jdbcTemplate.update(sql);
        getSession().delete(artikl);

    }

    @Override
    public void updateArtiklResponse(InventoryResponse response) {
//        Artikl artikl = artiklDao.getArtiklById(response.getArtiklId());
//        if (response.getReturnCode() == 200) {
//            artikl.setStatus(OrderStatus.CONFIRMED);
//        } else if (response.getReturnCode() == 300) {
//            artikl.setStatus(OrderStatus.FAILED);
//        } else {
//            artikl.setStatus(OrderStatus.PENDING);
//        }
    }

  
}
