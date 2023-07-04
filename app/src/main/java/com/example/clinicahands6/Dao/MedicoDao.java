package com.example.clinicahands6.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clinicahands6.entity.MedicoEntity;

import java.util.List;

@Dao
public interface MedicoDao {
    @Insert
    long insert(MedicoEntity medico);

    @Update
    int update(MedicoEntity medico);

    @Delete
    int delete(MedicoEntity medico);

    @Query("SELECT * FROM medicos ORDER BY nome ASC")
    List<MedicoEntity> getAll();

    @Query("SELECT * FROM medicos WHERE id = :id")
    MedicoEntity getById(int id);

}
