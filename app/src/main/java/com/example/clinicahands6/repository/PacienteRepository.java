package com.example.clinicahands6.repository;

import android.content.Context;

import com.example.clinicahands6.Dao.PacienteDao;
import com.example.clinicahands6.database.ClinicaDatabase;
import com.example.clinicahands6.entity.PacienteEntity;

import java.util.List;

public class PacienteRepository {

    private String DB_NAME = "clinicaDb";
    private PacienteDao mPacienteDao;

//    private ClinicaDatabase clinicaDatabase;

    public PacienteRepository(Context context) {
        ClinicaDatabase db = ClinicaDatabase.getClinicaDatabase(context);
        this.mPacienteDao = db.PacienteDao();
    }

    public boolean insert(PacienteEntity paciente) {
        return this.mPacienteDao.insert(paciente) > 0;
    }

    public int update(PacienteEntity paciente) {
        return this.mPacienteDao.update(paciente);
    }

    public boolean delete(int id) {
        PacienteEntity pacienteEntity = this.getById(id);
        return this.mPacienteDao.delete(pacienteEntity) > 0;
    }

    public PacienteEntity getById(int id) {
        return this.mPacienteDao.getById(id);
    }

    public List<PacienteEntity> getAll() {
        return this.mPacienteDao.getAll();
    }
}
