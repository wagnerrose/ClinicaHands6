package com.example.clinicahands6.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.clinicahands6.entity.PacienteEntity;

import java.util.List;

@Dao
public interface PacienteDao {
    @Insert
    long insert(PacienteEntity paciente);

    @Update
    int update(PacienteEntity paciente);

    @Delete
    int delete(PacienteEntity paciente);

    @Query("SELECT * FROM pacientes ORDER BY nome ASC")
    List<PacienteEntity> getAll();

    @Query("SELECT * FROM pacientes WHERE id = :id")
    PacienteEntity getById(int id);

}
