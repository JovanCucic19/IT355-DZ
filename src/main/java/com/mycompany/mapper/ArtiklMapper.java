package com.mycompany.mapper;

import com.mycompany.model.Artikl;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ArtiklMapper implements RowMapper<Artikl> {

    @Override
    public Artikl mapRow(ResultSet rs, int i) throws SQLException {
        Artikl artikl = new Artikl();
        artikl.setKnjiga_id(rs.getInt("knjiga_id"));
        artikl.setKnjiga_naziv(rs.getString("knjiga_naziv"));
        artikl.setKnjiga_cena(rs.getInt("knjiga_cena"));
        artikl.setKnjiga_opis(rs.getString("knjiga_opis"));
        artikl.setKnjiga_slika(rs.getString("knjiga_slika"));
        return artikl;
    }
    
}
