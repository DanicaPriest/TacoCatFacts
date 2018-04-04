package mybatis.mappers;

import mybatis.model.CatFacts.OnlyFacts;
import mybatis.model.TacoCat.TacoRoot;
import mybatis.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TacoCatMapper {

    String INSERT_TACOCATFACTS = "INSERT INTO `mybatis-test`.tacocat_facts (name, recipe, url, cat_fact) " +
            "VALUES (#{name}, #{recipe}, #{url}, #{cat_fact})";
    String GET_TACOCATFACT = "SELECT * FROM `mybatis-test`.tacocat_facts where cat_fact = #{cat_fact}";
    String GET_USER = "SELECT * FROM `mybatis-test`.user_verify where user = #{user}";
    String DELETE_CATFACT = "DELETE FROM `mybatis-test`.tacocat_facts  WHERE id = #{id}";
    String INSERT_USER = "INSERT INTO `mybatis-test`.user_verify (user, api_key) " +
            "VALUES (#{user}, #{api_key})";

    @Insert(INSERT_TACOCATFACTS)
    public int insertTacocatFacts(TacoRoot tacoRoot);

    @Select(GET_TACOCATFACT)
    public TacoRoot getTCF(String fact);

    @Select(GET_USER)
    public User getUser(String user);


    @Delete(DELETE_CATFACT)
    public int deleteCF(TacoRoot fact);

    @Insert(INSERT_USER)
    public int insertUser(User user);
}
