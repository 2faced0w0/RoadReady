package com.app.util;

import com.app.model.Reservation;
import com.mysql.cj.protocol.Resultset;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapperUtil implements RowMapper<Reservation> {

    @Nullable
    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
