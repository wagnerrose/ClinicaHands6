package com.example.clinicahands6.repository;

import android.content.Context;

import com.example.clinicahands6.Dao.MedicoDao;
import com.example.clinicahands6.database.ClinicaDatabase;
import com.example.clinicahands6.entity.MedicoEntity;

import java.util.List;

public class MedicoRepository {

//    private String DB_NAME = "clinicaDb";
    private MedicoDao mMedicoDao;

//    private ClinicaDatabase clinicaDatabase;

    public MedicoRepository(Context context) {
//        ClinicaDatabase db = Room.databaseBuilder(context, ClinicaDatabase.class, DB_NAME).build();
        ClinicaDatabase db = ClinicaDatabase.getClinicaDatabase(context);
        this.mMedicoDao = db.MedicoDao();
    }

    public boolean insert(MedicoEntity medico) {
        return this.mMedicoDao.insert(medico) > 0;
    }

    public int update(MedicoEntity medico) {
        return this.mMedicoDao.update(medico);
    }

    public boolean delete(int id){
        MedicoEntity medicoEntity = this.getById(id);
        return this.mMedicoDao.delete(medicoEntity) > 0;
    }

    public MedicoEntity getById(int id) {
        return this.mMedicoDao.getById(id);
    }

    public List<MedicoEntity> getAll() {
        return this.mMedicoDao.getAll();
    }
}
