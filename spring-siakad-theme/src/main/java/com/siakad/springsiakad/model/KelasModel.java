package com.siakad.springsiakad.model;

import com.siakad.springsiakad.entity.KelasEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KelasModel {
    private String id;
    private String code;
    private String name;
    private String nameHari;
    @DateTimeFormat(pattern = "HH:mm")
    private Date jamMulai;
    @DateTimeFormat(pattern = "HH:mm")
    private Date jamSelesai;
    private String status;
    private Integer semester;
    private Integer tahunAjaran;
    private Integer kuota;
    private Boolean bisaOnline;
    private String dosenId;
    private String dosenName;
    private String ruanganId;
    private String ruanganName;
    private String matakuliahId;
    private String matakuliahName;
    private String kelasDetailId;
    private String kelasDetailName;

    public KelasModel(KelasEntity entity) {
        BeanUtils.copyProperties(entity, this);
        if (entity.getDosen() != null) {
            this.dosenId = entity.getDosenId();
            this.dosenName = entity.getDosen().getName();
        }

        if (entity.getRuangan() != null) {
            this.ruanganId = entity.getRuanganId();
            this.ruanganName = entity.getRuangan().getName();
        }

        if (entity.getMatakuliah() != null) {
            this.matakuliahId = entity.getMatakuliahId();
            this.matakuliahName = entity.getMatakuliah().getName();
        }
    }
}