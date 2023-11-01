package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.KelasDetailModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_kelas_detail")
public class KelasDetailEntity {
    @Id
    @Column(name = "id", length = 36, unique = true)
    private String id;

    @Column(name = "kelas_id",length = 36, nullable = false)
    private String kelasId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kelas_id", insertable = false, updatable = false)
    private KelasEntity kelas;

    @Column(name = "mahasiswa_id", length = 36, nullable = false)
    private String mahasiswaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mahasiswa_id",  insertable = false, updatable = false)
    private MahasiswaEntity mahasiswa;

    @Column(name = "status", length = 20)
    private String status;

    public KelasDetailEntity(KelasDetailModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
    }

}
