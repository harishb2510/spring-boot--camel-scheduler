package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_product")
@Data
public class STModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;
    private Timestamp created;
    private String created_by;
    private Timestamp modified;
    private String modified_by;
    private String materialId;
    private String materialName;
   private String record_owner;
    private String code;
    private String description;
    private Integer level_number;
    private String name;
    private String sales_spec;
    private Boolean visible;
    private Long base_uom_id;
    private Long material_type_id;
    private Long packaging_id;
    private Long parent_product_id;
    private Long plant_id;
    private String record_status;
    private String uuid;
    private String date_archived;
    private Long transportation_group_id;
    private Long material_group1_id;
    private Long material_group2_id;
    private Long material_group3_id;
    private Long material_group4_id;
}
