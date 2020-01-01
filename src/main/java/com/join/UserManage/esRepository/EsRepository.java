package com.join.UserManage.esRepository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.join.UserManage.entity.User;
@Repository
public interface EsRepository extends ElasticsearchRepository<User, String>{

}
