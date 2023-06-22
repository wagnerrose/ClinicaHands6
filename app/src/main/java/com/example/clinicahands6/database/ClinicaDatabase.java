package com.example.clinicahands6.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.clinicahands6.Dao.MedicoDao;
import com.example.clinicahands6.Dao.PacienteDao;
import com.example.clinicahands6.entity.AgendaEntity;
import com.example.clinicahands6.entity.ConsultaEntity;
import com.example.clinicahands6.entity.ConvenioEntity;
import com.example.clinicahands6.entity.EspecialidadeEntity;
import com.example.clinicahands6.entity.MedicoConvenioEntity;
import com.example.clinicahands6.entity.MedicoEntity;
import com.example.clinicahands6.entity.MedicoEspecialidadeEntity;
import com.example.clinicahands6.entity.PacienteEntity;

@Database(entities = {AgendaEntity.class,
        ConsultaEntity.class,
        ConvenioEntity.class,
        EspecialidadeEntity.class,
        MedicoConvenioEntity.class,
        MedicoEntity.class,
        MedicoEspecialidadeEntity.class,
        PacienteEntity.class}, version = 1, exportSchema = false)
public abstract class ClinicaDatabase extends RoomDatabase {

    // necessario para o evitar duplo instaciamento do DB
    private static ClinicaDatabase INSTANCE;

    public abstract MedicoDao MedicoDao();
    public abstract PacienteDao PacienteDao();

    public static ClinicaDatabase getClinicaDatabase(Context context) {
        if (INSTANCE == null) {
//            instacia o DB caso ele ainda não tenha sido instanciado
//            segue o padrão Singleton
            INSTANCE = Room.databaseBuilder(context, ClinicaDatabase.class, "clinica.db")
                    .allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTANCE;
    }

    public static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };
}
