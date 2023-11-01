package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.KelasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_kelas")
public class KelasEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "code", length = 20, unique = true)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "name_hari")
    private String nameHari;

    @Temporal(TemporalType.TIME)
    @Column(name = "jam_mulai")
    private Date jamMulai;

    @Temporal(TemporalType.TIME)
    @Column(name = "jam_selesai")
    private Date jamSelesai;

    @Column(name = "status")
    private String status;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "tahun_ajaran")
    private Integer tahunAjaran;

    @Column(name = "kuota")
    private Integer kuota;

    @Column(name = "bisa_online")
    private Boolean bisaOnline;

    @Column(name = "createdAt", length = 20)
    private LocalDateTime createdAt;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "updateAt", length = 20)
    private LocalDateTime updateAt;

    @Column(name = "updateBy")
    private String updateBy;

    @Column(name = "dosen_id")
    private String dosenId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dosen_id", insertable = false, updatable = false)
    private DosenEntity dosen;

    @Column(name = "ruangan_id")
    private String ruanganId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ruangan_id", insertable = false,updatable = false)
    private RuanganEntity ruangan;

    @Column(name = "matakuliah_id")
    private String matakuliahId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matakuliah_id", insertable = false, updatable = false)
    private MatakuliahEntity matakuliah;

    @Column(name = "kelas_detail_id")
    private String kelasDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kelas_")
    private KelasEntity kelasDetail;

    public KelasEntity(KelasModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.createdBy = "SYSTEM";
    }

    public KelasEntity(String id) {
            this.id = id;
        }

}
