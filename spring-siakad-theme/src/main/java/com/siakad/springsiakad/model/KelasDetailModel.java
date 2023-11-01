package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.KelasDetailEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelasDetailModel {
    private String id;

    private KelasModel kelas;
    private String kelasId;

    private MahasiswaModel mahasiswa;
    private String mahasiswaId;

    private String status;

    public KelasDetailModel(KelasDetailEntity entity) {
        BeanUtils.copyProperties(entity, this);

        if (entity.getKelas() != null){
            this.kelasId = entity.getKelas().getId();
            this.kelas = new KelasModel(entity.getKelas());
        }
        if (entity.getMahasiswa() != null){
            this.mahasiswaId = entity.getMahasiswa().getId();
            this.mahasiswa = new MahasiswaModel(entity.getMahasiswa());
        }
    }
}
