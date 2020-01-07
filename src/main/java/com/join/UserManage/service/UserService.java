package com.join.UserManage.service;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.join.UserManage.entity.User;
import com.join.UserManage.esRepository.EsRepository;
import com.join.UserManage.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EsRepository esRepository;
	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;
	
	public String getUinfo(String id) {
		System.out.println("1");
		User user = userMapper.getUserinfo(id);
		return user.getName();
	}
	/***
	 * es操作
	 */
	public User esQueryById(String id) {
		// TODO Auto-generated method stub
		Optional<User> opuser = esRepository.findById(id);
		return opuser.get();
	}

    public String esQuery(String name){
		/*QueryBuilder queryBuilder= QueryBuilders.boolQuery()
				.must(QueryBuilders.matchQuery("name",name));
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
		Page<User> puser =esRepository.search(searchQuery);
		List<User> users= puser.getContent();
		String ret="result:";
		for(User user:users){
			ret+=user.getName()+";";
		}*/
		/*MatchQueryBuilder mathquery= QueryBuilders.matchQuery("name","孙张");
		Iterable<User> itUsers =esRepository.search(mathquery);
		Iterator u  =itUsers.iterator();*/
		SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("name",name)).build();
		List<User> users = elasticsearchTemplate.queryForList(searchQuery,User.class);
		String ret="result:";
		for(User user:users){
			ret+=user.getName()+";";
		}
		return ret;
	}

	public void saveEsDoc(String id, String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		esRepository.save(user);
	}
}
