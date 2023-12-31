package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.MatakuliahModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_matakuliah")
public class MatakuliahEntity {
    @Id
    @Column(name = "id",length = 36)
    private String id;

    @Column(name = "code", length = 20, unique = true)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "sks")
    private Integer sks;

    @Column(name = "created_at", length = 20)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "update_at", length = 20)
    private LocalDateTime updateAt;

    @Column(name = "update_by")
    private  String updateBy;

    public MatakuliahEntity(MatakuliahModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.createdBy = "SYSTEM";
        this.updateAt = LocalDateTime.now();
        this.updateBy = "SYSTEM";
    }
}
