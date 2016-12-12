package com.mycompany.dao.impl;

import com.mycompany.dao.ArtiklDao;
import com.mycompany.model.Artikl;
import com.mycompany.mapper.ArtiklMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

public class ArtiklDaoImpl implements ArtiklDao {

    private JdbcTemplate jdbcTemplate;
    @SuppressWarnings("unused")
    private DataSource dataSource;

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
    public int getCount() {
        String sql = "SELECT COUNT(*) FROM knjige";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("ArtiklDaoImpl count rez: " + count);
        return count;
    }

    @Override
    public List<Artikl> getAllArtikls() {
        String sql = "SELECT * FROM knjige";
        List<Artikl> knjige = jdbcTemplate.query(sql, new ArtiklMapper());
        return knjige;
    }

    @Override
    @Transactional
    public boolean addArtiklic(Artikl artikl) {
        String sql = "INSERT INTO knjige"
                + "(knjiga_id, knjiga_naziv, knjiga_cena, knjiga_opis, knjiga_slika) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{artikl.getKnjiga_id(), artikl.getKnjiga_naziv(), artikl.getKnjiga_cena(), artikl.getKnjiga_opis(), artikl.getKnjiga_slika()});
//        System.out.println("Podaci o studentu iz StudentDaoImpl: " + student.getId() + student.getIme() + student.getPrezime());
        return true;
    }

    @Override
    public boolean updateArtikl(Artikl artikl) {
        String sql = "UPDATE knjige SET knjiga_naziv='" + artikl.getKnjiga_naziv()
                + "', knjiga_cena='" + artikl.getKnjiga_cena()
                + "', knjiga_opis='" + artikl.getKnjiga_opis() + "' WHERE knjiga_id='" + artikl.getKnjiga_id() + "'";
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public Artikl getArtiklById(int knjiga_id) {
        String sql = "SELECT * FROM knjige WHERE knjiga_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{knjiga_id}, new BeanPropertyRowMapper<Artikl>(Artikl.class));
    }

    @Override
    public int delete(int knjiga_id) {
        String sql = "DELETE FROM knjige WHERE knjiga_id=" + knjiga_id + "";
        return jdbcTemplate.update(sql);
    }
}
