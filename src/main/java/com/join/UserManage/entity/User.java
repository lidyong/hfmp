package com.join.UserManage.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "es_user", type = "user")
public class User {
	@Id      //@Field 每个文档的字段配置（类型、是否分词、是否存储、分词器 ）
	@Field(store=true, index = false,type = FieldType.Text)
	private String id;
	@Field(index = true, analyzer = "ik_max_word", store = true, searchAnalyzer = "ik_smart", type = FieldType.Text)
	private String name;
	@Field(index=true, store = true, type = FieldType.Text)
	private String age;
	@Field(index=true, store = true, type = FieldType.Text)
	private String idcard;
}
