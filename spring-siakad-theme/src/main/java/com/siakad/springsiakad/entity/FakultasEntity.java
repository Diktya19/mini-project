package com.siakad.springsiakad.entity;

import com.siakad.springsiakad.model.FakultasModel;
import jakarta.persistence.*;
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
@Table(name = "tbl_fakultas")
public class FakultasEntity {
    @Id
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "fakultas_code", length = 10, unique = true)
    private String code;

    @Column(name = "fakultas_name", length = 128)
    private String name;

    @Column(name = "created_at", length = 20)
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "update_at", length = 20)
    private LocalDateTime updateAt;

    @Column(name = "update_by")
    private String updateBy;


    public FakultasEntity(FakultasModel model) {
        BeanUtils.copyProperties(model, this);
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.createdBy = "SYSTEM";
        this.updateAt = LocalDateTime.now();
        this.updateBy = "SYSTEM";
    }

    public FakultasEntity(String id) {
        this.id = id;
    }
}
